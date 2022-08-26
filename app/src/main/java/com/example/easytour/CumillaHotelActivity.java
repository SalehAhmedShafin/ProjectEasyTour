package com.example.easytour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CumillaHotelActivity extends AppCompatActivity {

    private ListView lvHotel;
    private HotelListAdapter adapter;
    private List<Hotel> mHotelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cumilla_hotel);


        lvHotel= (ListView)findViewById(R.id.listview_product2);
        mHotelList =new ArrayList<>();
        mHotelList.add(new Hotel(1,"Hotel Victory Abashik","3 Star Address:Mainamati","01714-030094"));
        mHotelList.add(new Hotel(2,"Q Palace","5 Star Address:Mainamati","01998-800900"));
        mHotelList.add(new Hotel(3,"Hotel Sky Vision","5 Star Address:Cumilla Town","01755-598446"));
        mHotelList.add(new Hotel(4,"Nawab Palace Resort","5 Star Address:Cumilla Town","01321-124565"));
        mHotelList.add(new Hotel(5,"White Orchid","5 Star Address:Cumilla Town","0341-63656"));



        adapter= new HotelListAdapter(getApplicationContext(), mHotelList);
        lvHotel.setAdapter(adapter);

        lvHotel.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+view.getTag()));
                startActivity(intent);
            }
        });
    }
}