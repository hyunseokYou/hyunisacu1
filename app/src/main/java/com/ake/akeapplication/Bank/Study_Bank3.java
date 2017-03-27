package com.ake.akeapplication.Bank;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ake.akeapplication.R;
import com.ake.akeapplication.managers.Bank;
import com.ake.akeapplication.models.Account;

public class Study_Bank3 extends AppCompatActivity implements View.OnClickListener {

    private EditText mIdEditText;
    private EditText mIdPassEditText;
    private TextView mResultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study__bank3);

        mIdEditText = (EditText) findViewById(R.id.bank3_ID);
        mIdPassEditText = (EditText) findViewById(R.id.bank3_Pass);
        mResultTextView = (TextView) findViewById(R.id.bank3_resultText);

        findViewById(R.id.bank3_Login).setOnClickListener(this);
        findViewById(R.id.bank3_Close).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bank3_Login :
                Bank bank = Bank.newInstance();

                String id = mIdEditText.getText().toString();
                String pass = mIdPassEditText.getText().toString();

                Account account = bank.login(id, pass);
                if (account != null) {
                    mResultTextView.setText(account.toString());
                }
                break;
            case R.id.bank3_Close :
                finish();
                break;

        }
    }
}
