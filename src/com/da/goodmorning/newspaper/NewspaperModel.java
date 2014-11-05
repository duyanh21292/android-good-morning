package com.da.goodmorning.newspaper;

import java.util.Map;

import com.da.goodmorning.slidingmenu.NavNewspaperItem;

public class NewspaperModel {
	private String name;
	private String urlRSS;
	private int largeIcon;
	private Map<String, String> mapCategWithRss;
	private NavNewspaperItem navNewspaper;
	
	public NewspaperModel(int order,String name, String urlHomePage, int largeIcon,
			Map<String, String> mapCategWithRss) {
		super();
		this.name = name;
		this.urlRSS = urlHomePage;
		this.largeIcon = largeIcon;
		this.mapCategWithRss = mapCategWithRss;
		this.navNewspaper = new NavNewspaperItem(order, name, largeIcon, "0", true);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrlRSS() {
		return urlRSS;
	}
	public void setUrlRSS(String urlHomePage) {
		this.urlRSS = urlHomePage;
	}
	public int getLargeIcon() {
		return largeIcon;
	}
	public void setLargeIcon(int largeIcon) {
		this.largeIcon = largeIcon;
	}
	public Map<String, String> getMapCategWithRss() {
		return mapCategWithRss;
	}
	public void setMapCategWithRss(Map<String, String> mapCategWithRss) {
		this.mapCategWithRss = mapCategWithRss;
	}

	public NavNewspaperItem getNavNewspaper() {
		return navNewspaper;
	}

	public void setNavNewspaper(NavNewspaperItem navNewspaper) {
		this.navNewspaper = navNewspaper;
	}
	
}
