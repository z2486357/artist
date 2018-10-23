package com.example.artist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import android.location.Location;
import android.location.LocationListener;

import org.json.JSONArray;
import org.json.JSONException;

import com.example.artist.gps.MyLocationListener;
import com.google.android.gms.maps.model.LatLng;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;





@SuppressLint("NewApi")
public class compare extends Activity {
  
	int cc,hc = 0;
	float similarity=0;
	int mArrayColor[] = null;  
	ImageView buttoncamera;
	int mArrayColorLengh = 0;
	int finish=0;
	double dis;
	private static final long minDistnace = 5;
    private static final long minTime = 5000;
    protected LocationManager locationManager;
	double []Lat = new double [10];
	double []Lng = new double [10];
	double Latme;
	double Lngme;
	private ArrayList<LatLng> traceOfMe;
	private static long count = 0;
	Thread t;
	JSONArray ta = new JSONArray();
	String [] namestring = new String [100];
	private final double EARTH_RADIUS = 6378137.0;
	//Uri mImageCaptureUri1 = Uri.fromFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/captureimage.jpg"));
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		namestring[0]="compare0";
		namestring[1]="compare1";
		namestring[2]="compare2";
		namestring[3]="compare3";
		namestring[4]="compare4";
		namestring[5]="compare5";
		namestring[6]="compare6";
		namestring[7]="compare7";
		namestring[8]="compare8";
		namestring[9]="compare9";
		namestring[10]="compare10";
		Lng[0]=120.99681864;
		Lat[0]=24.79664965;
		Lng[1]=120.99543311;
		Lat[1]=24.79599367;
		Lng[2]=120.99423888;
		Lat[2]=24.79524178;
		Lng[3]=120.99443313;
		Lat[3]=24.79631801;
		Lng[4]=120.99353764;
		Lat[4]=24.79579901;
		Lng[5]=120.99441907;
		Lat[5]=24.79398122;
		Lng[6]=120.99348378;
		Lat[6]=24.79406479;
		Lng[7]=120.9938991;
		Lat[7]=24.79466844;
		Lng[8]=120.99352339;
		Lat[8]=24.79458361;
		Lng[9]=120.99361676;
		Lat[9]=24.79449891;
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.compare);
		ImageView bnext= (ImageView)findViewById(R.id.next);
		bnext.setOnClickListener(nextcl);
		ImageView bchange= (ImageView)findViewById(R.id.change);
		bchange.setOnClickListener(changecl);
		ImageView bagain= (ImageView)findViewById(R.id.again);
		bagain.setOnClickListener(againcl);
		Button bnew= (Button)findViewById(R.id.button1);
		bnew.setOnClickListener(newcl);
		buttoncamera = (ImageView)findViewById(R.id.compareview2);
		
		
		
		
		
		
		
		t = new Thread(r0);
		t.start();
	    buttoncamera.setOnClickListener(
		new Button.OnClickListener(){
		  public void onClick(View v){
		  //使用Intent調用其他相機幫忙拍照
		  Intent intent_camera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
	//	  intent_camera.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri1); 
		  //設定requestcode=0，執行onActivityResult
		  startActivityForResult(intent_camera,0);
		  }
		}	
	    );

		
	}
	private Button.OnClickListener nextcl = new Button.OnClickListener() {
		public void onClick(View v) {
			if(similarity >= 70 && finish<10)
			{
				finish++;
				ImageView imageView1 = (ImageView) findViewById( R.id.compareview1);
				String uri = "@drawable/";
				uri=uri+namestring[finish];
				int imageResource = getResources().getIdentifier(uri, null, getPackageName());
				Drawable image = getResources().getDrawable(imageResource);
				imageView1.setImageDrawable(image);
				
				//換下一張圖
				

				ImageView imageView2 = (ImageView) findViewById( R.id.compareview2);
				String uri2 = "@drawable/letsgo";
				int imageResource2 = getResources().getIdentifier(uri2, null, getPackageName());
				Drawable image2 = getResources().getDrawable(imageResource2);
				imageView2.setImageDrawable(image2);
				
				TextView tv1= (TextView)findViewById(R.id.textView1);
		        tv1.setText("完成進度("+finish+"/10)");
				TextView tv= (TextView)findViewById(R.id.similar);
		        tv.setText("相似度：");
				similarity=0;
				
			}
			else if(finish == 10)
			{
				Toast.makeText(getApplicationContext(), "還不快換禮物，在那邊鬧",
					     Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(getApplicationContext(), "相似度須超過80%，請重新拍照！",
					     Toast.LENGTH_SHORT).show();
			}
		}
	};
	private Button.OnClickListener againcl = new Button.OnClickListener() {
		public void onClick(View v) {
				ImageView imageView1 = (ImageView) findViewById( R.id.compareview2);
				String uri = "@drawable/letsgo";
				int imageResource = getResources().getIdentifier(uri, null, getPackageName());
				Drawable image = getResources().getDrawable(imageResource);
				imageView1.setImageDrawable(image);

				TextView tv= (TextView)findViewById(R.id.similar);
		        tv.setText("相似度：");
				similarity=0;
			
		}
	};
	private Button.OnClickListener changecl = new Button.OnClickListener() {
		public void onClick(View v) {
			if(finish>=10)
			{
				Intent intent = new Intent();
				intent.setClass(compare.this, change.class);
				startActivity(intent);
				finish();
			}
			else
			{
				Toast.makeText(getApplicationContext(), "請完成全部關卡再按",
					     Toast.LENGTH_SHORT).show();
			}
			
		}
	};
	private Button.OnClickListener newcl = new Button.OnClickListener() {
		public void onClick(View v) {
			if(finish == 10)
			{
				Toast.makeText(getApplicationContext(), "還不快換禮物，在那邊鬧",
					     Toast.LENGTH_SHORT).show();
			}
			else
			{
				locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
				Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
				locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,minTime,minDistnace,new MyLocationListener());
				dis=gps2m( Latme, Lngme,Lat[finish],Lng[finish]);
			}
			
	        
		}
	};
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
	    //使用ImageView顯示拍照的影像
		ImageView iv1= (ImageView)findViewById(R.id.compareview1);
	    ImageView iv2= (ImageView)findViewById(R.id.compareview2);
	    if(resultCode == RESULT_OK){
	    	//利用bundle取出拍照後回傳的資料
	    	Bundle extras = data.getExtras();
	    	//將資料轉換為圖像格式
	    	Bitmap bmp = (Bitmap)extras.get("data");
	    	//轉換為圖片指定大小                 
	    	//獲得圖片的寬高                 
	    	int width = bmp.getWidth();                 
	    	int height = bmp.getHeight();                 
	    	// 設置想要的大小                 
	    	int newWidth = 541;                 
	    	int newHeight = 960;                 
	    	// 計算缩放比例                 
	    	float scaleWidth = ((float) newWidth) / width;                 
	    	float scaleHeight = ((float) newHeight) / height;                 
	    	// 取得想要缩放的matrix參數                 
	    	Matrix matrix = new Matrix();                 
	    	matrix.postScale(scaleWidth, scaleHeight);                 
	    	// 得到新的圖片                 
	    	Bitmap newbm = Bitmap.createBitmap(bmp, 0, 0, width, height, matrix,true);                                 
	    	//重新載入 imageView               
	    	iv2.setImageBitmap(newbm);
	    	BitmapUtils bitmaputils = new BitmapUtils();
	    	//imageView轉Bitmap                   
	    	iv1.buildDrawingCache();                   
	    	Bitmap mBitmap1=iv1.getDrawingCache(); 
	    	String gethash1 = bitmaputils.getHash(mBitmap1);
	    	bitmaputils.saveToFile(mBitmap1);
	    	String [] hash1 = gethash1.split("");
	    	
	    	String gethash2 = bitmaputils.getHash(newbm);
	    	bitmaputils.saveToFile(newbm);
	    	String [] hash2 = gethash2.split("");
	    	
	    	String [] length1 = new String [gethash1.length()];
	    	String [] length2 = new String [gethash2.length()];
	    	
	    	for(int g=0 ; g < gethash1.length() ; g++)
	    	{
	    		if(hash1[g].equals(hash2[g]))
	    		{
	    			similarity++;
	    		}
	    	}
	    	similarity=(similarity/gethash1.length())*100;
	    	
	    	
	        TextView tv= (TextView)findViewById(R.id.similar);
	        tv.setText("相似度："+similarity+"%");

	    }
	    //覆蓋原來的Activity
	    super.onActivityResult(requestCode, resultCode, data);
	}
	
	
	private Runnable r0 = new Runnable() {
		public void run() {
			//SeverConnect sc = new SeverConnect();
			//ta = sc.Query("g3", "EVOL", "A,B", "A='2'");
			mH.sendEmptyMessage(0);
			// Log.e("pp", tb.toString());

		}
	};
	
	
	private Handler mH = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:/*
				try {
					for(int i=0;i<ta.length();i++)
					{
						//object=(JSONObject)ta.get(i);
							namestring[i]= ta.getJSONObject(i).get("B").toString();
					}
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				ImageView imageView1 = (ImageView) findViewById( R.id.compareview1);
				String uri = "@drawable/"+namestring[finish];
				
				int imageResource = getResources().getIdentifier(uri, null, getPackageName());
				Drawable image = getResources().getDrawable(imageResource);
				imageView1.setImageDrawable(image);
				
				
				
			
			
			
			}
		}
	};
	
public class MyLocationListener implements LocationListener {
		
		@Override
		public void onLocationChanged(Location location) {
			
			if (traceOfMe == null) {
		    	  traceOfMe = new ArrayList<LatLng>();
		    	}
			
			double latitude = location.getLatitude(); 
			double longitude = location.getLongitude(); 
			LatLng position = new LatLng(latitude, longitude); 
			Latme=latitude;
			Lngme=longitude;
			count = count + 1;
			
			
			traceOfMe.add(position);
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
}
	
	
	private double gps2m(double lat_a, double lng_a, double lat_b, double lng_b) {
		double d2r = Math.PI / 180;
		double distance = 0;

	
		    double dlong = (lng_a - lng_b) * d2r;
		    double dlat = (lat_a -lat_b) * d2r;
		    double a =
		        Math.pow(Math.sin(dlat / 2.0), 2)
		            + Math.cos(lat_b * d2r)
		            * Math.cos(lat_a * d2r)
		            * Math.pow(Math.sin(dlong / 2.0), 2);
		    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		    double d = 6367 * c * 1000 ;
		    if(d>10000)
		    {
		    	TextView tvvv= (TextView)findViewById(R.id.textView2);
		    	tvvv.setText("Please open gps");
		    	return d;
		    }
		    else
		    {
		    	TextView tvvv= (TextView)findViewById(R.id.textView2);
		    	tvvv.setText("距離目標"+String.valueOf(d)+"公尺");
		    	return d;
		    }

	
		}
	
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	} 
}
