package com.example.weathermonitor.api;


import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class ResponseRequestType implements Serializable {

	@SerializedName("latt_long")
	private String lattLong;

	@SerializedName("woeid")
	private int woeid;

	@SerializedName("title")
	private String title;

	@SerializedName("location_type")
	private String locationType;

	public String getLattLong(){
		return lattLong;
	}

	public int getWoeid(){
		return woeid;
	}

	public String getTitle(){
		return title;
	}

	public String getLocationType(){
		return locationType;
	}

	public ResponseRequestType(String lattLong, int woeid, String title, String locationType) {
		this.lattLong = lattLong;
		this.woeid = woeid;
		this.title = title;
		this.locationType = locationType;
	}

	@Override
 	public String toString(){
		return 
			"ResponseRequestType{" + 
			"latt_long = '" + lattLong + '\'' + 
			",woeid = '" + woeid + '\'' + 
			",title = '" + title + '\'' + 
			",location_type = '" + locationType + '\'' + 
			"}";
		}
}