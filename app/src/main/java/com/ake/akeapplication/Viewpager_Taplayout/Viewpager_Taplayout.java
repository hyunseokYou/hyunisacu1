package com.ake.akeapplication.Viewpager_Taplayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ake.akeapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Viewpager_Taplayout extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager__taplayout);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.pager_view);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    public static class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Fragment getItem(int position) {
//            switch (position) {
//                case 0:
//                    return createChaList('A', 'Z');
//                case 1:
//                    return
//                case 2:
//                    return
//                case 3:
//                    return
//            }
            return null;
        }

        private List<String> createChaList(char start, char end) {
            List<String> list = new ArrayList<>();
            char ch = start;
            for (char i = 0; i < end; i++) {
                list.add(String.valueOf(i));
            }
            return list;
        }

    }
}
