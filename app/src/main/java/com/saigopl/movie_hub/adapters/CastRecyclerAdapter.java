package com.saigopl.movie_hub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.saigopl.movie_hub.R;
import com.saigopl.movie_hub.databinding.CastItemsBinding;
import com.saigopl.movie_hub.models.Cast;

import java.util.ArrayList;

public class CastRecyclerAdapter extends RecyclerView.Adapter<CastRecyclerAdapter.ViewHolder> {

    ArrayList<Cast> castArrayList ;
    Context context;

    public CastRecyclerAdapter(ArrayList<Cast> castArrayList, Context context) {
        this.castArrayList = castArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CastItemsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.cast_items,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.binding.setModel(castArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return castArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CastItemsBinding binding;
        public ViewHolder(@NonNull CastItemsBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
