package com.ake.akeapplication.Portfolio.port01;

import java.io.Serializable;

/**
 * Created by 유현석 on 2017-03-17.
 */

class Coord implements Serializable {
    private double lon;

    private double lat;

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "ClassPojo [lon = " + lon + ", lat = " + lat + "]";
    }
}
