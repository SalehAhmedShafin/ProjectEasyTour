package com.example.easytour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ViewEightActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    FirebaseRecyclerOptions<Item> options;
    FirebaseRecyclerAdapter<Item,MyDataHolder> adapter;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_eight);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Mymensingh");
        recyclerView=findViewById(R.id.recyclerViewMym);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        LoadsData();
    }

    private void LoadsData() {

        options = new FirebaseRecyclerOptions.Builder<Item>().setQuery(databaseReference, Item.class).build();
        adapter = new FirebaseRecyclerAdapter<Item, MyDataHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyDataHolder holder, int position, @NonNull Item model) {

                holder.textView1.setText(model.getTitle());
                holder.textView2.setText(model.getDetails());
                Picasso.get().load(model.getImage()).into(holder.imageViews);
                holder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();
                        if (pos == 0) {
                            Intent intent = new Intent(getApplicationContext(), HasanMonjilActivity.class);
                            startActivity(intent);
                        }
                        if (pos == 1) {
                            Intent intent = new Intent(getApplicationContext(), AlexanderCastleActivity.class);
                            startActivity(intent);
                        }
                    }
                });

            }

            @NonNull

            @Override
            public MyDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_data, parent, false);

                return new MyDataHolder(v);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}