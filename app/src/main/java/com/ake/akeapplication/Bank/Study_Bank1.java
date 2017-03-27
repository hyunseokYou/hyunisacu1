package com.ake.akeapplication.Bank;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ake.akeapplication.R;
import com.ake.akeapplication.managers.Bank;

public class Study_Bank1 extends AppCompatActivity {

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study__bank);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bankButton1:
                startActivity(new Intent(this, Study_Bank2.class));
                break;
            case R.id.bankButton2:
                startActivity(new Intent(this, Study_Bank3.class));
                break;
            case R.id.bankButton3:
                showAdminDialog();
                break;
            case R.id.bankButton4:
                finish();
                break;
        }
    }

    private void showAdminDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_login, null, false);
        final EditText idEditText = (EditText) view.findViewById(R.id.id_edit);
        final EditText passEditText = (EditText) view.findViewById(R.id.pass_edit);
        builder.setView(view);
        builder.setPositiveButton("로그인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String id = idEditText.getText().toString();
                String pass = passEditText.getText().toString();

                Bank bank = Bank.newInstance();
                if (bank.isAdmin(id, pass)) {
                    startActivity(new Intent(Study_Bank1.this, Study_Bank4.class));
                }
            }
        });
        builder.setNegativeButton("닫기", null);
        builder.show();
    }
}
