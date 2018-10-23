package com.example.artist;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		ImageView bfind= (ImageView)findViewById(R.id.find);
		ImageView bexit= (ImageView)findViewById(R.id.exit);
		ImageView bgame= (ImageView)findViewById(R.id.game);
		bfind.setOnClickListener(findcl);
		bgame.setOnClickListener(gamecl);
		bexit.setOnClickListener(exitcl);
		/*final ImageView img=(ImageView)findViewById(R.id.image1);
		img.setBackgroundResource(R.drawable.frame);
		img.post(new Runnable(){
			@Override
			public void run(){
				AnimationDrawable animation=(AnimationDrawable)img.getBackground();
				animation.start();
			}
		});*/
		
	}


	
	private Button.OnClickListener findcl = new Button.OnClickListener() {
		public void onClick(View v) {
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, gps.class);
		startActivity(intent);
		}
	};
	private Button.OnClickListener gamecl = new Button.OnClickListener() {
		public void onClick(View v) {
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, game.class);
		startActivity(intent);
		}
	};
	private Button.OnClickListener exitcl = new Button.OnClickListener() {
		public void onClick(View v) {
			Intent intent=new Intent(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_HOME);

			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			System.exit(0);
		}
	};


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}