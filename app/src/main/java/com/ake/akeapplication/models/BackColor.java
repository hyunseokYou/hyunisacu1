package com.ake.akeapplication.models;

/**
 * Created by 유현석 on 2017-02-17.
 */

public class BackColor {
    private String id;

    public BackColor(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BackColor{" +
                "id='" + id + '\'' +
                '}';
    }
}
