package com.ake.akeapplication.ListHundred;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ake.akeapplication.R;
import com.ake.akeapplication.models.Hundred;

import java.util.ArrayList;
import java.util.List;

public class ListHundred2 extends AppCompatActivity {

    private ListView mlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hundred2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mlistView = (ListView) findViewById(R.id.hundred2_listview);
        HundredAdapter hundredAdapter = new HundredAdapter(list());
        mlistView.setAdapter(hundredAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                finish();
            }
        });
    }

    public List<String> list() {
        List<String> list = new ArrayList<>();
        Hundred hundred = new Hundred();
        hundred.listinput();
        hundred.listturn();
        for (int i = 0; i < 20; i++) {
            list.add("number" + hundred.getList(i));
        }
        return list;
    }

    private static class HundredAdapter extends BaseAdapter {

        private List<String> mList;

        public HundredAdapter(List<String> mList) {
            this.mList = mList;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
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
                TextView putTextview = (TextView) convertView.findViewById(R.id.info_text2);

                viewHolder.putTextview = putTextview;
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            String hundred = mList.get(position);
            viewHolder.putTextview.setText(hundred);

            return convertView;

        }

        private class ViewHolder {
            private TextView putTextview;
        }
    }

}
