package com.da.goodmorning.fragment;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.da.goodmorning.R;
import com.da.goodmorning.newspaper.INewspaper;
import com.da.goodmorning.newspaper.NewspaperModel;
import com.da.goodmorning.rss.Feed;
import com.da.goodmorning.rss.FeedArrayAdapter;
import com.da.goodmorning.rss.parser.GetAllFeedTask;
import com.da.goodmorning.rss.parser.RSSFeedParser;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class PageFragment extends Fragment {
	private NewspaperModel newspaperModel;
	
	public PageFragment(NewspaperModel newspaperModel) {
		this.newspaperModel = newspaperModel;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_find_people, container, false);
		try {
			GetAllFeedTask getAllFeedTask = new GetAllFeedTask();
			AsyncTask<String,Void,List<Feed>> execute = getAllFeedTask.execute(newspaperModel.getUrlRSS());
			List<Feed> listFeeds = execute.get();
			ListView listView = (ListView) rootView.findViewById(R.id.listViewFeeds);
	        FeedArrayAdapter adapter = new FeedArrayAdapter(getActivity(), R.layout.feed_item_layout, listFeeds);
	        listView.setAdapter(adapter);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return rootView;
    }
	
	
}
