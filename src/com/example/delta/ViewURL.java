package com.example.delta;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebView;

public class ViewURL extends Activity {
	private WebView myWebView = null;
	
	public String extractURL() {
		Intent callingIntent = getIntent();
		String URL = callingIntent.getStringExtra("whichURL");
		return URL;
	}
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_url);
		
		// Show the Up button in the action bar.
		setupActionBar();
		
		myWebView = (WebView) findViewById(R.id.webView1);
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.getSettings().setPluginsEnabled(true);

		myWebView.loadUrl(extractURL());
		myWebView.setWebViewClient(new MyWebViewClient(this));
		
		// For loading custom HTML:
		// webView.loadData(customHtml, "text/html", "UTF-8");
	}
	
	/*
	 * Browser's "Back" Functionality.
	 * Intercepts key presses - does a custom action if it is the "back" key, otherwise passes it to super()
	 * 
	 * @see android.app.Activity#onKeyDown(int, android.view.KeyEvent)
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    // Check if the key event was the Back button and if there's history
	    if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
	    	myWebView.goBack();
	        return true;
	    }
	    // Otherwise, bubble up to the default system behavior (usually to exit the activity)
	    return super.onKeyDown(keyCode, event);
	}
	
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 * (Only available in Honeycomb or higher)
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	// Inflate the menu; this adds items to the action bar if it is present.
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}



