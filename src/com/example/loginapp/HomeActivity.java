package com.example.loginapp;

import com.example.loginapp.async.getJobAsyncTask;
import com.example.loginapp.model.Model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {
	// USERNAME_KEY will always be set to the current username
	public final static String USERNAME_KEY = "username";
	private String jobTitle;
	private String username;
	EditText searchField;
	Model model = Model.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		// setting the variable username to the current user's username
		username = Model.getInstance().getCurrentUser().getUserName();
		searchField = 
				(EditText)this.findViewById(R.id.searchInputField);

		
		
		new getJobAsyncTask().execute("http://172.17.0.31/~n00090048/Appli/Android/getJobs.php");
		

	}

	public void viewProfile(View v) {
		jobTitle =  searchField.getText().toString();
		//if search bar is empty or contains nothing but spaces - Toast the user
		if(jobTitle.isEmpty() || jobTitle.trim().isEmpty())
		{
			Toast.makeText(this, "Please enter a Job title", Toast.LENGTH_SHORT).show();
		} else{
			//Prevent users from adding job results to existing refined job list
			model.emptyRefinedJobList();
			Intent i = new Intent(this, ProfileActivity.class);
			i.putExtra(USERNAME_KEY, username);
			i.putExtra("jobTitle", jobTitle);
			i.putExtra("resetJobCount", 0);
			Log.i("msg",jobTitle);
			startActivity(i);
		}
		
		
	}

	

}
