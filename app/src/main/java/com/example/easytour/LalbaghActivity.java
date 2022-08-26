package com.example.easytour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class LalbaghActivity extends AppCompatActivity {

    Spinner sp1;
    TextView btn,btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lalbagh);

        btn=findViewById(R.id.txtHotelListLal);
        btn1=findViewById(R.id.lalrate);
        sp1=findViewById(R.id.spneer);

        String [] from ={"Friday  9AM–12:30PM, 2–5PM","Saturday  9AM–5PM","Sunday  Closed","Monday  1:30–5PM","Tuesday  9AM–5PM","Wednesday  9AM–5PM","Thursday  9AM–5PM"};
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(arrayAdapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LalbaghActivity.this, HotelActivity.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LalbaghActivity.this, RateUsActivity.class);
                startActivity(intent);
            }
        });
    }
}