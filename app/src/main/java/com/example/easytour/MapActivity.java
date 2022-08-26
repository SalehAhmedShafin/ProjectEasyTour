package com.example.easytour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MapActivity extends AppCompatActivity {

    EditText etSource,etDestination;
    Button btTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        etSource=findViewById(R.id.et_source);
        etDestination=findViewById(R.id.et_destination);
        btTrack=findViewById(R.id.bt_Track);

        btTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source= etSource.getText().toString().trim();
                String destination= etDestination.getText().toString().trim();
                DisplayTrack(source,destination);
            }

            private void DisplayTrack(String source, String destination) {

                try {

                    Uri uri=Uri.parse("http://www.google.co.in/maps/dir/"+source+"/"+destination);
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }catch (ActivityNotFoundException e){

                    Uri uri = Uri.parse("http://play.google.com/store/apps/details?id=com.google.android.apps.maps");
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
            }
        });
    }
}