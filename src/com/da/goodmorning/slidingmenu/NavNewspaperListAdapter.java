package com.da.goodmorning.slidingmenu;

import java.util.ArrayList;

import com.da.goodmorning.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavNewspaperListAdapter extends BaseAdapter {
	private Context context;
    private ArrayList<NavNewspaperItem> navFeedItems;
    
	public NavNewspaperListAdapter(Context context,
			ArrayList<NavNewspaperItem> navDrawerItems) {
		super();
		this.context = context;
		this.navFeedItems = navDrawerItems;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return navFeedItems.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return navFeedItems.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if (arg1 == null) {
			LayoutInflater  minflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			arg1 = minflater.inflate(R.layout.drawer_list_item, null);
		}
		ImageView imgIcon = (ImageView) arg1.findViewById(R.id.icon);
        TextView txtTitle = (TextView) arg1.findViewById(R.id.title);
        TextView txtCount = (TextView) arg1.findViewById(R.id.counter);
          
        imgIcon.setImageResource(navFeedItems.get(arg0).getIcon());        
        txtTitle.setText(navFeedItems.get(arg0).getTitle());
        if (navFeedItems.get(arg0).isSelected()){
        	txtTitle.setTextColor(arg1.getResources().getColor(R.color.list_item_selected));
        } else {
        	txtTitle.setTextColor(arg1.getResources().getColor(R.color.list_item_title));
        }
        // displaying count
        // check whether it set visible or not
        if(navFeedItems.get(arg0).getCounterVisibility()){
            txtCount.setText(navFeedItems.get(arg0).getCount());
        }else{
            // hide the counter view
            txtCount.setVisibility(View.GONE);
        }
		return arg1;
	}

}
