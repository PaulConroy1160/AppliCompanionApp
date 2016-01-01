package com.example.loginapp;



import java.util.List;

import com.example.loginapp.model.Job;
import com.example.loginapp.model.Model;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class JobApplicationFragment extends Fragment {
	Model model;
	List<Job> jobList;
	Job j;
	String title;
	String company;
	String location;
	String contract;
	String summary;
	String rPackage;
	int id;
	
	boolean newJob = false;
	
	TextView t;
	TextView c;
	TextView l;
	TextView s;
	TextView rP;
	TextView ct;

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// construct a view and inflate it with the profile_fragment_layout and
			// container, passing no bundle information
			View myInflatedView = inflater.inflate(
					R.layout.job_application_fragment_layout, container, false);
			// get instance of the model
			model = Model.getInstance();
			/*
			// local variables being set to user values
			String profileName = model.getCurrentUser().getUserName();
			String profileName2 = model.getCurrentUser().getUserName2();

			// setting each TextView on the ProfileFragment to variables and editing
			// the placeholder text with values from the user
			TextView t = (TextView) myInflatedView.findViewById(R.id.profileName);
			t.setText(profileName + " " + profileName2);
			
			*/
			j = model.getCurrentJob();
			
			String title = j.getTitle();
			String company = j.getCompany();
			String location = j.getLocation();
			String contract = j.getContractType();
			String summary = j.getSummary();
			String rPackage = j.getrPackage();
			int id = j.getId();
			
			t = (TextView) myInflatedView.findViewById(R.id.jobTitle);
			//t.setText(title);
			c = (TextView) myInflatedView.findViewById(R.id.company);
			//c.setText(company);
			l = (TextView) myInflatedView.findViewById(R.id.location);
			//l.setText(location);
			s = (TextView) myInflatedView.findViewById(R.id.summary);
			//s.setText("PHP JOB");
			rP = (TextView) myInflatedView.findViewById(R.id.salary);
			//rP.setText(rPackage);
			ct = (TextView) myInflatedView.findViewById(R.id.contractId);
			
			this.setJob();

			// return View
			return myInflatedView;
		}
		
		@Override 
		public void setUserVisibleHint(boolean isVisibleToUser) { 
			super.setUserVisibleHint(isVisibleToUser);
			if (isVisibleToUser) {
				//Toast.makeText(JobApplicationFragment.this.getActivity(), "NEW JOB", Toast.LENGTH_LONG).show();
				
				//ADD CODE TO GENERATE NEW JOB DETAILS HERE
				if(newJob){
					this.setJob();
				} else {
				newJob = true;
				}
				
				//getActivity().finish();
				
		 
		    }
				
			
		}
		
		public void setJob(){
			j = model.getCurrentJob();
			
			title = j.getTitle();
			company = j.getCompany();
			location = j.getLocation();
			contract = j.getContractType();
			summary = j.getSummary();
			rPackage = j.getrPackage();
			id = j.getId();
			
			
			
			t.setText(title);
			c.setText(company);
			l.setText("Location: " +location);
			s.setText(summary);
			rP.setText("Salary: "+rPackage);
			ct.setText("Contract: "+contract);
		}
	}



