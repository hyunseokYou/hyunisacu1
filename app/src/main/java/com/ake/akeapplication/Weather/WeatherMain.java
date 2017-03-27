package com.ake.akeapplication.Weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

import com.ake.akeapplication.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class WeatherMain extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private ListView mListView;
    private WeatherAdapter mAdapter;
    private List<Weather_Model> mWeatherList;
    private GridView mGrigView;
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api_weather.BASE_URL)
                .build();

        mListView = (ListView) findViewById(R.id.weather_list);
        mGrigView = (GridView) findViewById(R.id.weather_grid);
        mSpinner = (Spinner) findViewById(R.id.weather_spinner);

        mWeatherList = new ArrayList<>();
        mWeatherList.add(new Weather_Model(R.mipmap.ic_launcher, "수원", "27도"));
        mWeatherList.add(new Weather_Model(R.mipmap.ic_launcher, "안양", "26도"));
        mWeatherList.add(new Weather_Model(R.mipmap.ic_launcher, "안산", "28도"));
        mWeatherList.add(new Weather_Model(R.mipmap.ic_launcher, "의왕", "27도"));

        mAdapter = new WeatherAdapter(this, mWeatherList);

        mListView.setAdapter(mAdapter);
        mGrigView.setAdapter(mAdapter);
        mSpinner.setAdapter(mAdapter);

        mListView.setOnItemClickListener(this);
        mListView.setOnItemLongClickListener(this);
        mGrigView.setOnItemClickListener(this);
        mGrigView.setOnItemLongClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mAdapter.setSelect(position);
        mWeatherList.add(new Weather_Model(R.mipmap.ic_launcher, "학원", "열기가 뜨겁다"));

        //데이터가 변경됨을 알려준다
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        mWeatherList.remove(position);
        mAdapter.notifyDataSetChanged();
        return false;
    }
}
