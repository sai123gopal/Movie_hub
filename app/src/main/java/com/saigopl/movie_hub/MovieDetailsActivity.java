package com.saigopl.movie_hub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

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
    MoviesViewModel moviesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie_details);
        binding.setLifecycleOwner(this);

        movieId = getIntent().getFloatExtra("movieId",0F);
        apiInterface = RetrofitClint.getRetrofit().create(APIInterface.class);
        moviesViewModel = new ViewModelProvider(this).get(MoviesViewModel.class);

        if(movieId != 0F){
            moviesViewModel.movieId.setValue((int) movieId);
            moviesViewModel.getAllMovieDetails();
        }

        observeLiveData();

    }

    private void observeLiveData() {
        moviesViewModel.generalMovieDetails.observe(this, movieDetails -> {
            if (movieDetails != null) {
                binding.setModel(movieDetails);
                binding.setGenresString(getGenresListString(movieDetails.getGenres()));
                binding.setRuntime(getRuntime(movieDetails.getRuntime()));
            }
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