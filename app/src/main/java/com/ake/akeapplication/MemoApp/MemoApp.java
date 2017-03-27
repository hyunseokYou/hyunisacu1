package com.ake.akeapplication.MemoApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.ake.akeapplication.R;
import com.ake.akeapplication.models.Memo;

import java.util.ArrayList;
import java.util.List;

public class MemoApp extends AppCompatActivity {

    public static final int REQUEST_CODE_NEW_MEMO = 1000;

    private List<Memo> mMemoList;
    private MemoRecyclerAdapter mAdapter;
    private RecyclerView mMemoListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_app);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mMemoListView = (RecyclerView) findViewById(R.id.memo_list);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MemoApp.this, MemoEdit.class);
                startActivityForResult(intent, REQUEST_CODE_NEW_MEMO);
            }
        });

        mMemoList = new ArrayList<>();
        mAdapter = new MemoRecyclerAdapter(mMemoList);

        mMemoListView.setAdapter(mAdapter);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_NEW_MEMO) {
            if (requestCode == RESULT_OK) {
                String title = data.getStringExtra("title");
                String content = data.getStringExtra("content");

                mMemoList.add(new Memo(title, content));
                mAdapter.notifyDataSetChanged();

                Toast.makeText(this, "저장 되었습니다", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "취소 되었습니다", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
