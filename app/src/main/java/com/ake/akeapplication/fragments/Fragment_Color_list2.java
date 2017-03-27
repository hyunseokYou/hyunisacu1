package com.ake.akeapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ake.akeapplication.R;

/**
 * Created by 유현석 on 2017-02-20.
 */

public class Fragment_Color_list2 extends Fragment_Color_list1 {

    private String mText = "";
    private TextView mTextView;

    public Fragment_Color_list2() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mTextView = (TextView) view.findViewById(R.id.text_text);
        mTextView.setText(mText);
        return view;
    }

    public void setText(String text) {
        mText = text;
        if (mTextView != null) {
            mTextView.setText(mText);
        }
    }
}
