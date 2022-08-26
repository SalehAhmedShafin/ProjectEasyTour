package com.example.easytour;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyDataHolder extends RecyclerView.ViewHolder {

    ImageView imageViews;
    TextView textView1,textView2;
    View view;

    public MyDataHolder(@NonNull  View itemView) {
        super(itemView);
        imageViews=itemView.findViewById(R.id.imageViewa);
        textView1=itemView.findViewById(R.id.textViewb);
        textView2=itemView.findViewById(R.id.textViewc);
        view=itemView;

    }
}
