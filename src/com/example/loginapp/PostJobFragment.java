package com.example.loginapp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginapp.model.Model;

public class PostJobFragment extends Fragment {
	// get instance of the model
	Model model = Model.getInstance();
	int id = model.getCurrentUser().getId();
	String seekerId = String.valueOf(id);
	String jobId = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// construct a view and inflate it with the bio_fragment_layout and
		// container, passing no bundle information
		View myInflatedView = inflater.inflate(R.layout.save_fragment_layout,
				container, false);
		
		// local variables being set to user values
		//String user = model.getCurrentUser().getUserName();
		//String email = model.getCurrentUser().getEmail();

		Log.i("user id =", "id = "+model.getCurrentUser().getId());
		
		
		

		// setting each TextView on the BioFragment to variables and editing the
		// placeholder text with values from the user
		//TextView u = (TextView) myInflatedView.findViewById(R.id.bioHeader);
		//u.setText(user + "'s profile information");
		//TextView v = (TextView) myInflatedView.findViewById(R.id.email);
		//v.setText("Email: " + email);
			
		return myInflatedView;
		
		// return View
		
	}
	
	@Override 
	public void setUserVisibleHint(boolean isVisibleToUser) { 
		super.setUserVisibleHint(isVisibleToUser);
		if (isVisibleToUser) {
			int jId = model.getCurrentJob().getId();
			jobId = String.valueOf(jId);
			this.postData();
			
			//getActivity().finish();
			
	 
	    }
			
		
	}
	
	public void postData() {
		AsyncTask<HttpPost, Integer, HttpResponse> myTask = new AsyncTask<HttpPost, Integer, HttpResponse>() {

			@Override
			protected HttpResponse doInBackground(HttpPost... urls) {
				HttpPost post = urls[0];
				HttpClient client = new DefaultHttpClient();  
		            HttpResponse responsePOST = null;
					try {
						responsePOST = client.execute(post);
					} catch (ClientProtocolException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
		            return responsePOST;
			}
			
			@Override
			protected void onPostExecute(HttpResponse responsePOST) {
				if (responsePOST != null) {
					HttpEntity resEntity = responsePOST.getEntity();  
		            if (resEntity != null) {    
		                try {
							Log.i("RESPONSE",EntityUtils.toString(resEntity));
							Toast.makeText(PostJobFragment.this.getActivity(), "Job Saved", Toast.LENGTH_SHORT).show();
							
							Activity myActivity = PostJobFragment.this.getActivity();
							if (myActivity instanceof ProfileActivity) {
								ProfileActivity pActivity = (ProfileActivity)myActivity;
								pActivity.returnFragment();
							}
							
							
						} 
		                catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
		                catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
				}
			}
			
		};

        String postURL = "http://172.17.0.31/~n00090048/Appli/saveJob.php";
        HttpPost post = new HttpPost(postURL); 
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("sId", seekerId ));
        params.add(new BasicNameValuePair("jId", jobId));
        UrlEncodedFormEntity ent;
		try {
			ent = new UrlEncodedFormEntity(params,HTTP.UTF_8);
	        post.setEntity(ent);
			myTask.execute(post);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
