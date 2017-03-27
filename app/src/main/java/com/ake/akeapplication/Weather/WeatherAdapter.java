package com.ake.akeapplication.Weather;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ake.akeapplication.R;

import java.util.List;

/**
 * Created by 유현석 on 2017-03-13.
 */

public class WeatherAdapter extends BaseAdapter {
    private Context mContext;
    private List<Weather_Model> mData;

    public WeatherAdapter(Context context, List<Weather_Model> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.activity_weather_item, parent, false);

            ImageView imageView = (ImageView) convertView.findViewById(R.id.weather_image);
            TextView locationTextView = (TextView) convertView.findViewById(R.id.location_text);
            TextView temperatureTextView = (TextView) convertView.findViewById(R.id.temperature_text);

            viewHolder.weatherImage = imageView;
            viewHolder.locationTextView = locationTextView;
            viewHolder.temperatureTextView = temperatureTextView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Weather_Model weather = mData.get(position);

        viewHolder.weatherImage.setImageResource(weather.getImageRes());
        viewHolder.locationTextView.setText(weather.getLocation());
        viewHolder.temperatureTextView.setText(weather.getTemperatue());

        if (position % 2 == 1) {
            convertView.setBackgroundColor(Color.GREEN);
        } else {
            convertView.setBackgroundColor(Color.WHITE);
        }

        if (mSeletedPosition == position) {
            convertView.setBackgroundColor(Color.RED);
        }

        return convertView;
    }

    private int mSeletedPosition = -1;

    public void setSelect(int position) {
        mSeletedPosition = position;
    }

    private static class ViewHolder {
        ImageView weatherImage;
        TextView locationTextView;
        TextView temperatureTextView;
    }
}
