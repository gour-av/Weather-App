package com.example.weathermonitor;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class ResponseWeatherType implements Serializable {

	@SerializedName("consolidated_weather")
	private List<ConsolidatedWeatherItem> consolidatedWeather;

	@SerializedName("time")
	private String time;

	@SerializedName("sun_rise")
	private String sunRise;

	@SerializedName("sun_set")
	private String sunSet;

	@SerializedName("timezone_name")
	private String timezoneName;

	@SerializedName("parent")
	private Parent parent;

	@SerializedName("sources")
	private List<SourcesItem> sources;

	@SerializedName("title")
	private String title;

	@SerializedName("location_type")
	private String locationType;

	@SerializedName("woeid")
	private int woeid;

	@SerializedName("latt_long")
	private String lattLong;

	@SerializedName("timezone")
	private String timezone;

	public List<ConsolidatedWeatherItem> getConsolidatedWeather(){
		return consolidatedWeather;
	}

	public String getTime(){
		return time;
	}

	public String getSunRise(){
		return sunRise;
	}

	public String getSunSet(){
		return sunSet;
	}

	public String getTimezoneName(){
		return timezoneName;
	}

	public Parent getParent(){
		return parent;
	}

	public List<SourcesItem> getSources(){
		return sources;
	}

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

	public String getTimezone(){
		return timezone;
	}

	@Override
 	public String toString(){
		return 
			"ResponseWeatherType{" + 
			"consolidated_weather = '" + consolidatedWeather + '\'' + 
			",time = '" + time + '\'' + 
			",sun_rise = '" + sunRise + '\'' + 
			",sun_set = '" + sunSet + '\'' + 
			",timezone_name = '" + timezoneName + '\'' + 
			",parent = '" + parent + '\'' + 
			",sources = '" + sources + '\'' + 
			",title = '" + title + '\'' + 
			",location_type = '" + locationType + '\'' + 
			",woeid = '" + woeid + '\'' + 
			",latt_long = '" + lattLong + '\'' + 
			",timezone = '" + timezone + '\'' + 
			"}";
		}
}