package com.saigopl.movie_hub.helpUtils;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.saigopl.movie_hub.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DataBindingUtils {

    @BindingAdapter({"dateFormat"})
    public static void dateFormat(TextView textView,String gDate){
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy MMM dd");
        Date date = null;
        try {
            date = originalFormat.parse(gDate);
            String formattedDate = targetFormat.format(date);
            textView.setText(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    @BindingAdapter({"loadPosterImage"})
    public static void loadPosterImage(ImageView imageView,String path){
        Glide.with(imageView.getContext())
                .load("https://image.tmdb.org/t/p/w200/"+path)
                .placeholder(R.drawable.ic_baseline_local_movies_24)
                .into(imageView);
    }

    @BindingAdapter({"loadProfileImage"})
    public static void loadProfileImage(ImageView imageView,String path){
        Glide.with(imageView.getContext())
                .load("https://image.tmdb.org/t/p/w200/"+path)
                .placeholder(R.drawable.ic_baseline_person_24)
                .into(imageView);
    }


}
