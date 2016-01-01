package com.example.loginapp.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.widget.Toast;

public class Model {
	// create a static instance of model - set to null
	private static Model instance = null;

	// synchronized locks method
	public static synchronized Model getInstance() {
		if (instance == null) {
			instance = new Model();
		}
		return instance;
	}

	// An arraylist to hold the users and jobs are declared
	private List<User> usersList;
	private List<Job> jobs;
	private List<Job> refinedJobs;
	private Job currentJob;
	int x = 0;
	// A user object called currentUser is declared
	private User currentUser;

	private Model() {
		// set each users and jobs list to a new arraylist
		this.jobs = new ArrayList<Job>();
		this.usersList = new ArrayList<User>();
		this.refinedJobs = new ArrayList<Job>();

	}

	public List<User> getUsers() {
		// returns copy of users
		return new ArrayList<User>(this.usersList);
	}

	public List<Job> getJobs() {
		// returns copy of jobs
		return new ArrayList<Job>(this.jobs);
	}

	public void addUser(User u) {
		// adds user
		this.usersList.add(u);
	}
	
	public void addJob(Job j){
		this.jobs.add(j);
	}
	
	

	public User findUserByUsername(String userName) {
		// find a user match the string that has been passed through the
		// method's parameters
		// set u to null
		User u = null;
		// set int i to 0
		int i = 0;
		// boolean found will be false
		boolean found = false;

		// while within the size of the users array and is not found
		while (i < this.usersList.size() && !found) {
			// pass through the arraylist
			u = this.usersList.get(i);
			// if the username matches a username in the arraylist the boolean
			// found will be set to true
			if (u.getUserName().equalsIgnoreCase(userName)) {
				found = true;
			} else {
				// increment the int until the int as exceeded the arraylist's
				// index
				i++;
			}
		}
		if (!found) {
			// no user found
			u = null;
		}
		// return user
		return u;
	}
	
	public User findUserByEmail(String email) {
		// find a user match the string that has been passed through the
		// method's parameters
		// set u to null
		User u = null;
		// set int i to 0
		int i = 0;
		// boolean found will be false
		boolean found = false;

		// while within the size of the users array and is not found
		while (i < this.usersList.size() && !found) {
			// pass through the arraylist
			u = this.usersList.get(i);
			// if the email matches a email in the arraylist the boolean
			// found will be set to true
			if (u.getEmail().equalsIgnoreCase(email)) {
				found = true;
			} else {
				// increment the int until the int as exceeded the arraylist's
				// index
				i++;
			}
		}
		if (!found) {
			// no user found
			u = null;
		}
		// return user
		return u;
	}

	public User getCurrentUser() {
		// return the current user
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		// sets this user as the current user
		this.currentUser = currentUser;
	}
	
	public void findJobsByTitle(List<Job> jobList,String title){
		Job j = null;
		boolean found = false;
		this.refinedJobs = new ArrayList<Job>();
		
		for(int i = 0; i !=jobs.size();i++){
			j = this.jobs.get(i);
			String jobTitle = j.getTitle().toUpperCase();
			if(jobTitle.contains(title)){
				refinedJobs.add(j);
			}
		}
		
			
	}
	
	public List<Job> getRefinedJobList(){
		return refinedJobs;
	}
	
	public void emptyRefinedJobList(){
		this.refinedJobs = new ArrayList<Job>();
	}
	
	public Job getCurrentJob(){
		return currentJob;
	}
	
	public void setCurrentJob(int x){
		if(refinedJobs.isEmpty()){
			currentJob = null;
		} else{
		currentJob = refinedJobs.get(x);
		}
	}
	
}
