package com.ake.akeapplication.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ake.akeapplication.R;

/**
 * Created by 유현석 on 2017-02-20.
 */

public class Fragment_Color_list_Main extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);
    }

    private void addFragment(int containerId, int color, String text) {
        Fragment_Color_list2 fragment_color_list = new Fragment_Color_list2();
        fragment_color_list.setColor(color);
        fragment_color_list.setText(text);
        getSupportFragmentManager().beginTransaction().add(containerId, fragment_color_list).commit();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                addFragment(R.id.frame_1, Color.RED, "1번 프래그먼트");
                break;
            case R.id.button2:
                addFragment(R.id.frame_2, Color.BLUE, "2번 프래그먼트");
                break;
            case R.id.button3:
                addFragment(R.id.frame_3, Color.YELLOW, "3번 프래그먼트");
                break;
        }

    }
}
