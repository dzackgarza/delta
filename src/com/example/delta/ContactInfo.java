package com.example.delta;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class ContactInfo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_info);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_info, menu);
		return true;
	}
	
	public void placeCall(View view) {
		Log.d("status", "Click event fired.");
		String phone = "tel:5555551212";
		startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(phone)));
	}
	
	public void sendMail(View view) {
		final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"dzackgarza@gmail.com"});
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Tutoring <subject>");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");
		startActivity(Intent.createChooser(emailIntent, "Send mail..."));
	}

}
