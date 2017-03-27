package com.ake.akeapplication.models;

import java.util.Locale;

/**
 * Created by 유현석 on 2017-02-16.
 */

public class Account {
    private String id;
    private String pass;
    private int won;

    public Account(String id, String pass, int won) {
        this.id = id;
        this.pass = pass;
        this.won = won;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    @Override
    public String toString() {
        return String.format(Locale.KOREA, "조회한 ID : %s\n조회한 계좌의 잔액 : %d", id, won);
    }
}
