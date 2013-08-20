package com.example.delta;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity implements OnSharedPreferenceChangeListener {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_main);
    	super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void launchKhan(View view) {
		startActivity(new Intent(this, ProfileActivity.class));
			Log.d("status", "Intent successfully created.");
	}

	public void onSharedPreferenceChanged(SharedPreferences arg0, String arg1) {
		// For now, doesn't need to do anything. 
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.personalInfo:
			startActivity(new Intent(this, PrefsActivity.class));
			break;
		case R.id.addContent:
			startActivity(new Intent(this, PersonalInfoActivity.class));
			break;
		}
		return true;
	}
	

}
