package com.ake.akeapplication.MemoApp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ake.akeapplication.R;
import com.ake.akeapplication.models.Memo;

import java.util.List;

/**
 * Created by 유현석 on 2017-03-13.
 */

public class MemoRecyclerAdapter extends RecyclerView.Adapter<MemoRecyclerAdapter.ViewHolder>{

    // EventBus Class
    public static class OnItemClickEvent {
        public OnItemClickEvent(int position, int id) {
            this.position = position;
            this.id = id;
        }

        int position;
        long id;
    }

    private List<Memo> mData;

    public MemoRecyclerAdapter(List<Memo> mData) {
        this.mData = mData;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_info, parent, false);

        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Memo memo = mData.get(position);

        holder.titleTextView.setText(memo.getTitle());
        holder.contentTextView.setText(memo.getContent());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView contentTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            TextView titleTextView = (TextView) itemView.findViewById(R.id.title_text);
            TextView contentTextView = (TextView) itemView.findViewById(R.id.content_text);

            this.titleTextView = titleTextView;
            this.contentTextView = contentTextView;

        }
    }
}
