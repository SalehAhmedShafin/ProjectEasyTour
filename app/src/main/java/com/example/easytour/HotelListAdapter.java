package com.example.easytour;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class HotelListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Hotel> mHotelList;

    public HotelListAdapter(Context mContext, List<Hotel> mHospitalList) {
        this.mContext=mContext;
        this.mHotelList=mHospitalList;
    }

    @Override
    public int getCount() {
       return mHotelList.size();
    }

    @Override
    public Object getItem(int position) {
        return mHotelList.get(position);
    }

    @Override
    public long getItemId(int position) {
       return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v= View.inflate(mContext,R.layout.item_product_list,null);
        TextView hName=(TextView)v.findViewById(R.id.hotel_name);
        TextView hRate=(TextView)v.findViewById(R.id.hotel_star);
        TextView hNumber=(TextView)v.findViewById(R.id.hotel_number);
        hName.setText(mHotelList.get(position).getName());
        hRate.setText(mHotelList.get(position).getRate());
        hNumber.setText(mHotelList.get(position).getNum());

        v.setTag(mHotelList.get(position).getNum());
        return v;
    }
}
