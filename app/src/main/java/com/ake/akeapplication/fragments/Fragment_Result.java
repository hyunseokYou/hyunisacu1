package com.ake.akeapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ake.akeapplication.R;

/**
 * Created by 유현석 on 2017-02-24.
 */

public class Fragment_Result extends Fragment implements View.OnClickListener {

//    private Button mAteamPlus;
//    private Button mBteamPlus;
//
//    private Button mAteamMinus;
//    private Button mBteamMinus;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result ,container, false);

//        mAteamPlus = (Button) view.findViewById(R.id.aPlus_btn);
//        mBteamPlus = (Button) view.findViewById(R.id.bPlus_btn);
//
//        mAteamMinus = (Button) view.findViewById(R.id.aMin_btn);
//        mBteamMinus = (Button) view.findViewById(R.id.bMin_btn);
//
//        mAteamPlus.setOnClickListener(this);
//        mBteamPlus.setOnClickListener(this);
//        mAteamMinus.setOnClickListener(this);
//        mBteamMinus.setOnClickListener(this);

        return view;

    }

    private FragmentToActivityListener mToActivityListener;

    public void setFragmentToActivityListener(FragmentToActivityListener fragment_result_main) {
        mToActivityListener = fragment_result_main;
    }

    public void setButtonA(String str, int result) {
        mToActivityListener.receivedData(str, result);
    }
    public void setButtonB(String str, int result) {
        mToActivityListener.receivedData(str, result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aPlus_btn:
                setButtonA("A", 1);
                break;
            case R.id.aMin_btn:
                setButtonA("A", -1);
                break;
            case R.id.bPlus_btn:
                setButtonB("B", 1);
                break;
            case R.id.bMin_btn:
                setButtonB("B", -1);
                break;
        }
    }
}
