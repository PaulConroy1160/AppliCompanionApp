package com.example.loginapp.adapter;

import java.util.ArrayList;





//import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import com.example.loginapp.JobApplicationFragment;
import com.example.loginapp.PostJobFragment;
import com.example.loginapp.PassFragment;

public class PagerAdapter extends FragmentPagerAdapter {

	// declaring framentArray as a new arraylist to hold each fragment
	ArrayList<Fragment> fragmentArray = new ArrayList<Fragment>();
	int pagePosition;

	public PagerAdapter(FragmentManager fm) {
		super(fm);
		// creating an instance of ProfileFragment called pFrag
		PassFragment pFrag = new PassFragment();
		// createing an instance of BioFragment called bFrag
		PostJobFragment jFrag = new PostJobFragment();
		
		JobApplicationFragment jAFrag = new JobApplicationFragment();
		// adding both instances to the fragment arraylist
		fragmentArray.add(pFrag);
		fragmentArray.add(jAFrag);
		fragmentArray.add(jFrag);
		
		
		
		
		
	}

	@Override
	public Fragment getItem(int arg0) {
		// Each fragment will be assigned a swipe
		switch (arg0) {
		case 0:
			pagePosition = 0;
			return fragmentArray.get(0);
		case 1:
			pagePosition = 1;
			return fragmentArray.get(1);
		case 2:
			pagePosition = 2;
			return fragmentArray.get(2);
		default:
			break;
		}
		return null;
	}

	@Override
	public int getCount() {
		// return the size of the fragment arraylist
		return fragmentArray.size();
	}
	
	public int getPagePosition(){
		return pagePosition;
	}
	
	
	
	
	
}
