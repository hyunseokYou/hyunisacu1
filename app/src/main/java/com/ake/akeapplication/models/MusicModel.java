package com.ake.akeapplication.models;

import java.util.Locale;

/**
 * Created by 유현석 on 2017-02-28.
 */

public class MusicModel {

    private String text1;
    private String text2;

    public MusicModel(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    @Override
    public String toString() {
        return String.format(Locale.KOREA, "제목 : %s\n아티스트 : %s", text1, text2);
    }
}
