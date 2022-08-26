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

public class SylhetHotelActivity extends AppCompatActivity {

    private ListView lvHotel;
    private HotelListAdapter adapter;
    private List<Hotel> mHotelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sylhet_hotel);

        lvHotel= (ListView)findViewById(R.id.listview_product8);
        mHotelList =new ArrayList<>();
        mHotelList.add(new Hotel(1,"Bottom Hill Palace Hotel","5 Star Address:Sylhet town","01700-763512"));
        mHotelList.add(new Hotel(2,"Hotel Payra","5 Star Address:Fatehpur Union","01300-817865"));
        mHotelList.add(new Hotel(3,"Grand Palace Sylhet","5 Star Address:Fatehpur Union","01755-598446"));
        mHotelList.add(new Hotel(4,"Hotel Noorjahan Grand","5 Star Address:Sunamgonj","09610-777888"));
        mHotelList.add(new Hotel(5,"Hotel Valley Garden","5 Star Address:Sunamgonj","0341-63656"));
        mHotelList.add(new Hotel(6,"Hotel Grand Surma","5 Star Address:Sunamgonj","01755-660051"));
        mHotelList.add(new Hotel(7,"NOVEM INN & HOLIDAYS","5 Star Address:Sunamgonj","01709-882000"));
        mHotelList.add(new Hotel(8,"Shuktara Nature Retreat","5 Star Address:Sunamgonj","01764-543535"));
        mHotelList.add(new Hotel(9,"Almas Hotel","5 Star Address:Sunamgonj","01725-988211"));


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