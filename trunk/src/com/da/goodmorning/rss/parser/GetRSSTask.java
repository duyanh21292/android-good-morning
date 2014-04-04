package com.da.goodmorning.rss.parser;

import java.util.List;

import android.os.AsyncTask;

import com.da.goodmorning.rss.Feed;

public class GetRSSTask extends AsyncTask<String,Void,List<Feed>> {

	public GetRSSTask() {
		// TODO Auto-generated constructor stub
	}

	private List<Feed> getAllFeed(String feedUrl) {
			// First create a new XMLInputFactory
		XMLFeedParser reader = new XMLFeedParser(feedUrl);
		return reader.getListFeeds();
	}


	@Override
	protected List<Feed> doInBackground(String... params) {
		// TODO Auto-generated method stub
		return getAllFeed(params[0]);
	}
	
	
}
