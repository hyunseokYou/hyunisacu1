package com.ake.akeapplication;

/**
 * Created by 유현석 on 2017-02-15.
 */

public class StudyModel {
    private String title = "";
    private String contents = "";

    public StudyModel(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "StudyModel{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
