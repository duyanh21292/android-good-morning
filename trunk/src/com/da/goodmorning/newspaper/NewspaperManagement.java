package com.da.goodmorning.newspaper;

import java.util.LinkedList;
import java.util.List;

import android.content.res.Resources;
import android.content.res.TypedArray;

import com.da.goodmorning.R;

public class NewspaperManagement {
	private List<NewspaperModel> listNewspaper;
	private Resources rsc;
	
	public static int DAN_TRI = 1;
	public static int VNEXPRESS = 2;
	public static int H_24 = 3;
	public static int KENH_14 = 4;
	public static int GAME_K = 5;
	public static int TIN_THE_THAO = 6;
	
	public NewspaperManagement(Resources rsc) {
		// TODO Auto-generated constructor stub
		listNewspaper = new LinkedList<NewspaperModel>();
		this.rsc = rsc;
		initDefaultListNewspaper();
	}

	private Resources getResources() {
		// TODO Auto-generated method stub
		return rsc;
	}

	private void initDefaultListNewspaper(){
		String[] navMenuTitles = getResources().getStringArray(
				R.array.nav_newspaper_items);
		TypedArray navMenuIcons = getResources().obtainTypedArray(
				R.array.nav_newspaper_items_icons);
		NewspaperModel dantriNews = new NewspaperModel(DAN_TRI,navMenuTitles[DAN_TRI], getResources().getString(R.string.url_dantri_thethao), navMenuIcons.getResourceId(DAN_TRI, -1), null);
		NewspaperModel vnexNews = new NewspaperModel(VNEXPRESS,navMenuTitles[VNEXPRESS], getResources().getString(R.string.url_vnexpress_top), navMenuIcons.getResourceId(VNEXPRESS, -1), null);
		NewspaperModel h24News = new NewspaperModel(H_24,navMenuTitles[H_24], getResources().getString(R.string.url_24h_top), navMenuIcons.getResourceId(H_24, -1), null);
		NewspaperModel k14News = new NewspaperModel(KENH_14,navMenuTitles[KENH_14], getResources().getString(R.string.url_kenh14_top), navMenuIcons.getResourceId(KENH_14, -1), null);
		NewspaperModel gameKNews = new NewspaperModel(GAME_K,navMenuTitles[GAME_K], getResources().getString(R.string.url_gamek_top), navMenuIcons.getResourceId(GAME_K, -1), null);
		NewspaperModel tinTheThaoNews = new NewspaperModel(TIN_THE_THAO,navMenuTitles[TIN_THE_THAO], getResources().getString(R.string.url_tinthethao_top), navMenuIcons.getResourceId(TIN_THE_THAO, -1), null);
		
		listNewspaper.add(dantriNews);
		listNewspaper.add(vnexNews);
		listNewspaper.add(h24News);
		listNewspaper.add(k14News);
		listNewspaper.add(gameKNews);
		listNewspaper.add(tinTheThaoNews);
	}
	
	public void addNewspaper(NewspaperModel newspaper) {
		listNewspaper.add(newspaper);
	}
	
	public void changePositionNewspaper(NewspaperModel newspaper, int oderPosition){
		listNewspaper.remove(newspaper);
		listNewspaper.add(oderPosition, newspaper);
	}
	
	public List<NewspaperModel> getListNewspaper() {
		return listNewspaper;
	}
	
	public NewspaperModel getNewspaperModel(int position) {
		return listNewspaper.get(position);
	}
}
