package com.example.loginapp.async;

import java.io.IOException;
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

import com.example.loginapp.model.Job;
import com.example.loginapp.model.Model;

import android.os.AsyncTask;

public class getJobAsyncTask extends AsyncTask<String,Void,Boolean>{
	private List<Job> jobsList;
	Model m = Model.getInstance();

	@Override
	protected Boolean doInBackground(String... params) {
		// TODO Auto-generated method stub
		try {
		//	HttpGet httppost = new HttpGet(params[0]);
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(params[0]);
		HttpResponse response = client.execute(post);
		int status = response.getStatusLine().getStatusCode();
		
		
		
		if( status == 200){
			HttpEntity entity = response.getEntity();
			String data = EntityUtils.toString(entity);
			
			JSONObject jObj = new JSONObject(data);
			JSONArray jArray = jObj.getJSONArray("Jobs");
			
			for(int i = 0; i< jArray.length(); i++){
				JSONObject jRealObject = jArray.getJSONObject(i);
				Job job = new Job();
				
				
				job.setId(jRealObject.getInt("id"));
				job.setTitle(jRealObject.getString("title"));
				job.setCompany(jRealObject.getString("company"));
				job.setrPackage(jRealObject.getString("rPackage"));
				job.setSummary(jRealObject.getString("summary"));
				job.setLocation(jRealObject.getString("location"));
				job.setContractType(jRealObject.getString("contractType"));
				
				m.addJob(job);
			}
			
			
		}
		
		
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//will cause problems - needs FIXING!
		return !m.getJobs().isEmpty();
	}
	
	
	@Override
	protected void onPostExecute(Boolean result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
		
		if(result == false){
			
		} else{

		}
}
}
