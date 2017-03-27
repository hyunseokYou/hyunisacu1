package com.ake.akeapplication.Bank;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ake.akeapplication.R;
import com.ake.akeapplication.managers.Bank;
import com.ake.akeapplication.models.Account;

public class Study_Bank2 extends AppCompatActivity implements View.OnClickListener {

    private EditText mID;
    private EditText mPass;
    private EditText mPassCheck;
    private EditText mWon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study__bank2);

        mID = (EditText) findViewById(R.id.bankInputID);
        mPass = (EditText) findViewById(R.id.bankInputPass);
        mPassCheck = (EditText) findViewById(R.id.bankInputPassCheck);
        mWon = (EditText) findViewById(R.id.bankInputWon);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bankResetButton:
                mID.setText("");
                mPass.setText("");
                mPassCheck.setText("");
                mWon.setText("");
                break;
            case R.id.bankCreatButton:
                Bank bank = Bank.newInstance();

                String id = mID.getText().toString();
                String pass = mPass.getText().toString();
                int won = Integer.parseInt(mWon.getText().toString());

                Account account = new Account(id, pass, won);
                bank.open(account);

                Toast.makeText(this, "개설", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}
