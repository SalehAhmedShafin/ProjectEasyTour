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

public class HotelActivity extends AppCompatActivity {

    private ListView lvHotel;
    private HotelListAdapter adapter;
    private List<Hotel> mHotelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);


        lvHotel= (ListView)findViewById(R.id.listview_product);
        mHotelList =new ArrayList<>();
        mHotelList.add(new Hotel(1,"Radison,Dhaka","5 Star Address: Airport Road","+1 833-702-0544"));
        mHotelList.add(new Hotel(2,"Sheraton Hotel,Dhaka","5 Star Address: Gulshan","09942-890321"));
        mHotelList.add(new Hotel(3,"Pan Pacific Sonargaon,Dhaka","5 Star Address: Sonargaon Road","01932-123412"));
        mHotelList.add(new Hotel(4,"Le Meridien,Dhaka","5 Star Address: Khilkhet","09638-900089"));
        mHotelList.add(new Hotel(5,"Shinepukur Suites","5 Star Address: Gulshan-1","01717-777777"));
        mHotelList.add(new Hotel(6,"Hotel Shuktara","5 Star Address: Indira Road","01313-890000"));
        mHotelList.add(new Hotel(7,"Hotel Grand Plaza","5 Star Address: Uttara","01264-231232"));
        mHotelList.add(new Hotel(8,"Hotel Fountain","5 Star Address: Kobi Faruk Saroni","09672-653421"));
        mHotelList.add(new Hotel(9,"Sky City Hotel Dhaka","5 Star Address: Dhaka","09324-768901"));


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