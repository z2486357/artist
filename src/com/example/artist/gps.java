package com.example.artist;

import java.util.ArrayList;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;


import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;




public class gps extends Activity {

	
	static final LatLng taigi = new LatLng(24.78759147,120.98853656);
	static final LatLng nsound = new LatLng(24.79052442,120.99057319);
	static final LatLng chess = new LatLng(24.78696986,120.99031463);
	static final LatLng bigstone = new LatLng(24.79489828,120.99097861);
	static final LatLng domin = new LatLng(24.79100813,120.99362627);
	static final LatLng oldlibr = new LatLng(24.79406479,120.99348378);
	static final LatLng oldlibrmirr = new LatLng(24.79458361,120.99352339);
	static final LatLng nthumirror = new LatLng(24.79466844,120.9938991);
	static final LatLng bigroom = new LatLng(24.79365717,120.99403129);
	static final LatLng lake = new LatLng(24.79319604,120.99442018);
	static final LatLng lakemiddle = new LatLng(24.79356183,120.9950816);
	static final LatLng bird = new LatLng(24.79398122,120.99441907);
	static final LatLng artcenter = new LatLng(24.79449891,120.99361676);
	static final LatLng hotel = new LatLng(24.79798043,120.99105068);
	static final LatLng park = new LatLng(24.79631801,120.99443313);
	static final LatLng sunroad = new LatLng(24.79579901,120.99353764);
	static final LatLng think = new LatLng(24.79524178,120.99423888); 
	static final LatLng clock = new LatLng(24.79599367,120.99543311);
	static final LatLng ieem = new LatLng(24.79524467,120.99604663);
	static final LatLng door = new LatLng(24.79664965,120.99681864);

