package com.ake.akeapplication.Portfolio.port01;

import java.io.Serializable;

/**
 * Created by 유현석 on 2017-03-17.
 */

class Clouds implements Serializable {
    private String all;

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "ClassPojo [all = " + all + "]";
    }
}
