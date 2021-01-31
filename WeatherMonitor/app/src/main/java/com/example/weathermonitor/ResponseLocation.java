package com.example.weathermonitor;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ResponseLocation implements Serializable {

    @SerializedName("latt_long")
    private final String lattLong;

    @SerializedName("woeid")
    private final int woeid;

    @SerializedName("title")
    private final String title;

    @SerializedName("location_type")
    private final String locationType;

    public ResponseLocation(String lattLong, int woeid, String title, String locationType) {
        this.lattLong = lattLong;
        this.woeid = woeid;
        this.title = title;
        this.locationType = locationType;
    }

    public String getLattLong() {
        return lattLong;
    }

    public int getWoeid() {
        return woeid;
    }

    public String getTitle() {
        return title;
    }

    public String getLocationType() {
        return locationType;
    }

    @Override
    public String toString() {
        return
                "ResponseRequestType{" +
                        "latt_long = '" + lattLong + '\'' +
                        ",woeid = '" + woeid + '\'' +
                        ",title = '" + title + '\'' +
                        ",location_type = '" + locationType + '\'' +
                        "}";
    }
}