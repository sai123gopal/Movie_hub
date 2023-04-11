package com.saigopl.movie_hub;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingLiveData;

import com.saigopl.movie_hub.helpUtils.Utils;
import com.saigopl.movie_hub.models.Credits;
import com.saigopl.movie_hub.models.MovieDetails;
import com.saigopl.movie_hub.models.OngoingMovieDetails;

import java.io.IOException;

import kotlinx.coroutines.CoroutineScope;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesViewModel extends AndroidViewModel {

    LiveData<PagingData<OngoingMovieDetails>> movieDetailsList ;
    APIInterface apiInterface ;
    MutableLiveData<Integer> movieId;
    MutableLiveData<MovieDetails> generalMovieDetails;
    MutableLiveData<Credits> movieCredits;



    public MoviesViewModel(@NonNull Application application) {
        super(application);

        apiInterface = RetrofitClint.getRetrofit().create(APIInterface.class);
        movieId = new MutableLiveData<>(0);
        generalMovieDetails = new MutableLiveData<>();
        movieCredits = new MutableLiveData<>();

    }


    public void getOnGoingMovieDetailsList(){
        Pager<Integer,OngoingMovieDetails> pager = new Pager<>(
                new PagingConfig(20,1,false,20),
                ()-> new OngoingMoviesPagingSource(apiInterface)
        );

        CoroutineScope coroutineScope = ViewModelKt.getViewModelScope(this);
        movieDetailsList = PagingLiveData.cachedIn(PagingLiveData.getLiveData(pager),coroutineScope);
    }

    public void getAllMovieDetails(){
        getMovieDetails();
        getMovieCreditsDetails();
    }


    private void getMovieCreditsDetails(){
        apiInterface.getMovieCredits(movieId.getValue(), Utils.apiKey,Utils.language)
                .enqueue(new Callback<Credits>() {
                    @Override
                    public void onResponse(Call<Credits> call, Response<Credits> response) {
                        if(response.isSuccessful()){
                            if (response.body() != null){
                                movieCredits.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Credits> call, Throwable t) {

                    }
                });
    }


    private void getMovieDetails() {
        apiInterface.getMovieDetails( movieId.getValue(), Utils.apiKey,Utils.language)
                .enqueue(new Callback<MovieDetails>() {
                    @Override
                    public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {
                        if(response.isSuccessful()){
                            if (response.body() != null){
                                generalMovieDetails.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieDetails> call, Throwable t) {
                        Log.e("movie", "onResponse:  error "+t.getLocalizedMessage());
                    }
                });
    }



}


