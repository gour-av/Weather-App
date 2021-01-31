package com.example.weathermonitor;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class SourcesItem implements Serializable {

	@SerializedName("title")
	private String title;

	@SerializedName("slug")
	private String slug;

	@SerializedName("url")
	private String url;

	@SerializedName("crawl_rate")
	private int crawlRate;

	public String getTitle(){
		return title;
	}

	public String getSlug(){
		return slug;
	}

	public String getUrl(){
		return url;
	}

	public int getCrawlRate(){
		return crawlRate;
	}

	@Override
 	public String toString(){
		return 
			"SourcesItem{" + 
			"title = '" + title + '\'' + 
			",slug = '" + slug + '\'' + 
			",url = '" + url + '\'' + 
			",crawl_rate = '" + crawlRate + '\'' + 
			"}";
		}
}