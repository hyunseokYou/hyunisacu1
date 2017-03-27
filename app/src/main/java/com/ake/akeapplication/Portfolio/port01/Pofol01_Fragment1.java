package com.ake.akeapplication.Portfolio.port01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ake.akeapplication.R;

/**
 * Created by 유현석 on 2017-03-20.
 */

public class Pofol01_Fragment1 extends Fragment {
    private TextView mSunRise;
    private TextView mSunrSet;

    private TextView mWindSpeed;
    private TextView mWindDirection;

    private TextView mWeather;
    private TextView mTemperature;

    private TextView mAtmosphere;
    private TextView mHumidity;
    private TextView mVisualrange;

    private Pofol01_Model1 mModel;


    public Pofol01_Fragment1() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pofol01_frame1, container, false);

        mSunRise = (TextView) view.findViewById(R.id.pager1_sunrise);
        mSunrSet = (TextView) view.findViewById(R.id.pager1_sunset);

        mWindSpeed = (TextView) view.findViewById(R.id.pager_windspeed);
        mWindDirection = (TextView) view.findViewById(R.id.pager_winddirection);

        mWeather = (TextView) view.findViewById(R.id.pager1_weather);
        mTemperature = (TextView) view.findViewById(R.id.pager1_temperature);

        mAtmosphere = (TextView) view.findViewById(R.id.pager1_atmosphere);
        mHumidity = (TextView) view.findViewById(R.id.pager1_humidity);
        mVisualrange = (TextView) view.findViewById(R.id.pager1_visualrange);

        mSunRise.setText(mModel.getSys().getSunrise().toString());
        mSunrSet.setText(mModel.getSys().getSunset().toString());

        mWindSpeed.setText(mModel.getWind().getSpeed());
        mWindDirection.setText(mModel.getWind().getDeg());

        mWeather.setText(mModel.getClouds().getAll());
        mTemperature.setText(mModel.getMain().getTemp());

        mAtmosphere.setText(mModel.getMain().getPressure());
        mHumidity.setText(mModel.getMain().getHumidity());
        mVisualrange.setText(mModel.getVisibility());

        return view;
    }



    public void setModel(Pofol01_Model1 model) {
        mModel = model;
    }
}
