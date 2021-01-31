package com.example.weathermonitor;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ConsolidatedWeatherItem implements Serializable {

	@SerializedName("id")
	private long id;

	@SerializedName("weather_state_name")
	private String weatherStateName;

	@SerializedName("weather_state_abbr")
	private String weatherStateAbbr;

	@SerializedName("wind_direction_compass")
	private String windDirectionCompass;

	@SerializedName("created")
	private String created;

	@SerializedName("applicable_date")
	private String applicableDate;

	@SerializedName("min_temp")
	private double minTemp;

	@SerializedName("max_temp")
	private double maxTemp;

	@SerializedName("the_temp")
	private double theTemp;

	@SerializedName("wind_speed")
	private double windSpeed;

	@SerializedName("wind_direction")
	private double windDirection;

	@SerializedName("air_pressure")
	private double airPressure;

	@SerializedName("humidity")
	private int humidity;

	@SerializedName("visibility")
	private double visibility;

	@SerializedName("predictability")
	private int predictability;

	public long getId(){
		return id;
	}

	public String getWeatherStateName(){
		return weatherStateName;
	}

	public String getWeatherStateAbbr(){
		return weatherStateAbbr;
	}

	public String getWindDirectionCompass(){
		return windDirectionCompass;
	}

	public String getCreated(){
		return created;
	}

	public String getApplicableDate(){
		return applicableDate;
	}

	public double getMinTemp(){
		return minTemp;
	}

	public double getMaxTemp(){
		return maxTemp;
	}

	public double getTheTemp(){
		return theTemp;
	}

	public double getWindSpeed(){
		return windSpeed;
	}

	public double getWindDirection(){
		return windDirection;
	}

	public double getAirPressure(){
		return airPressure;
	}

	public int getHumidity(){
		return humidity;
	}

	public double getVisibility(){
		return visibility;
	}

	public int getPredictability(){
		return predictability;
	}

	@Override
 	public String toString(){
		return 
			"ConsolidatedWeatherItem{" + 
			"id = '" + id + '\'' + 
			",weather_state_name = '" + weatherStateName + '\'' + 
			",weather_state_abbr = '" + weatherStateAbbr + '\'' + 
			",wind_direction_compass = '" + windDirectionCompass + '\'' + 
			",created = '" + created + '\'' + 
			",applicable_date = '" + applicableDate + '\'' + 
			",min_temp = '" + minTemp + '\'' + 
			",max_temp = '" + maxTemp + '\'' + 
			",the_temp = '" + theTemp + '\'' + 
			",wind_speed = '" + windSpeed + '\'' + 
			",wind_direction = '" + windDirection + '\'' + 
			",air_pressure = '" + airPressure + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",visibility = '" + visibility + '\'' + 
			",predictability = '" + predictability + '\'' + 
			"}";
		}
}