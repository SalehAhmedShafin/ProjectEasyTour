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

public class RajshahiHotelActivity extends AppCompatActivity {

    private ListView lvHotel;
    private HotelListAdapter adapter;
    private List<Hotel> mHotelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajshahi_hotel);

        lvHotel= (ListView)findViewById(R.id.listview_product6);
        mHotelList =new ArrayList<>();
        mHotelList.add(new Hotel(1,"Jatra Flagship Rajshahi City Centre","3 Star Address:Rajshahi City","01309-552872"));
        mHotelList.add(new Hotel(2,"Hotel Nice International","5 Star Address:Natore","0721-771808"));
        mHotelList.add(new Hotel(3,"Hotel Sukarna Int. Residential","5 Star Address:Natore","01711-811014"));
        mHotelList.add(new Hotel(4,"Warisan Residential Hotel","5 Star Address:Natore" ,"01730-706258"));
        mHotelList.add(new Hotel(5,"Pakshi Resort","5 Star Address:Bogra","01755-661199"));
        mHotelList.add(new Hotel(6,"Momo Inn Hotel & Resort","5 Star Address:Bogra","051-62504"));



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