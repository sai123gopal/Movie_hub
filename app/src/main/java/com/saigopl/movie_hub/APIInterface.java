package com.saigopl.movie_hub;

import com.saigopl.movie_hub.models.OngoingMovieResults;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("now_playing")
    Single<OngoingMovieResults> getOnGoingMovieResults(@Query("api_key") String apiKey,
                                                                @Query("language") String language,
                                                                @Query("page") int page);





}
