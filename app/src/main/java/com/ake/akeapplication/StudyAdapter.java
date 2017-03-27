package com.ake.akeapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 유현석 on 2017-02-15.
 */

public class StudyAdapter extends BaseAdapter {

    private List<StudyModel> mData;

    public StudyAdapter(List<StudyModel> mData) {
        this.mData = mData;
    }

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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.studylistview, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        StudyModel item = mData.get(position);
        viewHolder.mTitleView.setText(item.getTitle());
        viewHolder.mContentsView.setText(item.getContents());
        return convertView;
    }

    private class ViewHolder {
        TextView mTitleView;
        TextView mContentsView;

        public ViewHolder(View item) {
            mTitleView = (TextView) item.findViewById(R.id.study1_textview);
            mContentsView = (TextView) item.findViewById(R.id.study2_textview);
        }
    }
}
