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

public class KhulnaHotelActivity extends AppCompatActivity {

    private ListView lvHotel;
    private HotelListAdapter adapter;
    private List<Hotel> mHotelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khulna_hotel);


        lvHotel= (ListView)findViewById(R.id.listview_product3);
        mHotelList =new ArrayList<>();
        mHotelList.add(new Hotel(1,"Tiger Garden Int. Hotel, Khulna","3 Star Address:Khulna City","01714-030094"));
        mHotelList.add(new Hotel(2,"Jatra Flagship Khulna City Centre","5 Star Address:Khulna City","01998-800900"));
        mHotelList.add(new Hotel(3,"Hotel City Inn Ltd.","5 Star Address:Bagerhat","01755-598446"));
        mHotelList.add(new Hotel(4,"Hotel Royal International","5 Star Address:Bagerhat","01718-679900"));
        mHotelList.add(new Hotel(5,"Hotel Castle Salam","5 Star Address:Bagerhat","01833-321168"));
        mHotelList.add(new Hotel(6,"The Grand Placid","5 Star Address:Near Sundorban","01312-347373"));



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