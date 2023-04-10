package com.saigopl.movie_hub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.LoadState;
import androidx.paging.LoadStateAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.saigopl.movie_hub.R;
import com.saigopl.movie_hub.databinding.LoadingFooterBinding;

public class LoadingStateAdapter extends LoadStateAdapter<LoadingStateAdapter.ViewHolder> {

    Context context;

    public LoadingStateAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @NonNull LoadState loadState) {
        if(loadState instanceof LoadState.Error){
            LoadState.Error loadStateError = (LoadState.Error) loadState;
            viewHolder.binding.progressCircular.setVisibility(View.GONE);
            viewHolder.binding.errorText.setVisibility(View.VISIBLE);
            viewHolder.binding.errorText.setText(loadStateError.getError().getLocalizedMessage());
        }
        if(loadState instanceof LoadState.Loading){
            viewHolder.binding.progressCircular.setVisibility(View.VISIBLE);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, @NonNull LoadState loadState) {

        LoadingFooterBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.loading_footer,viewGroup,false);

        return new ViewHolder(binding);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LoadingFooterBinding binding;
        public ViewHolder(@NonNull LoadingFooterBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
