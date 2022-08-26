package com.example.easytour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MoinamatiActivity extends AppCompatActivity {

    Spinner sp1;
    TextView btn,btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moinamati);

        sp1=findViewById(R.id.spneer3);
        btn=findViewById(R.id.txtHotelListCumilla);
        btn1=findViewById(R.id.marate);

        String [] from ={"Friday  10AM–5PM","Saturday 10AM–5PM ","Sunday  Closed","Monday  Closed ","Tuesday  10AM–5PM","Wednesday  10AM–5PM","Thursday  10AM–5PM"};
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(arrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), CumillaHotelActivity.class);
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
    }
}