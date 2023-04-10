package com.saigopl.movie_hub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.saigopl.movie_hub.databinding.ActivityMovieDetailsBinding;

public class MovieDetailsActivity extends AppCompatActivity {

    ActivityMovieDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie_details);
        binding.setLifecycleOwner(this);



    }
}