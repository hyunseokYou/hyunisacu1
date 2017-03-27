//package com.ake.akeapplication.fragments;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.text.TextUtils;
//import android.view.View;
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
//public class Fragment_Chat_Main extends AppCompatActivity implements View.OnClickListener, FragmentToActivityListener {
//
//    private EditText mEditText;
//    private TextView mTextView;
//    private Button mSendButton;
//    private Fragment_Chat mFragment;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_chat_main);
//
//        mEditText = (EditText) findViewById(R.id.et_to_fragment);
//        mTextView = (TextView) findViewById(R.id.tv_received);
//        mSendButton = (Button) findViewById(R.id.btn_send);
//        mSendButton.setOnClickListener(this);
//        mFragment = (Fragment_Chat) getSupportFragmentManager().findFragmentById(R.id.fragment);
//
//        mFragment.setmFragmentToActivityListener(this);
//
//
//    }
//
//    @Override
//    public void onClick(View v) {
//        String msg = mEditText.getText().toString();
//
//        if (TextUtils.isEmpty(msg)) {
//            Toast.makeText(Fragment_Chat_Main.this, "전달할 메세지를 입력하시오", Toast.LENGTH_SHORT).show();
//        } else {
//            mFragment.receiveDataFromActivity(msg);
//        }
//
//    }
//
//    @Override
//    public void receivedData(String str) {
//        mTextView.append("프래그먼트 : " + str + "\n");
//    }
//}