	int num=0;
	String choose="dfkjhsdfklh";
	private static final long minDistnace = 5;
    private static final long minTime = 5000;
    protected LocationManager locationManager;
	private GoogleMap map;
	private ArrayList<LatLng> traceOfMe;
	private static long count = 0;
	private Marker user;
	private boolean a =false;
	double Latme;
	double Lngme;
	double dis=0;
	private final double EARTH_RADIUS = 6378137.0;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gps);
		
		ImageView bmap= (ImageView)findViewById(R.id.map);
		bmap.setOnClickListener(mapcl);
		
		map = ((MapFragment)getFragmentManager().findFragmentById(R.id.fragment1)).getMap();
		Marker mtaigi = map.addMarker(new MarkerOptions().position(taigi).title("台積館").snippet(""));
		Marker mnsound = map.addMarker(new MarkerOptions().position(nsound).title("無聲的對話").snippet(""));
		Marker mchess = map.addMarker(new MarkerOptions().position(chess).title("奕園").snippet(""));
		Marker mbigstone = map.addMarker(new MarkerOptions().position(bigstone).title("昇華").snippet(""));
		Marker mdomin = map.addMarker(new MarkerOptions().position(domin).title("清齋前面").snippet(""));
		Marker moldlibr = map.addMarker(new MarkerOptions().position(oldlibr).title("痕").snippet(""));
		Marker moldlibrmirr = map.addMarker(new MarkerOptions().position(oldlibrmirr).title("清鏡").snippet(""));
		Marker mnthumirror = map.addMarker(new MarkerOptions().position(nthumirror).title("清華園").snippet(""));
		//Marker mbigroom = map.addMarker(new MarkerOptions().position(bigroom).title("大禮堂").snippet(""));
		Marker mlake = map.addMarker(new MarkerOptions().position(lake).title("湖畔").snippet(""));
		Marker mlakemiddle = map.addMarker(new MarkerOptions().position(lakemiddle).title("湖心亭").snippet(""));
		Marker mbird = map.addMarker(new MarkerOptions().position(bird).title("鳳凰").snippet(""));
		Marker martcenter = map.addMarker(new MarkerOptions().position(artcenter).title("藝術中心").snippet(""));
		Marker mhotel = map.addMarker(new MarkerOptions().position(hotel).title("候鳥蜂巢").snippet(""));
		Marker mpark = map.addMarker(new MarkerOptions().position(park).title("雕塑公園").snippet(""));
		Marker msunroad = map.addMarker(new MarkerOptions().position(sunroad).title("陽光走廊").snippet(""));
		Marker mthink = map.addMarker(new MarkerOptions().position(think).title("沉思者").snippet(""));
		Marker mclock = map.addMarker(new MarkerOptions().position(clock).title("日晷").snippet(""));
		Marker mieem = map.addMarker(new MarkerOptions().position(ieem).title("過程").snippet(""));
		Marker mdoor = map.addMarker(new MarkerOptions().position(door).title("簡冊立柱").snippet(""));
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(think, 16));
		MyMarkerListener myMarkerListener=new MyMarkerListener();
		map.setOnInfoWindowClickListener(myMarkerListener);
		

		

		
		

	}


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
			if(a==true){
			user.remove();
			user=map.addMarker(new MarkerOptions().position(position).title("位置"+count+"("+latitude+","+longitude+")").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
			 //map.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 16));
		    //map.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 16));
			}
			else{
			a=true;
			user=map.addMarker(new MarkerOptions().position(position).title("位置"+count+"("+latitude+","+longitude+")").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
		
		    
		    
		    map.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 16));
			}
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
	
	
	
	
	
	private Button.OnClickListener mapcl = new Button.OnClickListener() {
		public void onClick(View v) {
			locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
			Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,minTime,minDistnace,new MyLocationListener());
		
			/*dis=gps2m( Latme, Lngme, 24.79664965,120.99681864);
			TextView tvvv= (TextView)findViewById(R.id.textView1);
			//String distance=dis.toString();
	        tvvv.setText(String.valueOf(Latme));*/
		
		
		}
	};

	/*private double gps2m(double lat_a, double lng_a, double lat_b, double lng_b) {
		double radLat1 = (lat_a * Math.PI / 180.0);
		double radLat2 = (lat_b * Math.PI / 180.0);
		double a = radLat1 - radLat2;
		double b = (lng_a - lng_b) * Math.PI / 180.0;
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
		+ Math.cos(radLat1) * Math.cos(radLat2)
		* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
		}*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private class MyMarkerListener implements OnInfoWindowClickListener{
		@Override
		public void onInfoWindowClick(Marker marker) {
			// TODO Auto-generated method stub
			//Toast.makeText(getBaseContext(), marker.getTitle(),Toast.LENGTH_SHORT).show();
			if(marker.getTitle().equals("台積館"))
			{
				choose="0";
			}
			if(marker.getTitle().equals("無聲的對話"))
			{
				choose="1";
			}
			if(marker.getTitle().equals("奕園"))
			{
				choose="2";
			}
			if(marker.getTitle().equals("昇華"))
			{
				choose="3";
			}
			if(marker.getTitle().equals("清齋前面"))
			{
				choose="4";
			}
			if(marker.getTitle().equals("痕"))
			{
				choose="5";
			}
			if(marker.getTitle().equals("清鏡"))
			{
				choose="6";
			}
			if(marker.getTitle().equals("清華園"))
			{
				choose="7";
			}
			if(marker.getTitle().equals("大禮堂"))
			{
				choose="8";
			}
			if(marker.getTitle().equals("湖畔"))
			{
				choose="9";
			}
			if(marker.getTitle().equals("湖心亭"))
			{
				choose="10";
			}
			if(marker.getTitle().equals("鳳凰"))
			{
				choose="11";
			}
			if(marker.getTitle().equals("藝術中心"))
			{
				choose="12";
			}
			if(marker.getTitle().equals("候鳥蜂巢"))
			{
				choose="13";
			}
			if(marker.getTitle().equals("雕塑公園"))
			{
				choose="14";
			}
			if(marker.getTitle().equals("陽光走廊"))
			{
				choose="15";
			}
			if(marker.getTitle().equals("沉思者"))
			{
				choose="16";
			}
			if(marker.getTitle().equals("日晷"))
			{
				choose="17";
			}
			if(marker.getTitle().equals("過程"))
			{
				choose="18";
			}
			if(marker.getTitle().equals("簡冊立柱"))
			{
				choose="19";
			}
			Intent intent = new Intent("com.example.artist.information");
			intent.putExtra("message", choose);
			intent.setClass(gps.this, information.class);
			startActivityForResult(intent,2);
			finish();
			}
		}
	}