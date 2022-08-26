package com.example.easytour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SixtyDomeActivity extends AppCompatActivity {

    Spinner sp1;
    TextView btn,btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixty_dome);

        sp1=findViewById(R.id.spneerSix);
        btn=findViewById(R.id.txtHotelListkhulna);
        btn1=findViewById(R.id.sixtyrate);


        String [] from ={"Friday  8PM–6AM","Saturday 8PM–12AM ","Sunday  12AM–6PM, 8PM–12AM","Monday  8PM–12AM ","Tuesday  8PM–12AM","Wednesday  8PM–12AM","Thursday  8PM–12AM"};
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(arrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), KhulnaHotelActivity.class);
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