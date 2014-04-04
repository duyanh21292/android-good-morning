package com.da.goodmorning.newspaper;

import java.util.LinkedHashMap;

public class NewspaperProperties {
	private String name = "";
	private String urlHomePage = "";
	private int largeIcon = 0;
	private LinkedHashMap<String, String> mapCategWithRss;
	public NewspaperProperties() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrlHomePage() {
		return urlHomePage;
	}
	public void setUrlHomePage(String urlHomePage) {
		this.urlHomePage = urlHomePage;
	}
	public int getLargeIcon() {
		return largeIcon;
	}
	public void setLargeIcon(int largeIcon) {
		this.largeIcon = largeIcon;
	}
	public LinkedHashMap<String, String> getMapCategWithRss() {
		return mapCategWithRss;
	}
	public void setMapCategWithRss(LinkedHashMap<String, String> mapCategWithRss) {
		this.mapCategWithRss = mapCategWithRss;
	}
}
