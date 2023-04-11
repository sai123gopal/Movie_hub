package com.saigopl.movie_hub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.saigopl.movie_hub.databinding.ActivityMovieDetailsBinding;
import com.saigopl.movie_hub.helpUtils.Utils;
import com.saigopl.movie_hub.models.MovieDetails;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsActivity extends AppCompatActivity {

    ActivityMovieDetailsBinding binding;
    APIInterface apiInterface;
    float movieId ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie_details);
        binding.setLifecycleOwner(this);

        movieId = getIntent().getFloatExtra("movieId",0F);
        apiInterface = RetrofitClint.getRetrofit().create(APIInterface.class);

        if(movieId != 0F){
            getMovieDetails();
        }


    }

    private void getMovieDetails() {
        apiInterface.getMovieDetails( (int) movieId,Utils.apiKey,Utils.language)
                .enqueue(new Callback<MovieDetails>() {
                    @Override
                    public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {
                        if(response.isSuccessful()){
                            if (response.body() != null){
                                binding.setModel(response.body());
                                binding.setGenresString(getGenresListString(response.body().getGenres()));
                                binding.setRuntime(getRuntime(response.body().getRuntime()));
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieDetails> call, Throwable t) {}
                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public String getGenresListString(ArrayList<MovieDetails.Genres> list){
        StringBuilder genresString = new StringBuilder();
        for(int i=0;i<list.size();i++) {
            if(genresString.toString().equals("")){
                genresString = new StringBuilder(list.get(i).getName());
            }else {
                genresString.append(", ").append(list.get(i).getName());
            }
        }
        return genresString.toString().toString();
    }

    public String getRuntime(float runtime){
        float hours   = runtime / 60;
        float minutes = runtime % 60;

        return  (int)hours+"hr "+(int)minutes+"min";
    }

}