package com.example.artist;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class change extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.change);
		ImageView bok= (ImageView)findViewById(R.id.imageView2);
		bok.setOnClickListener(okcl);
		
	}
	private Button.OnClickListener okcl = new Button.OnClickListener() {
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
