package com.da.goodmorning.fragment.home;

import java.util.List;

import com.da.goodmorning.R;
import com.da.goodmorning.rss.Feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeFeedListAdapter extends ArrayAdapter<Feed[]> {
	private View _view;
	private int _viewId;
	private Context _context;
	private List<Feed[]> _listFeeds;
	
	public HomeFeedListAdapter(Context context, int resource,
			int textViewResourceId, List<Feed[]> objects) {
		super(context, resource, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		this._context = context;
		this._viewId = resource;
		this._listFeeds = objects;
	}
	
	@Override
	public Feed[] getItem(int position) {
		// TODO Auto-generated method stub
		return _listFeeds.get(position);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		_view = convertView;
		if (_view == null) {
			LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			_view = inflater.inflate(_viewId, null);
		}
		Feed[] feeds = getItem(position);
		ImageView imv1 = (ImageView) _view.findViewById(R.id.iv_top_feed_1);
		TextView tv1 = (TextView) _view.findViewById(R.id.tv_top_feed_1);
		TextView tv2 = (TextView) _view.findViewById(R.id.tv_top_feed_2);
		TextView tv3 = (TextView) _view.findViewById(R.id.tv_top_feed_3);
		TextView tv4 = (TextView) _view.findViewById(R.id.tv_top_feed_4);
		for (int i = 0; i < feeds.length; i++) {
			if (i == 1) {
				
			}
		}
		return _view;
	}
	
}
