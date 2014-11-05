package com.da.goodmorning.rss;

import java.util.List;


import com.da.goodmorning.R;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class FeedArrayAdapter extends ArrayAdapter<Feed> {

	private View _view;
	private int _viewId;
	private Context _context;
	private List<Feed> _listFeeds;
	
	public FeedArrayAdapter(Context context, int resource, List<Feed> objects) {
		super(context, resource, objects);
		this._context = context;
		this._viewId = resource;
		this._listFeeds = objects;
		// TODO Auto-generated constructor stub
	}
	
	public Feed getFeedItem(int position) {
		// TODO Auto-generated method stub
		return _listFeeds.get(position);
	}
	
	static class ViewHolder {
		protected TextView tvTitle;
		protected TextView tvDesc;
		protected ImageView ivPubDate;
		protected TextView tvLink;
		protected TextView tvGuid;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		_view = convertView;
		if (convertView == null) {
			LayoutInflater layoutInflater = (LayoutInflater) _context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			_view = layoutInflater.inflate(_viewId, null);
		}
		Feed item = getFeedItem(position);
		if(item != null) {
			TextView tvTitle = (TextView) _view.findViewById(R.id.tv_gm_fItem_title);
			tvTitle.setText(Html.fromHtml(item.getTitle()));
			
			WebView wvDesc =  (WebView) _view.findViewById(R.id.wv_gm_fItem_desc);
			wvDesc.loadDataWithBaseURL(item.getLink(), item.getDescription(), "text/html", "UTF-8", "");
			
			TextView tvPubDate = (TextView) _view.findViewById(R.id.tv_gm_fItem_pDate);
			tvPubDate.setText(item.getPubDate());
			
//			TextView tvLink = (TextView) _view.findViewById(R.id.tv_gm_fItem_link);
//			tvLink.setText(item.getLink());
//			
//			TextView tvGuid = (TextView) _view.findViewById(R.id.tv_gm_fItem_guid);
//			tvGuid.setText(item.getGuid());
		}
		return _view;
	}

}
