package com.ake.akeapplication.BackColor;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ake.akeapplication.R;
import com.ake.akeapplication.models.BackColor;

import java.util.ArrayList;
import java.util.List;

public class BackgroundColor2 extends AppCompatActivity {

    private ListView mlistView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_color1);

        mlistView = (ListView) findViewById(R.id.backColor_list);

        BackColorAdapter backColorAdapter = new BackColorAdapter(list());

        mlistView.setAdapter(backColorAdapter);


    }

    public List<BackColor> list() {
        List<BackColor> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new BackColor("포지션 " + i));
        }
        return list;
    }

    private static class BackColorAdapter extends BaseAdapter {

        private final List<BackColor> mlist;

        public BackColorAdapter(List<BackColor> mlist) {
            this.mlist = mlist;
        }

        @Override
        public int getCount() {
            return mlist.size();
        }

        @Override
        public Object getItem(int position) {
            return mlist.get(position);
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
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info, parent, false);

                TextView putTextView = (TextView) convertView.findViewById(R.id.info_text1);

                viewHolder.putTextView = putTextView;
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            BackColor backColor = mlist.get(position);

            viewHolder.putTextView.setText(backColor.getId());

            if (position == 0) {
                convertView.setBackgroundColor(Color.BLACK);
            } else if (position % 2 == 1) {
                convertView.setBackgroundColor(Color.BLUE);
            } else {
                convertView.setBackgroundColor(Color.CYAN);
            }

            return convertView;
        }
    }


    private static class ViewHolder {
        public TextView putTextView;
    }

}
