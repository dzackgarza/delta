package com.example.delta;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SubjectsMain extends Activity implements OnSharedPreferenceChangeListener {
	SharedPreferences prefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
			Log.d("status", "App Started Successfully."); //// adb logcat -s "TAGNAME"
		super.onCreate(savedInstanceState);
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
    	prefs.registerOnSharedPreferenceChangeListener(this);
		setContentView(R.layout.activity_main2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onSharedPreferenceChanged(SharedPreferences arg0, String arg1) {
		// For now, doesn't need to do anything. 
	}

	public void launchTutors(View view) {
		startActivity(new Intent(SubjectsMain.this, MainActivity.class));
			Log.d("status", "Intent successfully created.");
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
