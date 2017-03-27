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

public class Fragment_Color1 extends Fragment {

    private int mColor = Color.WHITE;

    public Fragment_Color1() {
    }

    public static Fragment_Color1 newInstance(int color) {
        Fragment_Color1 fragment = new Fragment_Color1();
        Bundle bundle = new Bundle();

        bundle.putInt("color", color);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fragment, container, false);
        Bundle bundle = getArguments();
        mColor = bundle.getInt("color");

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




