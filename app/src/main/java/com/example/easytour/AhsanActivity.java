package com.example.easytour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class AhsanActivity extends AppCompatActivity {

    Spinner sp1;
    TextView btn,btn1,imageView;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahsan);

        sp1=findViewById(R.id.spneer1);
        btn=findViewById(R.id.txtHotelListAha);
        btn1=findViewById(R.id.ahrate);
        imageView=findViewById(R.id.imageViewPhotoAhsan);

        String [] from ={"Friday  3–8PM","Saturday 10:30AM–5:30PM ","Sunday  10:30AM–5:30PM","Monday  10:30AM–5:30PM ","Tuesday  10:30AM–5:30PM","Wednesday  10:30AM–5:30PM","Thursday  Closed"};
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(arrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AhsanActivity.this, HotelActivity.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), RateUsActivity.class);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), AhsanPhotosActivity.class);
                startActivity(intent);
            }
        });
    }
}