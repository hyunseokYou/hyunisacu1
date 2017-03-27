package com.ake.akeapplication.models;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 유현석 on 2017-02-17.
 */

public class Hundred {
    private String id;
    private ArrayList<Integer> list;

    public Hundred() {
        this.id = "";
        this.list = new ArrayList<>();
    }

    public void listinput() {
        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }
    }

    public void listturn() {
        Collections.reverse(list);
        System.out.println(list);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getList(int a) {
        return list.get(a);
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Hundred{" +
                "id='" + id + '\'' +
                ", list=" + list +
                '}';
    }
}
