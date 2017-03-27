package com.ake.akeapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Studylistview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studylistview);

        ListView listView = (ListView) findViewById(R.id.study_listview);
        StudyAdapter Adapter = new StudyAdapter(getData());
        listView.setAdapter(Adapter);

    }


    // 데이터를 모델에 입력
    private List<StudyModel> getData() {
        List<StudyModel> result = new ArrayList<>();

        for (int i = 0; i <= 1000; i++) {
            result.add(new StudyModel("제목" + i, "내용" + i));
        }
        return result;
    }
}
