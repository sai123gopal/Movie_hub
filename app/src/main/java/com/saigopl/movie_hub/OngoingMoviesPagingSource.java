package com.saigopl.movie_hub;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagingState;
import androidx.paging.rxjava2.RxPagingSource;

import com.saigopl.movie_hub.models.OngoingMovieDetails;
import com.saigopl.movie_hub.models.OngoingMovieResults;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class OngoingMoviesPagingSource extends RxPagingSource<Integer, OngoingMovieDetails> {

    private APIInterface apiInterface;
    private boolean isListEnded = false;
    private int page =1;

    public OngoingMoviesPagingSource() {
        this.apiInterface = RetrofitClint.getRetrofit().create(APIInterface.class);
    }

    @Nullable
    @Override
    public Integer getRefreshKey(@NotNull PagingState<Integer, OngoingMovieDetails> state) {
        Integer anchorPosition = state.getAnchorPosition();
        if (anchorPosition == null) {
            return null;
        }

        LoadResult.Page<Integer, OngoingMovieDetails> anchorPage = state.closestPageToPosition(anchorPosition);
        if (anchorPage == null) {
            return null;
        }

        Integer prevKey = anchorPage.getPrevKey();
        if (prevKey != null) {
            return prevKey + 1;
        }

        Integer nextKey = anchorPage.getNextKey();
        if (nextKey != null) {
            return nextKey - 1;
        }

        return null;
    }

    @NonNull
    @Override
    public Single<LoadResult<Integer, OngoingMovieDetails>> loadSingle(@NonNull LoadParams<Integer> loadParams) {

        page = loadParams.getKey() != null ? loadParams.getKey() : 1;


        return  apiInterface.getOnGoingMovieResults(Utils.apiKey,Utils.language,page)
                .subscribeOn(Schedulers.io())
                .map(responcse -> toLoadResults(responcse.body().getDetails(),page))
                .onErrorReturn(LoadResult.Error::new);
    }

    public LoadResult<Integer,OngoingMovieDetails> toLoadResults(List<OngoingMovieDetails> movieResults, Integer pageNo){
        if(isListEnded){
            pageNo = null;
        }else {
            pageNo = page;
        }
        return new LoadResult.Page<Integer, OngoingMovieDetails>(movieResults,pageNo);
    }

}
