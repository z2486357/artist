package com.example.artist;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class game extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.game);
		ImageView bstart= (ImageView)findViewById(R.id.start1);
		ImageView bleave= (ImageView)findViewById(R.id.leave1);
		
		bstart.setOnClickListener(startcl);
		bleave.setOnClickListener(leavecl);
	}
	private Button.OnClickListener startcl = new Button.OnClickListener() {
		public void onClick(View v) {
		Intent intent = new Intent();
		intent.setClass(game.this, compare.class);
		startActivity(intent);
		finish();
		}
	};
	private Button.OnClickListener leavecl = new Button.OnClickListener() {
		public void onClick(View v) {
		Intent intent = new Intent();
		intent.setClass(game.this, MainActivity.class);
		startActivity(intent);
		finish();
		}
	};


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
