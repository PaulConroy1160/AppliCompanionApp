package com.example.loginapp;

import com.example.loginapp.model.Model;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PassFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// construct a view and inflate it with the profile_fragment_layout and
		// container, passing no bundle information
		View myInflatedView = inflater.inflate(
				R.layout.pass_fragment_layout, container, false);
		// get instance of the model
		Model model = Model.getInstance();
		// local variables being set to user values
		//String profileName = model.getCurrentUser().getUserName();
		//String profileName2 = model.getCurrentUser().getUserName2();

		// setting each TextView on the ProfileFragment to variables and editing
		// the placeholder text with values from the user
		//TextView t = (TextView) myInflatedView.findViewById(R.id.profileName);
		//t.setText(profileName + " " + profileName2);
		
		


		// return View
		return myInflatedView;
	}
	
	@Override 
	public void setUserVisibleHint(boolean isVisibleToUser) { 
		super.setUserVisibleHint(isVisibleToUser);
		if (isVisibleToUser) {
			
			this.ignoreJob();
			
			//getActivity().finish();
			
	 
	    }
	}
	
	public void ignoreJob(){
		Activity myActivity = PassFragment.this.getActivity();
		if (myActivity instanceof ProfileActivity) {
			ProfileActivity pActivity = (ProfileActivity)myActivity;
			pActivity.returnFragment();
		}
	}
}
