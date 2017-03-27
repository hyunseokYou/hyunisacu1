package com.ake.akeapplication.Study;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ake.akeapplication.R;

/**
 * Created by 유현석 on 2017-02-25.
 */

public class Fragment_Study2 extends Fragment implements FragmentToActivity {

    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_study, container, false);

        mTextView = (TextView) view.findViewById(R.id.text_study);


        return view;

    }

    @Override
    public void receiveData(String str) {
        mTextView.setText(str);
    }
}
