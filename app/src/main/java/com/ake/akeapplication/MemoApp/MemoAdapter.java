package com.ake.akeapplication.MemoApp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ake.akeapplication.R;
import com.ake.akeapplication.models.Memo;

import java.util.List;

/**
 * Created by 유현석 on 2017-03-12.
 */

class MemoAdapter extends BaseAdapter {
    private final List<Memo> mData;

    public MemoAdapter(List<Memo> mMemoList) {
        mData = mMemoList;
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
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_memo, parent, false);

            TextView titleTextView = (TextView) convertView.findViewById(R.id.title_text);
            TextView contentextView = (TextView) convertView.findViewById(R.id.content_text);

            viewHolder.titleTextView = titleTextView;
            viewHolder.contentTextView = contentextView;
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Memo memo = mData.get(position);

        viewHolder.titleTextView.setText(memo.getTitle());
        viewHolder.contentTextView.setText(memo.getContent());

        return null;
    }
    private static class ViewHolder {
        TextView titleTextView;
        TextView contentTextView;


    }
}
