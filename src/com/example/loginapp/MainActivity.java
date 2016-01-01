package com.example.loginapp;

import java.io.IOException;
import java.util.ArrayList;

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

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginapp.async.userAsyncTask;
import com.example.loginapp.model.Model;
import com.example.loginapp.model.User;



public class MainActivity extends Activity {
	
	ArrayList<User> usersList;
	Model m = Model.getInstance();
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		setContentView(R.layout.activity_main);
		
		new userAsyncTask().execute("http://172.17.0.31/~n00090048/Appli/users.php");
	}

	public void onLogin(View v) {
		// local variables
		String email;
		String password;

		// declaring EditTexts and setting them to the value of my layout's
		// EditTexts
		EditText emailField = (EditText) this
				.findViewById(R.id.emailInputField);
		EditText passwordField = (EditText) this
				.findViewById(R.id.passwordField);

		// comes back as text object - converts to string
		email = emailField.getText().toString();
		password = passwordField.getText().toString();

		// Get instance of model and user
		Model m = Model.getInstance();
		User u = m.findUserByEmail(email);

		// if email is not null and both passwords are the same - login
		// successful
		if (u != null && u.getPassword().equals(password)) {
			Toast.makeText(this, "Login Complete",
					Toast.LENGTH_LONG).show();
			// set intent i with the HomeActivity class
			Intent i = new Intent(this, HomeActivity.class);
			// set this user as the current user
			m.setCurrentUser(u);
			
			Log.i("user Id","id = "+u.getId());
			// start HomeActivity activity
			startActivity(i);
		} else {
			Toast.makeText(this, "Invalid Details", Toast.LENGTH_LONG).show();
		}
	}

	public void onRegister(View v) {
		// set intent i with the RegistrationActivity
		Intent i = new Intent(this, RegistrationActivity.class);
		// start RegistrationActivity activity
		startActivity(i);
	}
	
	 

	}

