package com.ake.akeapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ake.akeapplication.R;

/**
 * Created by 유현석 on 2017-02-24.
 */

public class Fragment_Result_Main extends AppCompatActivity implements FragmentToActivityListener {

    private TextView mAteamText;
    private TextView mBteamText;
    private Fragment_Result mfragment;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_result_main);

        mAteamText = (TextView) findViewById(R.id.aTeam_text);
        mBteamText = (TextView) findViewById(R.id.bTeam_text);

        mfragment = (Fragment_Result) getSupportFragmentManager().findFragmentById(R.id.result_container);
        mfragment.setFragmentToActivityListener(this);



    }


    @Override
    public void receivedData(String str, int result) {
        switch (str) {
            case "A" :
                mAteamText.setText(result);
                break;
            case "B" :
                mBteamText.setText(result);
                break;
        }


    }
}
