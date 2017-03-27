package com.ake.akeapplication.Weather;

/**
 * Created by 유현석 on 2017-03-13.
 */

public class Weather_Model {
    private int imageRes;
    private String location;
    private String temperatue;

    public Weather_Model(int imageRes, String location, String temperatue) {
        this.imageRes = imageRes;
        this.location = location;
        this.temperatue = temperatue;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTemperatue() {
        return temperatue;
    }

    public void setTemperatue(String temperatue) {
        this.temperatue = temperatue;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "imageRes=" + imageRes +
                ", location='" + location + '\'' +
                ", temperatue='" + temperatue + '\'' +
                '}';
    }
}
