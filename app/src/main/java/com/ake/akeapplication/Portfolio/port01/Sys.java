package com.ake.akeapplication.Portfolio.port01;

import java.io.Serializable;

/**
 * Created by 유현석 on 2017-03-17.
 */

class Sys implements Serializable {
    private String message;

    private String id;

    private Double sunset;

    private Double sunrise;

    private String type;

    private String country;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getSunset() {
        return sunset;
    }

    public void setSunset(Double sunset) {
        this.sunset = sunset;
    }

    public Double getSunrise() {
        return sunrise;
    }

    public void setSunrise(Double sunrise) {
        this.sunrise = sunrise;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "ClassPojo [message = " + message + ", id = " + id + ", sunset = " + sunset + ", sunrise = " + sunrise + ", type = " + type + ", country = " + country + "]";
    }
}
