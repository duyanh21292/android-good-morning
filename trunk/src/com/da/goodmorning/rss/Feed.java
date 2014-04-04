package com.da.goodmorning.rss;

public class Feed {
	private String title = "";
	private String description = "";
	private String pubDate = "";
	private String link = "";
	private String guid = "";

	public Feed() {
		// TODO Auto-generated constructor stub
	}
	
	public Feed(String title, String description, String pubDate, String link,
			String guid) {
		super();
		this.title = title;
		this.description = description;
		this.pubDate = pubDate;
		this.link = link;
		this.guid = guid;
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getDescription() {
		return description;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPubDate() {
		return pubDate;
	}

	@Override
	public String toString() {
		return "Feed [description=" + description
				+ ",  link=" + link + ", pubDate="
				+ pubDate + ", title=" + title + "]";
	}
}
