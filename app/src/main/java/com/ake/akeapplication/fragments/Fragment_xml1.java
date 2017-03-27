package com.ake.akeapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ake.akeapplication.R;

/**
 * Created by 유현석 on 2017-02-20.
 */

public class Fragment_xml1 extends Fragment{

    private String mParam1;
    private String mParam2;

    public static Fragment_xml1 newInstance(String param1, String param2) {
        Fragment_xml1 fragment = new Fragment_xml1();
        Bundle bundle = new Bundle();

        bundle.putString("param1", param1);
        bundle.putString("param2", param2);

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString("param1");
            mParam2 = getArguments().getString("param2");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fragment, container, false);

        TextView textView1 = (TextView) view.findViewById(R.id.text_text);
        TextView textView2 = (TextView) view.findViewById(R.id.text_text);

        textView1.setText(mParam1);
        textView2.setText(mParam2);

        return view;
    }
}
