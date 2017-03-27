package com.ake.akeapplication.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ake.akeapplication.R;
import com.ake.akeapplication.models.Memo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_Main extends AppCompatActivity implements OnClickListener {


    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private User_Api mUserApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login__main);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        mUserApi = new RetrofitUtil().getmUserApi();

        mEmailSignInButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        mUserApi.login(mEmailView.getText().toString(),
                mPasswordView.getText().toString())
                .enqueue(new Callback<Result_Model>() {
                    @Override
                    public void onResponse(Call<Result_Model> call, Response<Result_Model> response) {
                        // 정상 결과
                        Result_Model result = response.body();
                        if (result.getResult().equals("ok")) {
                            startActivity(new Intent(Login_Main.this, Memo.class));
                        } else {
                            Toast.makeText(Login_Main.this, "error", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Result_Model> call, Throwable t) {
                        // 네트워크 오류
                        Toast.makeText(Login_Main.this, "네트워크 연결 실패", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}


