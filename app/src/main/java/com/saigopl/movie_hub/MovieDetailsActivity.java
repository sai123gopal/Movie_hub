package com.saigopl.movie_hub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.saigopl.movie_hub.adapters.CastRecyclerAdapter;
import com.saigopl.movie_hub.databinding.ActivityMovieDetailsBinding;
import com.saigopl.movie_hub.helpUtils.Utils;
import com.saigopl.movie_hub.models.Cast;
import com.saigopl.movie_hub.models.Credits;
import com.saigopl.movie_hub.models.MovieDetails;
import com.saigopl.movie_hub.models.SimilarMovieDetails;
import com.saigopl.movie_hub.models.SimilarMovies;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsActivity extends AppCompatActivity {

    ActivityMovieDetailsBinding binding;
    APIInterface apiInterface;
    float movieId ;
    MoviesViewModel moviesViewModel;
    CastRecyclerAdapter castRecyclerAdapter;
    ArrayList<Cast> castArrayList ;
    ArrayList<SimilarMovieDetails> similarMovieDetailsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie_details);
        binding.setLifecycleOwner(this);

        movieId = getIntent().getFloatExtra("movieId",0F);
        apiInterface = RetrofitClint.getRetrofit().create(APIInterface.class);
        moviesViewModel = new ViewModelProvider(this).get(MoviesViewModel.class);
        castArrayList= new ArrayList<>();
        similarMovieDetailsArrayList = new ArrayList<>();

        if(movieId != 0F){
            moviesViewModel.movieId.setValue((int) movieId);
            moviesViewModel.getAllMovieDetails();
        }

        binding.castRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        castRecyclerAdapter = new CastRecyclerAdapter(castArrayList,this);

        binding.castRecycler.setAdapter(castRecyclerAdapter);

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

        moviesViewModel.movieCredits.observe(this, credits -> {
            if(credits.getCasts() != null){
                castArrayList.addAll(credits.getCasts());
                castRecyclerAdapter.notifyDataSetChanged();
            }
        });

        moviesViewModel.similarMoviesMutableLiveData.observe(this, similarMovies -> {

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
        return genresString.toString();
    }

    public String getRuntime(float runtime){
        float hours   = runtime / 60;
        float minutes = runtime % 60;

        return  (int)hours+"hr "+(int)minutes+"min";
    }

}