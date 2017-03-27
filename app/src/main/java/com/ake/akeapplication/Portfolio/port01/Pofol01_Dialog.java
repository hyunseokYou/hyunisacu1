package com.ake.akeapplication.Portfolio.port01;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ake.akeapplication.Portfolio.port01.Forecast.Pofol01_Model2;
import com.ake.akeapplication.R;

/**
 * Created by 유현석 on 2017-03-20.
 */

public class Pofol01_Dialog extends AppCompatActivity implements View.OnClickListener {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Pofol01_Model1 mModel1;
    private Pofol01_Model2 mModel2;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pofol01_dialog);

        mModel1 = (Pofol01_Model1) getIntent().getSerializableExtra("weather");
        mModel2 = (Pofol01_Model2) getIntent().getSerializableExtra("forecast");

        mTabLayout = (TabLayout) findViewById(R.id.dialog_tab);
        mViewPager = (ViewPager) findViewById(R.id.dialog_pager);

        mButton = (Button) findViewById(R.id.dialog_button);

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Pofol01_Fragment1 fragment1 = new Pofol01_Fragment1();
                    fragment1.setModel(mModel1);
                    return fragment1;
                case 1:
                    Pofol01_Fragment2 fragment2 = new Pofol01_Fragment2();
                    fragment2.setModel(mModel2);
                    return fragment2;
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0 :
                    return "현재 날씨";
                case 1 :
                    return "날씨 정보";
            }
            return null;
        }
    }

}
