package com.example.easytour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity {
    EditText etCity;
    TextView tvResult;

    private final String url = "http://maps.openweathermap.org/data/2.0/weather ";
    private final  String appid="03eb1c59edf167b0e3a6ca9e087980ec";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        etCity=findViewById(R.id.etCity);
        tvResult=findViewById(R.id.tvResult);
    }

    public void getWeatherDetails(View view) {
        String tempUrl="";
        String city=etCity.getText().toString().trim();
        if(city.isEmpty()){
            tvResult.setText("City Cannot be Empty");
        }
        else{

            StringRequest stringRequest =new StringRequest(Request.Method.POST, tempUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    String output ="";
                    try {
                        JSONObject jsonObject=new JSONObject(response);
                        JSONArray jsonArray= jsonObject.getJSONArray("weather");
                        JSONObject jsonObjectWeather= jsonArray.getJSONObject(0);
                        String description =jsonObjectWeather.getString("description");
                        JSONObject jsonObjectMain = jsonObject.getJSONObject("main");
                        double temp =jsonObjectMain.getDouble("temp")-273.15;
                        double feelsLike=jsonObjectMain.getDouble("feels_like")-273.15;
                        float pressure=jsonObjectMain.getInt("pressure");
                        int humidity=jsonObjectMain.getInt("humidity");
                        JSONObject jsonObjectWind =jsonObject.getJSONObject("wind");
                        String wind= jsonObjectWind.getString("speed");
                        JSONObject jsonObjectClouds= jsonObject.getJSONObject("clouds");
                        String clouds=jsonObjectClouds.getString("all");
                        JSONObject jsonObjectSys= jsonObject.getJSONObject("sys");
                        String countryName= jsonObjectSys.getString("country");
                        String cityName=jsonObject.getString("name");

                        output+="Current weather of"+cityName+"("+countryName+")"+"\n Temp: "+temp+"celcius";
                    }
                    catch (JSONException e){

                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),error.toString().trim(),Toast.LENGTH_SHORT).show();
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);

        }

    }
}