package com.ake.akeapplication.CustomDesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ake.akeapplication.R;

public class CustomDesign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_design);
    }

    public void showToast(View view) {
        Toast result = new Toast(this);

        View v = getLayoutInflater().inflate(R.layout.custom_toast, null);
        TextView tv = (TextView) v.findViewById(R.id.text_toast);
        tv.setText("나만의 토스트");

        result.setView(v);
        result.setDuration(Toast.LENGTH_SHORT);
        result.setGravity(Gravity.CENTER_HORIZONTAL, 0, -300);
        result.show();
    }
}
