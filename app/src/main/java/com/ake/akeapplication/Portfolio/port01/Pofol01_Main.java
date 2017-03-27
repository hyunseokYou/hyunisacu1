package com.ake.akeapplication.Portfolio.port01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ake.akeapplication.Portfolio.port01.Forecast.Pofol01_Model2;
import com.ake.akeapplication.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Pofol01_Main extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;
    private Pofol01_mapApi mApi;
    private Retrofit mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pofol01_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mRetrofit = new Retrofit.Builder()
                .baseUrl(Pofol01_mapApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApi = mRetrofit.create(Pofol01_mapApi.class);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapLongClickListener(this);
    }

    @Override
    public void onMapLongClick(final LatLng latLng) {
        final double lat = latLng.latitude;
        final double lng = latLng.longitude;

        Call<Pofol01_Model1> weatherCall = mApi.getWeaherData(Pofol01_mapApi.API_KEY, lat, lng);
        weatherCall.enqueue(new Callback<Pofol01_Model1>() {
            @Override
            public void onResponse(final Call<Pofol01_Model1> call, Response<Pofol01_Model1> response) {
                final Pofol01_Model1 result1 = response.body();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy - MM - dd HH:mm:ss", Locale.KOREA);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

                String wLat = simpleDateFormat.format(result1.getSys().getSunrise() * 1000L);
                String wLng = simpleDateFormat.format(result1.getSys().getSunset() * 1000L);

                Marker marker = mMap.addMarker(new MarkerOptions().position(latLng).title(wLat + " || " + wLng));
                marker.showInfoWindow();
                marker.hideInfoWindow();

                final Call<Pofol01_Model2> forecastCall = mApi.getForecastData(Pofol01_mapApi.API_KEY, lat, lng);
                forecastCall.enqueue(new Callback<Pofol01_Model2>() {
                    @Override
                    public void onResponse(Call<Pofol01_Model2> call, Response<Pofol01_Model2> response) {
                        final Pofol01_Model2 result2 = response.body();
                        GoogleMap.OnInfoWindowClickListener gMap = new GoogleMap.OnInfoWindowClickListener() {
                            @Override
                            public void onInfoWindowClick(Marker marker) {
                                Intent intent = new Intent(Pofol01_Main.this, Pofol01_Dialog.class);
                                intent.putExtra("weather", result1);
                                intent.putExtra("forecast", result2);

                                startActivity(intent);
                            }
                        };
                        mMap.setOnInfoWindowClickListener(gMap);
                    }

                    @Override
                    public void onFailure(Call<Pofol01_Model2> call, Throwable t) {
                        Toast.makeText(Pofol01_Main.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<Pofol01_Model1> call, Throwable t) {
                Toast.makeText(Pofol01_Main.this, t.getMessage()
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
