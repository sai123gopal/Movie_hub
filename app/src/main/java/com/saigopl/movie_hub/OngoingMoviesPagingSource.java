package com.saigopl.movie_hub;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagingState;
import androidx.paging.rxjava3.RxPagingSource;


import com.saigopl.movie_hub.helpUtils.Utils;
import com.saigopl.movie_hub.models.OngoingMovieDetails;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class OngoingMoviesPagingSource extends RxPagingSource<Integer, OngoingMovieDetails> {

    private final APIInterface apiInterface;
    private boolean isListEnded = false;
    private int page = 1;

    public OngoingMoviesPagingSource(APIInterface apiInterface) {
        this.apiInterface = apiInterface;
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
                .map(responcse -> {
                    if(responcse == null || responcse.getDetails().size()==0){
                        isListEnded = true;
                    }
                    return toLoadResults(responcse.getDetails());
                })
                .onErrorReturn(LoadResult.Error::new);
    }

   public LoadResult<Integer,OngoingMovieDetails> toLoadResults(List<OngoingMovieDetails> movieDetails){

        if(isListEnded){
            page = Integer.parseInt(null);
        }else {
            page = page+1;
        }
        return new LoadResult.Page<>(movieDetails, null, page);
   }

}
