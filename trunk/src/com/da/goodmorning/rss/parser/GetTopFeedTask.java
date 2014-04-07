package com.da.goodmorning.rss.parser;

import com.da.goodmorning.rss.Feed;

import android.os.AsyncTask;



public class GetTopFeedTask extends AsyncTask<String, Void, Feed> {

	public GetTopFeedTask() {
		// TODO Auto-generated constructor stub
	}
	
	private Feed getTopFeed(String feedUrl) {
		// First create a new XMLInputFactory
	RSSFeedParser reader = new RSSFeedParser(feedUrl);
	return reader.getTopFeed();
}

	@Override
	protected Feed doInBackground(String... params) {
		// TODO Auto-generated method stub
		return getTopFeed(params[0]);
	}
	

}
