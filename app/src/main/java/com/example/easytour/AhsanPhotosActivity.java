package com.example.easytour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class AhsanPhotosActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseRecyclerOptions<Photo> options;
    FirebaseRecyclerAdapter<Photo,MyPhotoHolder> adapter;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahsan_photos);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Photo");
        recyclerView=findViewById(R.id.recyclerViewPhoto);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        LoadData();
    }

    private void LoadData() {

        options = new FirebaseRecyclerOptions.Builder<Photo>().setQuery(databaseReference, Photo.class).build();
        adapter=new FirebaseRecyclerAdapter<Photo, MyPhotoHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull  MyPhotoHolder holder, int position,  Photo model) {

                Picasso.get().load(model.getPhoto()).into(holder.imageViews);

            }

            @NonNull

            @Override
            public MyPhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_view,parent,false);

                return new MyPhotoHolder(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}