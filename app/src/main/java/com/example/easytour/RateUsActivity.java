package com.example.easytour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hsalf.smilerating.SmileRating;
import com.hsalf.smileyrating.SmileyRating;

public class RateUsActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);

        ratingBar=(RatingBar)findViewById(R.id.ratingBarId);
        textView=(TextView)findViewById(R.id.textViewId);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textView.setText("Your Give: "+rating+" Star");
            }
        });


    }
}