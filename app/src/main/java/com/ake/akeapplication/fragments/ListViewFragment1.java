package com.ake.akeapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ake.akeapplication.R;

import java.io.Serializable;
import java.util.List;


/**
 * Created by 유현석 on 2017-02-27.
 */

public class ListViewFragment1 extends Fragment {

    private List<String> mData;

    public static ListViewFragment1 newInstance(List<String> data) {
        ListViewFragment1 fragment = new ListViewFragment1();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", (Serializable) data);

        fragment.setArguments(bundle);
        return fragment;

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        ListView listView = (ListView) view.findViewById(R.id.list_fragment);

        BaseAdapter adapter = new MyListView();

        listView.setAdapter(adapter);

        return view;
    }

    public static class MyListView extends BaseAdapter {

        private List<String> mData;

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
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

            viewHolder.mTextView.setText(mData.get(position));

            return convertView;
        }

        private class ViewHolder {
            TextView mTextView;
        }
    }

}
