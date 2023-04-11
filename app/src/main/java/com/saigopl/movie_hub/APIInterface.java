package com.saigopl.movie_hub;

import com.saigopl.movie_hub.models.Credits;
import com.saigopl.movie_hub.models.MovieDetails;
import com.saigopl.movie_hub.models.OngoingMovieResults;
import com.saigopl.movie_hub.models.Reviews;
import com.saigopl.movie_hub.models.SimilarMovies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("now_playing")
    Single<OngoingMovieResults> getOnGoingMovieResults(@Query("api_key") String apiKey,
                                                                 @Query("language") String language,
                                                                 @Query("page") int page);


    @GET("{movie_id}")
    Call<MovieDetails> getMovieDetails(@Path("movie_id") int movieId,
                                       @Query("api_key") String apiKey,
                                       @Query("language") String language);



    @GET("{movie_id}/credits")
    Call<Credits> getMovieCredits(@Path("movie_id") int movieId,
                                  @Query("api_key") String apiKey,
                                  @Query("language") String language);

    @GET("{movie_id}/similar")
    Call<SimilarMovies> getSimilarMovies(@Path("movie_id") int movieId,
                                   @Query("api_key") String apiKey,
                                   @Query("language") String language,
                                         @Query("page") int page);


    @GET("{movie_id}/reviews")
    Call<Reviews> getMovieReviews(@Path("movie_id") int movieId,
                                  @Query("api_key") String apiKey,
                                  @Query("language") String language,
                                  @Query("page") int page);


}
