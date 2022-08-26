package com.example.easytour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class TajhatJamidarPalaceActivity extends AppCompatActivity {

    Spinner sp1;
    TextView btn,btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tajhat_jamidar_palace);

        sp1=findViewById(R.id.spneer10);
        btn=findViewById(R.id.txtHotelListRangpur2);
        btn5=findViewById(R.id.tajrate);

        String [] from ={"Friday  10AM–6PM","Saturday 10AM–6PM ","Sunday  Closed","Monday  10AM–6PM ","Tuesday  10AM–6PM","Wednesday  10AM–6PM","Thursday  10AM–6PM"};
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(arrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RangpurHotelActivity.class);
                startActivity(intent);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RangpurHotelActivity.class);
                startActivity(intent);

            }
        });

    }
}