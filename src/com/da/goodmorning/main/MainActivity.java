package com.da.goodmorning.main;

import java.util.ArrayList;
import java.util.List;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.da.goodmorning.R;
import com.da.goodmorning.fragment.PageFragment;
import com.da.goodmorning.fragment.home.HomeFragment;
import com.da.goodmorning.newspaper.NewspaperManagement;
import com.da.goodmorning.newspaper.NewspaperModel;
import com.da.goodmorning.rss.FeedArrayAdapter;
import com.da.goodmorning.slidingmenu.NavNewspaperItem;
import com.da.goodmorning.slidingmenu.NavNewspaperListAdapter;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class MainActivity extends Activity {

	private ListView _listView;
	private FeedArrayAdapter _feedArrayAdapter;

	private DrawerLayout drawerLayoutMain;
	private ListView listViewNewspaper;
	private ActionBarDrawerToggle drawerToggle;
	private CharSequence drawerTitle;
	private CharSequence titleContainer;
	private ArrayList<NavNewspaperItem> alistNewspaperItems;
	private NavNewspaperListAdapter listAdapterNewspaper;
	private NewspaperManagement newspaperManagement;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		titleContainer = drawerTitle = getTitle();
		drawerLayoutMain = (DrawerLayout) findViewById(R.id.drawer_layout_main);
		listViewNewspaper = (ListView) findViewById(R.id.list_slidermenu_newspaper);
		View header = View.inflate(this,
				R.layout.list_slidermenu_header_layout, null);
		listViewNewspaper.addHeaderView(header);

		listViewNewspaper.setOnItemClickListener(new SlideMenuClickListener());
		
		newspaperManagement = new NewspaperManagement(getResources());
		loadListNewspapers();

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		drawerToggle = new ActionBarDrawerToggle(this, drawerLayoutMain,
				R.drawable.ic_drawer, R.string.app_name, R.string.app_name) {
			@Override
			public void onDrawerClosed(View drawerView) {
				// TODO Auto-generated method stub
				getActionBar().setTitle(titleContainer);
				invalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				// TODO Auto-generated method stub
				getActionBar().setTitle(drawerTitle);
				invalidateOptionsMenu();
			}
		};

		drawerLayoutMain.setDrawerListener(drawerToggle);

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			displayView(0);
		}

		// this._listView = (ListView) findViewById(R.id.lv_gm_main_list_feeds);
		// GetRSSTask rss = new GetRSSTask();
		// AsyncTask<String,Void,List<Feed>> execute =
		// rss.execute(getString(R.string.url_vnexpress_dulich));
		// try {
		// fillData(execute.get());
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (ExecutionException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	private void loadListNewspapers() {
		alistNewspaperItems = new ArrayList<NavNewspaperItem>();

		List<NewspaperModel> listNewspaper = newspaperManagement.getListNewspaper();
		for (NewspaperModel newspaperModel : listNewspaper) {
			alistNewspaperItems.add(newspaperModel.getNavNewspaper());
		}
		listAdapterNewspaper = new NavNewspaperListAdapter(this,
				alistNewspaperItems);
		listViewNewspaper.setAdapter(listAdapterNewspaper);
	}

	private class SlideMenuClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			displayView(position);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// toggle nav drawer on selecting action bar app icon/title
		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/* *
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		boolean drawerOpen = drawerLayoutMain.isDrawerOpen(listViewNewspaper);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	/**
	 * Diplaying fragment view for selected nav drawer list item
	 * */
	private void displayView(int position) {
		// update the main content by replacing fragments
		Fragment fragment = null;
		String stackName = "fragHome";
		String tagName = "fragHome";
		String title = "";
		int iconId = R.drawable.ic_launcher;
		switch (position) {
		case 0:
			fragment = new HomeFragment();
			title = getResources().getStringArray(
					R.array.nav_newspaper_items)[0];
			stackName = "fragHome";
			tagName = "fragHome";
			break;

		default:
			NewspaperModel newspaperModel = newspaperManagement.getNewspaperModel(position - 1);
			title = newspaperModel.getName();
			iconId = newspaperModel.getLargeIcon();
			fragment = new PageFragment(newspaperModel);
			stackName = "fragPeople";
			tagName = "fragPeople";
			break;
		}

		if (fragment != null) {
			listAdapterNewspaper.setAllItemNonSelected();
			if (position > 0) {
				((NavNewspaperItem) listAdapterNewspaper.getItem(position-1))
						.setSelected(true);
			}
			listAdapterNewspaper.notifyDataSetChanged();
			FragmentManager fragmentManager = getFragmentManager();

			fragmentManager.beginTransaction()
					.replace(R.id.frame_main_container, fragment, tagName)
					.addToBackStack(stackName).commit();

			// update selected item and title, then close the drawer
			listViewNewspaper.setItemChecked(position, true);
			listViewNewspaper.setSelection(position);
			setTitle(title);
			getActionBar().setIcon(iconId);
			drawerLayoutMain.closeDrawer(listViewNewspaper);
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		titleContainer = title;
		getActionBar().setTitle(titleContainer);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		drawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		drawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (getFragmentManager().getBackStackEntryCount() == 0) {
				this.finish();
				return true;
			} else {
				getFragmentManager().popBackStack("fragHome",
						FragmentManager.POP_BACK_STACK_INCLUSIVE);
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}

	public void removeCurrentFragment() {
		FragmentTransaction transaction = getFragmentManager()
				.beginTransaction();

		Fragment currentFrag = getFragmentManager().findFragmentById(
				R.id.frame_main_container);
	}
}
