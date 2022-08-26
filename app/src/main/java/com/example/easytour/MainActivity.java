package com.example.easytour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    ImageView btn;
    RecyclerView recyclerView;
    FirebaseRecyclerOptions<Data> options;
    FirebaseRecyclerAdapter<Data,MyViewHolder> adapter;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.mostPopularText);
        editText=findViewById(R.id.inputSearch);


        btn = findViewById(R.id.currencyConverter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CurrencyConverterActivity.class);
                startActivity(intent);
            }
        });
        btn = findViewById(R.id.aboutUs);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AboutUsActivity.class);
                startActivity(intent);
            }
        });
        btn = findViewById(R.id.rateUs);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 openDialog();

            }
        });

        btn = findViewById(R.id.weather);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(intent);
            }
        });

        btn = findViewById(R.id.mapp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Data");
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        LoadData("");
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.toString()!=null){
                    LoadData(s.toString());
                }
                else{

                    LoadData("");

                }

            }
        });
    }

    private void openDialog() {

        RatingDialog ratingDialog=new RatingDialog();
        ratingDialog.show(getSupportFragmentManager(),"Rating Dialog");

    }

    private void LoadData(String deta) {

        Query query=databaseReference.orderByChild("Title").startAt(deta).endAt(deta+"\uf8ff");

        options= new FirebaseRecyclerOptions.Builder<Data>().setQuery(query,Data.class).build();
        adapter= new FirebaseRecyclerAdapter<Data, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull  Data model) {
                holder.textView.setText(model.getTitle());
                Picasso.get().load(model.getImage()).into(holder.imageView);
                holder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int pos=holder.getAdapterPosition();
                        if(pos==0) {

                            Intent intent = new Intent(MainActivity.this, ViewSixActivity.class);
                            startActivity(intent);
                        }
                        if(pos==1) {

                            Intent intent = new Intent(MainActivity.this, ViewSevenActivity.class);
                            startActivity(intent);
                        }
                        if(pos==2) {

                            Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                            startActivity(intent);
                        }
                        if(pos==3) {
                            Intent intent = new Intent(MainActivity.this, ViewThreeActivity.class);
                            startActivity(intent);
                        }
                        if(pos==4) {

                            Intent intent = new Intent(MainActivity.this, ViewEightActivity.class);
                            startActivity(intent);
                        }
                        if(pos==5) {

                            Intent intent = new Intent(MainActivity.this, ViewFiveActivity.class);
                            startActivity(intent);
                        }
                        if(pos==6) {
                            Intent intent = new Intent(MainActivity.this, ViewTwoActivity.class);
                            startActivity(intent);
                        }
                        if(pos==7) {
                            Intent intent = new Intent(MainActivity.this, ViewFourActivity.class);
                            startActivity(intent);
                        }

                    }
                });

            }

            @NonNull

            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_data,parent,false);

                return new MyViewHolder(v);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item3:
                confirmDialog();
                break;

            case R.id.item2:
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                break;

            case R.id.item0:
                textView.setVisibility(View.GONE);
                editText.setVisibility(View.VISIBLE);
                break;
            case R.id.subItem3:
                startActivity(new Intent(getApplicationContext(), MapActivity.class));
                break;
            case R.id.subItem1:
                startActivity(new Intent(getApplicationContext(), HotelActivity.class));
                break;
            case R.id.subItem2:
                startActivity(new Intent(getApplicationContext(), WeatherActivity.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void confirmDialog() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Are you sure to Log Out?").setPositiveButton("Log Out", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();


    }

}

