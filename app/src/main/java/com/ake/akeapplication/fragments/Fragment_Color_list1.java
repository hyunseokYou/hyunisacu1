package com.ake.akeapplication.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ake.akeapplication.R;

/**
 * Created by 유현석 on 2017-02-20.
 */

public class Fragment_Color_list1 extends Fragment {

    private int mColor = Color.WHITE;

    public Fragment_Color_list1() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fragment, container, false);
        view.setBackgroundColor(mColor);
        return view;
    }

    public void setColor(int color) {
        mColor = color;
        if (getView() != null) {
            getView().setBackgroundColor(mColor);
        }
    }

}
