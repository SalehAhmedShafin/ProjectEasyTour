package com.example.easytour;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyPhotoHolder extends RecyclerView.ViewHolder{

    ImageView imageViews;

    public MyPhotoHolder(View itemView){
        super(itemView);
        imageViews=itemView.findViewById(R.id.imageViewPhoto);
    }
}
