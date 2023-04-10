package com.saigopl.movie_hub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.saigopl.movie_hub.adapters.OnGoingMoviesRecyclerAdapter;
import com.saigopl.movie_hub.databinding.ActivityMainBinding;
import com.saigopl.movie_hub.helpUtils.OnGoingMoviesDiffUtils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ActivityMainBinding binding;
    OnGoingMoviesViewModel moviesViewModel;

    OnGoingMoviesRecyclerAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setLifecycleOwner(this);

        moviesViewModel = new ViewModelProvider(this).get(OnGoingMoviesViewModel.class);

        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        moviesViewModel.getOnGoingMovieDetailsList();

        adapter = new OnGoingMoviesRecyclerAdapter(new OnGoingMoviesDiffUtils(),this);

        binding.recycler.setAdapter(adapter);


        moviesViewModel.movieDetailsList.observe(this, ongoingMovieDetailsPagingData ->
                adapter.submitData(getLifecycle(),ongoingMovieDetailsPagingData));



    }


}