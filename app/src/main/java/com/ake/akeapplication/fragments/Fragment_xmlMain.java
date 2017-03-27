package com.ake.akeapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.ake.akeapplication.R;

/**
 * Created by 유현석 on 2017-02-20.
 */

public class Fragment_xmlMain extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;
    private FrameLayout mContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);

        mContainer = (FrameLayout) findViewById(R.id.frame_1);
        mButton = (Button) findViewById(R.id.button1);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Fragment_xml1 fragment = Fragment_xml1.newInstance("프래그먼트", "예제입니다");
        getSupportFragmentManager().beginTransaction().add(R.id.frame_1, fragment).commit();
    }
}
