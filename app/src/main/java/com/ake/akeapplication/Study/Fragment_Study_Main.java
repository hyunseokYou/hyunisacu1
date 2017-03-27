package com.ake.akeapplication.Study;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ake.akeapplication.R;

/**
 * Created by 유현석 on 2017-02-25.
 */

public class Fragment_Study_Main extends AppCompatActivity implements FragmentToActivity {

    private Fragment_Study1 mFragment1,mFragment2;
    private TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.fragment_study_main);

        mFragment1 = (Fragment_Study1) getSupportFragmentManager().findFragmentById(R.id.container_main1);
        mFragment2 = (Fragment_Study1) getSupportFragmentManager().findFragmentById(R.id.container_main2);
        mTextView = (TextView) findViewById(R.id.text_main);
        mTextView.setBackgroundColor(Color.MAGENTA);
        mFragment1.setFragmentToActivity(this);
        mFragment2.setFragmentToActivity(this);
    }

    @Override
    public void receiveData(String str) {
        mTextView.setText(str);
    }
}
