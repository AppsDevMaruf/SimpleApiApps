package com.marufalam.simplerestfulapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoModelAdapter extends RecyclerView.Adapter<PhotoModelAdapter.PhotoModelViewHolder> {
    private List<PhotoModel> photoModels;

    public PhotoModelAdapter(List<PhotoModel> photoModels) {
        this.photoModels = photoModels;
    }

    @NonNull
    @Override
    public PhotoModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_photo_model,parent,false);

        return new PhotoModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoModelViewHolder holder, int position) {
        PhotoModel positionModel = photoModels.get(position);
        Picasso.get()
                .load(positionModel.getThumbnailUrl())
               /* .placeholder(R.drawable.user_placeholder)
                .error(R.drawable.user_placeholder_error)*/
                .into(holder.imageView);
        /*Glide.with(holder.imageView.getContext())
                .load(positionModel.getUrl())
                .centerCrop()
                .error(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageView);*/
       holder.textView1.setText(positionModel.getTitle());
       holder.textView2.setText(positionModel.getUrl());
    }


    @Override
    public int getItemCount() {
        return photoModels.size();
    }

    public static class PhotoModelViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1,textView2;
        public PhotoModelViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
        }
    }
}
