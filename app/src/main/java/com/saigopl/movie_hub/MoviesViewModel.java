package com.saigopl.movie_hub;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingLiveData;

import com.saigopl.movie_hub.models.OngoingMovieDetails;

import kotlinx.coroutines.CoroutineScope;

public class MoviesViewModel extends AndroidViewModel {

    LiveData<PagingData<OngoingMovieDetails>> movieDetailsList ;
    APIInterface apiInterface ;



    public MoviesViewModel(@NonNull Application application) {
        super(application);

        apiInterface = RetrofitClint.getRetrofit().create(APIInterface.class);

    }


    public void getOnGoingMovieDetailsList(){
        Pager<Integer,OngoingMovieDetails> pager = new Pager<>(
                new PagingConfig(20,1,false,20),
                ()-> new OngoingMoviesPagingSource(apiInterface)
        );

        CoroutineScope coroutineScope = ViewModelKt.getViewModelScope(this);
        movieDetailsList = PagingLiveData.cachedIn(PagingLiveData.getLiveData(pager),coroutineScope);
    }

}


