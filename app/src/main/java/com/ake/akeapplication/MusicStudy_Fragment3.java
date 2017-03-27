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

import com.ake.akeapplication.models.MusicModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 유현석 on 2017-02-28.
 */

public class MusicStudy_Fragment3 extends Fragment {

    private List<MusicModel> mData;

    public static MusicStudy_Fragment3 newInstance(List<MusicModel> data) {
        MusicStudy_Fragment3 fragment3 = new MusicStudy_Fragment3();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", (Serializable) data);

        fragment3.setArguments(bundle);
        return fragment3;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        ListView listView = (ListView) view.findViewById(R.id.list_fragment);

        List<MusicModel> data = (List<MusicModel>) getArguments().getSerializable("data");

        BaseAdapter adapter = new MyListView(data);

        listView.setAdapter(adapter);


        return view;
    }

    public static class MyListView extends BaseAdapter {

        private List<MusicModel> mmData;

        public MyListView(List<MusicModel> list) {
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
                TextView textView1 = (TextView) convertView.findViewById(R.id.info_text1);
                TextView textView2 = (TextView) convertView.findViewById(R.id.info_text2);
                viewHolder.mTextView1 = textView1;
                viewHolder.mTextView2 = textView2;
                viewHolder.mTextView1.setTag(viewHolder);
                viewHolder.mTextView2.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            MusicModel model = mmData.get(position);
            viewHolder.mTextView1.setText(model.getText1());
            viewHolder.mTextView2.setText(model.getText2());

            return convertView;
        }

        private class ViewHolder {
            TextView mTextView1;
            TextView mTextView2;
        }
    }
}
