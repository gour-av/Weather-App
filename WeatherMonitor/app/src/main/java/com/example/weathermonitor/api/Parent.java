package com.example.weathermonitor.api;


import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class Parent implements Serializable {

	@SerializedName("title")
	private String title;

	@SerializedName("location_type")
	private String locationType;

	@SerializedName("woeid")
	private int woeid;

	@SerializedName("latt_long")
	private String lattLong;

	public String getTitle(){
		return title;
	}

	public String getLocationType(){
		return locationType;
	}

	public int getWoeid(){
		return woeid;
	}

	public String getLattLong(){
		return lattLong;
	}

	@Override
 	public String toString(){
		return 
			"Parent{" + 
			"title = '" + title + '\'' + 
			",location_type = '" + locationType + '\'' + 
			",woeid = '" + woeid + '\'' + 
			",latt_long = '" + lattLong + '\'' + 
			"}";
		}
}