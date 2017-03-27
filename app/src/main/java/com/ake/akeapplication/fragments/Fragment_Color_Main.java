package com.ake.akeapplication.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ake.akeapplication.R;

/**
 * Created by 유현석 on 2017-02-20.
 */

public class Fragment_Color_Main extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);


        // fragment.xml 에서 프래그먼트 긁어오기
        Fragment_Color1 fragment_color1 = (Fragment_Color1) getSupportFragmentManager()
                .findFragmentById(R.id.frame_1); // xml에서 fragment로 선언 되어있어야함
        fragment_color1.setColor(Color.MAGENTA);

        // 동적으로 프래그먼트 추가
        Fragment_Color1 fragment_color2 = new Fragment_Color1();

        //Bundle을 setArguments에 전달하는 방법
        Bundle bundle = new Bundle();
        bundle.putInt("color", Color.CYAN);
        bundle.putString("text", "text");
        fragment_color2.setArguments(bundle);

        //팩토리 패턴을 활용하여 생성과 동시에 전달
        Fragment_Color1 fragment_color3 = Fragment_Color1.newInstance(Color.GRAY);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame_2, fragment_color2).commit();
        // xml에서 framelayout으로 선언 되있어야함
    }

    @Override
    public void onClick(View v) {
        Fragment_Color1 newFragment_color = new Fragment_Color1();
        newFragment_color.setColor(Color.YELLOW);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_2, newFragment_color).commit();
        // replcae로 기존의 프래그먼트를 현재의 프래그먼트로 교체

    }
}
