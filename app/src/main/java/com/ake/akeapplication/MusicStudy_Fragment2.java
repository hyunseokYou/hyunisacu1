package com.ake.akeapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 유현석 on 2017-02-28.
 */

public class MusicStudy_Fragment2 extends Fragment {

    private List<String> mData;

    public static MusicStudy_Fragment2 newInstance(List<String> data) {
        MusicStudy_Fragment2 fragment1 = new MusicStudy_Fragment2();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", (Serializable) data);

        fragment1.setArguments(bundle);
        return fragment1;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        ListView listView = (ListView) view.findViewById(R.id.list_fragment);

        List<String> data = (List<String>) getArguments().getSerializable("data");

        BaseAdapter adapter = new MyListView(data);

        listView.setAdapter(adapter);


        return view;
    }

    public static class MyListView extends BaseAdapter {

        private List<String> mmData;

        public MyListView(List<String> list) {
            mmData = list;
        }

        @Override
        public int getCount() {
            return mmData.size();
        }

        @Override
        public Object getItem(int position) {
            return mmData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;

            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_info, parent, false);
                TextView textView = (TextView) convertView.findViewById(R.id.info_text1);
                viewHolder.mTextView = textView;
                viewHolder.mTextView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.mTextView.setText(mmData.get(position));
            return convertView;
        }

        private class ViewHolder {
            TextView mTextView;
        }
    }
}
