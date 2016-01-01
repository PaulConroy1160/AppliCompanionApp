package com.example.loginapp;

import java.util.ArrayList;
import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;


import android.view.Window;
import android.widget.Toast;

import com.example.loginapp.adapter.PagerAdapter;
import com.example.loginapp.model.Job;
import com.example.loginapp.model.Model;

public class ProfileActivity extends FragmentActivity {

	// constructing the viewPager
	ViewPager viewPager;
	PagerAdapter pAdapter;
	String title;
	Model m = Model.getInstance();
	List<Job> jobList;
	List<Job> refinedJobs;
	Job currentJob = new Job();
	int i = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		// set the content layout to activity_pager.xml
		setContentView(R.layout.activity_pager);
		// set the viewPager with the id pager on the activity_pager.xml
		viewPager = (ViewPager) findViewById(R.id.pager);
		// create an instance of the PagerAdapter
		pAdapter = new PagerAdapter(getSupportFragmentManager());
		//Constructing and declaring a Bundle to retrieve intent values passed
		Intent intent = getIntent();
		
		Log.i("i count =", " "+i);
		m.emptyRefinedJobList();
		i = 0;
		
		title = intent.getStringExtra("jobTitle");
		title = title.toUpperCase();
		Log.i("job title is:",title);
		jobList = m.getJobs();
		Log.i("TESTING","BEFORE findJobsTitle ");
		m.findJobsByTitle(jobList, title);
		Log.i("TESTING","AFTER finJobsTitle ");
		m.setCurrentJob(i);
		currentJob = m.getCurrentJob();
		
		
		if(currentJob == null){
			i = 0;
			this.finish();
			Toast.makeText(ProfileActivity.this, "No '"+title+"' job openings found.", Toast.LENGTH_SHORT).show();
		}
		
		Log.i("TESTING","AFTER setCurrentJob ");
		refinedJobs = m.getRefinedJobList();
		
		
		
		
		

		// pass the pAdapter into the setAdapter method in viewPager
		viewPager.setAdapter(pAdapter);
		viewPager.setCurrentItem(1);		
	}
	
	
	public void returnFragment(){
		Log.i("msg","ss");
		
			if(pAdapter.getPagePosition() == 2 || pAdapter.getPagePosition() == 0){
				
				i++;
				
				if(refinedJobs.isEmpty()){
					this.finish();
				}
				
				Log.i("i =: ",""+i);
				
				Log.i("Refined =: ",""+refinedJobs.size());
				
				if(i == refinedJobs.size()){
					Toast.makeText(ProfileActivity.this, "No more '"+title+"' job openings.", Toast.LENGTH_SHORT).show();
					i = 0;
					m.emptyRefinedJobList();
					this.finish();
				} else{
					m.setCurrentJob(i);
					viewPager.setCurrentItem(1);	
				}
				Log.i("before i++", " "+i);
				
				
			}
		
	}
	
	
	
	
	
	
	
	

}
