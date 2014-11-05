package com.da.goodmorning.fragment.home;

import com.da.goodmorning.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class HomeFragment extends Fragment {
	private ListView _listViewMainContain;
	
	public HomeFragment() {
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        _listViewMainContain = (ListView) rootView.findViewById(R.id.lv_fraghome_maincontent); 
        return rootView;
    }
}
