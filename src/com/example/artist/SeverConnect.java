package com.example.artist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;


import android.util.Log;

public class SeverConnect {
	
	
	public JSONArray Query(String group,String code,String field,String where) {
		 
		try
		{
			
			String url = "http://140.114.55.172/ieem3900/Android_Query.php?group="+group+"&code="+code;
			List<NameValuePair> params = new ArrayList<NameValuePair> ();
	    	params.add(new BasicNameValuePair("field",field));
	    	params.add(new BasicNameValuePair("where",where));
			HttpPost httpRequest = new HttpPost(url);
			httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
    		HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
    		if(httpResponse.getStatusLine().getStatusCode()==200){
    			JSONArray jsonArray = new JSONArray(EntityUtils.toString(httpResponse.getEntity(),"UTF-8"));
    			return jsonArray;	}		
		}
		catch (ClientProtocolException e)
    	{
    		return null;
    	} catch (IOException e)
    	{
    		return null;
    	} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean Insert(String group,String code,String field,String value) {
		try
		{
			String url = "http://140.114.55.172/ieem3900/Android_Insert.php?group="+group+"&code="+code;
			List<NameValuePair> params = new ArrayList<NameValuePair> ();
	    	params.add(new BasicNameValuePair("field",field));
	    	params.add(new BasicNameValuePair("value",value));
			HttpPost httpRequest = new HttpPost(url);
			httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
    		HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
    		if(httpResponse.getStatusLine().getStatusCode()==200)
    			return true;
		}
		catch (ClientProtocolException e)
    	{
    		return false;
    	} catch (IOException e)
    	{
    		return false;
    	}
		return false;
	}
	
	public boolean Delete(String group,String code,String where) {
		try
		{
			String url = "http://140.114.55.172/ieem3900/Android_Delete.php?group="+group+"&code="+code;
			List<NameValuePair> params = new ArrayList<NameValuePair> ();
	    	params.add(new BasicNameValuePair("where",where));
			HttpPost httpRequest = new HttpPost(url);
			httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
    		HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
    		if(httpResponse.getStatusLine().getStatusCode()==200)
    			return true;
		}
		catch (ClientProtocolException e)
    	{
    		return false;
    	} catch (IOException e)
    	{
    		return false;
    	}
		return false;
	}
	public boolean Update(String group,String code,String set,String where) {
		try
		{
			String url = "http://140.114.55.172/ieem3900/Android_Update.php?group="+group+"&code="+code;
			List<NameValuePair> params = new ArrayList<NameValuePair> ();
	    	params.add(new BasicNameValuePair("set",set));
	    	params.add(new BasicNameValuePair("where",where));
			HttpPost httpRequest = new HttpPost(url);
			httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
    		HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
    		if(httpResponse.getStatusLine().getStatusCode()==200)
    			return true;
		}
		catch (ClientProtocolException e)
    	{
    		return false;
    	} catch (IOException e)
    	{
    		return false;
    	}
		return false;
	}
	
}