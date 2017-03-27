package com.ake.akeapplication.Portfolio.port01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.ake.akeapplication.Portfolio.port01.Forecast.List;
import com.ake.akeapplication.Portfolio.port01.Forecast.Pofol01_Model2;
import com.ake.akeapplication.R;

import java.util.ArrayList;

public class Pofol01_Fragment2 extends Fragment {

    private Pofol01_Model2 mModel;
    private ExpandableListView mListView;

    public Pofol01_Fragment2() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pofol01_fragment02, container, false);
        mListView = (ExpandableListView) view.findViewById(R.id.list_dialog);

        MyAdapter adapter = new MyAdapter((ArrayList<List>) mModel.getList());
        mListView.setAdapter(adapter);

        return view;
    }


    public class MyAdapter extends BaseExpandableListAdapter {

        private ArrayList<List> mParentList;

        public MyAdapter(ArrayList<List> mParentList) {
            this.mParentList = mParentList;
        }

        @Override
        public int getGroupCount() {
            return mParentList.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return 1;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return mParentList.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return mParentList.get(groupPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            groupViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new groupViewHolder();
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info, parent, false);
                viewHolder.mParentText = (TextView) convertView.findViewById(R.id.info_text1);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (groupViewHolder) convertView.getTag();
            }
            viewHolder.mParentText.setText(mModel.getList().get(groupPosition).getDtTxt());

            return convertView;

        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            childViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new childViewHolder();
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pofol01_frame2, parent, false);
                viewHolder.mTemperText = (TextView) convertView.findViewById(R.id.pager2_temper);
                viewHolder.mSpeedText = (TextView) convertView.findViewById(R.id.pager2_speed);
                viewHolder.mAtmoText = (TextView) convertView.findViewById(R.id.pager2_atmo);
                viewHolder.mHumText = (TextView) convertView.findViewById(R.id.pager2_hum);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (childViewHolder) convertView.getTag();
            }
            viewHolder.mTemperText.setText(mModel.getList().get(groupPosition).getMain().getTemp());
            viewHolder.mSpeedText.setText(mModel.getList().get(groupPosition).getWind().getSpeed().toString());
            viewHolder.mAtmoText.setText(mModel.getList().get(groupPosition).getMain().getPressure());
            viewHolder.mHumText.setText(mModel.getList().get(groupPosition).getMain().getHumidity());

            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }

        private class groupViewHolder {
            TextView mParentText;
        }

        private class childViewHolder {
            TextView mTemperText;
            TextView mSpeedText;
            TextView mAtmoText;
            TextView mHumText;
        }
    }


    public void setModel(Pofol01_Model2 data) {
        mModel = data;
    }
}
