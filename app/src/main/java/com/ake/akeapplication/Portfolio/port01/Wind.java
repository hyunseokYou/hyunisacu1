package com.ake.akeapplication.Portfolio.port01;

import java.io.Serializable;

/**
 * Created by 유현석 on 2017-03-17.
 */

class Wind implements Serializable {
    private String speed;
    private String deg;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed='" + speed + '\'' +
                ", deg='" + deg + '\'' +
                '}';
    }
}
