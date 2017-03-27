package com.ake.akeapplication.managers;

import com.ake.akeapplication.models.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 유현석 on 2017-02-16.
 */

public class Bank {

    private static Bank sInstanse = new Bank();

    private final static String ADMIN_ID = "admin";
    private final static String ADMIN_PASS = "1234";

    private List<Account> mAccountList;

    public Bank() {
        this.mAccountList = new ArrayList<>();
    }

    public static Bank newInstance() {
        return sInstanse;
    }

    public void open(Account account) {
        mAccountList.add(account);
    }

    public Account login(String id, String pass) {
        for (Account account : mAccountList) {
            if (account.getId().equals(id) && account.getPass().equals(pass)) {
                return account;
            }
        }
        return null;
    }

    public boolean isAdmin(String id, String pass) {
        return ADMIN_ID.equals(id) && ADMIN_PASS.equals(pass);
    }

    public List<Account> getmAccountList() {
        return mAccountList;
    }
}
