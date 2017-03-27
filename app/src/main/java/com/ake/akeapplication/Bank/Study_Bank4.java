package com.ake.akeapplication.Bank;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ake.akeapplication.R;
import com.ake.akeapplication.managers.Bank;
import com.ake.akeapplication.models.Account;

import java.util.List;

public class Study_Bank4 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study__bank4);

        ListView listView = (ListView) findViewById(R.id.bank4_ListView);

        Bank bank = Bank.newInstance();

        BaseAdapter adapter = new BankAdapter(bank.getmAccountList());

        listView.setAdapter(adapter);



        findViewById(R.id.bank4_Close).setOnClickListener(this);

    }

    public void onClick(View view) {
        finish();
    }

    private static class BankAdapter extends BaseAdapter {

        private final List<Account> mData;

        public BankAdapter(List<Account> accountList) {
            mData = accountList;
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


                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info, parent, false);

                TextView idTextView = (TextView) convertView.findViewById(R.id.info_text1);
                TextView wonTextView = (TextView) convertView.findViewById(R.id.info_text2);

                viewHolder.idTextView = idTextView;
                viewHolder.wonTextView = wonTextView;

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Account account = mData.get(position);

            viewHolder.idTextView.setText(account.getId());
            viewHolder.wonTextView.setText("" + account.getWon());


            return convertView;
        }
        private static class ViewHolder {
            TextView idTextView;
            TextView wonTextView;
        }
    }
}
