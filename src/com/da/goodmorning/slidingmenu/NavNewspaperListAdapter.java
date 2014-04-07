package com.da.goodmorning.slidingmenu;

import java.util.ArrayList;

import com.da.goodmorning.R;

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
	
	public void setAllItemNonSelected(){
		for (NavNewspaperItem item : navFeedItems) {
			if (item.isSelected())
				item.setSelected(false);
		}
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
	
	static class ViewHolder {
		protected ImageView ivIcon;
		protected TextView tvNewsPaperName;
		protected TextView tvFeedCounter;
	}
	
	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if (arg1 == null) {
			LayoutInflater  minflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			arg1 = minflater.inflate(R.layout.drawer_newspaper_list_item, null);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.ivIcon = (ImageView) arg1.findViewById(R.id.icon);
			viewHolder.tvFeedCounter = (TextView) arg1.findViewById(R.id.counter);
			viewHolder.tvNewsPaperName = (TextView) arg1.findViewById(R.id.title);
			arg1.setTag(viewHolder);
			viewHolder.tvNewsPaperName.setTag(navFeedItems.get(arg0));
		} else {
			((ViewHolder) arg1.getTag()).tvNewsPaperName
			.setTag(navFeedItems.get(arg0));
		}
		ViewHolder viewHolder = (ViewHolder) arg1.getTag();
        NavNewspaperItem newsPaperitem = (NavNewspaperItem) getItem(arg0);
        if (newsPaperitem !=null) {
        	viewHolder.ivIcon.setImageResource(newsPaperitem.getIcon());        
            viewHolder.tvNewsPaperName.setText(newsPaperitem.getTitle());
            if (newsPaperitem.isSelected()){
            	viewHolder.tvNewsPaperName.setTextColor(arg1.getResources().getColor(R.color.list_item_selected));
            } else {
            	viewHolder.tvNewsPaperName.setTextColor(arg1.getResources().getColor(R.color.list_item_title));
            }
            
            if(newsPaperitem.getCounterVisibility()){
            	viewHolder.tvFeedCounter.setText(navFeedItems.get(arg0).getCount());
            }else{
            	viewHolder.tvFeedCounter.setVisibility(View.GONE);
            }
        }
		return arg1;
	}

}
