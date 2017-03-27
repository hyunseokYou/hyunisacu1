package com.ake.akeapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ake.akeapplication.models.MusicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 유현석 on 2017-02-28.
 */

public class MusicStudy_Main extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_study_main);

        mTabLayout = (TabLayout) findViewById(R.id.music_tap);
        mViewPager = (ViewPager) findViewById(R.id.music_viewpager);

        MusicStudy_Fragment mFragment = (MusicStudy_Fragment) getSupportFragmentManager().findFragmentById(R.id.music_frag);

        mTabLayout.setupWithViewPager(mViewPager);
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
    }

    public static class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new MusicStudy_Fragment1();
                case 1:
                    return new MusicStudy_Fragment2().newInstance(createPageTwo());
                case 2:
                    return new MusicStudy_Fragment3().newInstance(createPageThree());
            }
            return null;
        }

        private List<String> createPageTwo() {
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                list.add("가수 " + i);
            }
            return list;
        }
        private List<MusicModel> createPageThree() {
            List<MusicModel> list = new ArrayList<>();
            for (int i = 0; i <= 10; i++) {
               list.add(new MusicModel(i +"", i + ""));
            }
            return list;
        }

    }
}
