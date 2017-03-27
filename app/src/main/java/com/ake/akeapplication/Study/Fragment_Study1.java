package com.ake.akeapplication.Study;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ake.akeapplication.R;

/**
 * Created by 유현석 on 2017-02-25.
 */

public class Fragment_Study1 extends Fragment {

    private EditText mEditText;
    private FragmentToActivity mFragmentToActivity;

    public void setFragmentToActivity(FragmentToActivity fragmentToActivity) {
        mFragmentToActivity = fragmentToActivity;
    }

    public void setText(String string) {
        mFragmentToActivity.receiveData(string);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_study, container, false);

        mEditText = (EditText) view.findViewById(R.id.edit_study);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (mEditText.isFocusable()) {
                    mFragmentToActivity.receiveData(mEditText.getText().toString());

                }

            }
        });

        return view;

    }
}
