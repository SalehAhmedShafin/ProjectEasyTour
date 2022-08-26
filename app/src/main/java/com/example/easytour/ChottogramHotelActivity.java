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

public class ChottogramHotelActivity extends AppCompatActivity {

    private ListView lvHotel;
    private HotelListAdapter adapter;
    private List<Hotel> mHotelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chottogram_hotel);


        lvHotel= (ListView)findViewById(R.id.listview_product1);
        mHotelList =new ArrayList<>();
        mHotelList.add(new Hotel(1,"Uni Resort","5 Star Address:Cox's Bazar","01713-160167"));
        mHotelList.add(new Hotel(2,"Hotel D' Oceania","5 Star Address:Cox's Bazar","09942-890321"));
        mHotelList.add(new Hotel(3,"Hotel The Cox Today","5 Star Address:Cox's Bazar","01755-598446"));
        mHotelList.add(new Hotel(4,"Sayeman Beach Resort","5 Star Address:Cox's Bazar","09610-777888"));
        mHotelList.add(new Hotel(5,"White Orchid","5 Star Address:Cox's Bazar","0341-63656"));
        mHotelList.add(new Hotel(6,"Long Beach Hotel Cox's Bazar","5 Star","01755-660051"));
        mHotelList.add(new Hotel(7,"Blue Marine Resort","5 Star Address:Saint Martin","01713-399001"));
        mHotelList.add(new Hotel(8,"Sunset Serenity Resort, St. Martin's Island","5 Star","09672-653421"));
        mHotelList.add(new Hotel(9,"Hotel Heaven beach Resorts","5 Star Address:Saint Martin","01870-059815"));


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