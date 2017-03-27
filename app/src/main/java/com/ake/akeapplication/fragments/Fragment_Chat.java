//package com.ake.akeapplication.fragments;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.text.TextUtils;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.ake.akeapplication.R;
//
///**
// * Created by 유현석 on 2017-02-24.
// */
//
//public class Fragment_Chat extends Fragment implements View.OnClickListener {
//
//    private EditText mEditText;
//    private TextView mTextView;
//    private Button mSendButton;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_chat, container, false);
//
//        mEditText = (EditText) view.findViewById(R.id.et_to_activity);
//        mTextView = (TextView) view.findViewById(R.id.tv_received);
//        mSendButton = (Button) view.findViewById(R.id.btn_send);
//        mSendButton.setOnClickListener(this);
//
//        return view;
//
//    }
//
//    private FragmentToActivityListener mFragmentToActivity;
//
//    public void setmFragmentToActivityListener(FragmentToActivityListener listener) {
//        mFragmentToActivity = listener;
//    }
//
//    @Override
//    public void onClick(View v) {
//        String msg = mEditText.getText().toString();
//
//        if(TextUtils.isEmpty(msg)) {
//            Toast.makeText(getActivity(), "메세지를 입력하시오", Toast.LENGTH_SHORT).show();
//        } else {
//            if (mFragmentToActivity != null) {
//                mFragmentToActivity.receivedData(msg);
//            }
//        }
//
//    }
//
//    public void receiveDataFromActivity(String msg) {
//        Toast.makeText(getActivity(), "액티비티로부터 메세지를 전달받다.", Toast.LENGTH_SHORT).show();
//        mTextView.append("액티비티 : " + msg + "\n");
//    }
//}
