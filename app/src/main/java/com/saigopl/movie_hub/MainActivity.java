package com.saigopl.movie_hub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.saigopl.movie_hub.databinding.ActivityMainBinding;
import com.saigopl.movie_hub.models.OngoingMovieResults;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ActivityMainBinding binding;
    private  APIInterface apiInterface ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setLifecycleOwner(this);



       apiInterface = RetrofitClint.getRetrofit().create(APIInterface.class);






    }

//    apiInterface.getOnGoingMovieResults(Utils.apiKey,Utils.language,1)
//            .enqueue(new Callback<OngoingMovieResults>() {
//        @Override
//        public void onResponse(Call<OngoingMovieResults> call, Response<OngoingMovieResults> response) {
//            if(response.isSuccessful()){
//                if(response.body() != null) {
//                    Toast.makeText(MainActivity.this, response.body().getDetails().get(0).getTitle(), Toast.LENGTH_SHORT).show();
//                }
//            }else {
//                Toast.makeText(MainActivity.this, ""+response.errorBody(), Toast.LENGTH_SHORT).show();
//                Log.d(TAG, "onResponse: error"+response.errorBody());
//            }
//        }
//
//        @Override
//        public void onFailure(Call<OngoingMovieResults> call, Throwable t) {
//            Log.d(TAG, "onResponse: failure"+ t.getLocalizedMessage());
//        }
//    });



}