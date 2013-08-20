package com.example.delta;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class ProfileActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

	public void launchURL(View view) {
		Log.d("status", "launchURL event fired.");
		Intent intent = null;
		
		switch (view.getId()) {
	    	case R.id.button_calc:
	    		intent = new Intent(this, ViewURL.class);
	    		//intent.putExtra("whichURL", "http://www.youtube.com/watch?v=riXcZT2ICjA&list=PL987ABEB108DC4EB0&index=1");
	    		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=riXcZT2ICjA&list=PL987ABEB108DC4EB0&index=1")));
	    		break;
	    	case R.id.button_chem:
	    		intent = new Intent(this, ViewURL.class);
	    		intent.putExtra("whichURL", "http://www.yahoo.com"); 
	    		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nature.com/chemistry/podcast/mp3/chemistry-2009-12-21.mp3")));
	    		break;
	    	case R.id.button_phys:
	    		intent = new Intent(this, ViewURL.class);
	    		intent.putExtra("whichURL", "http://www.excite.com");
	    		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://ocw.mit.edu/resources/res-6-004-principles-of-computer-system-design-an-introduction-spring-2009/online-textbook/principles_open_5_0.pdf")));
	    		break;
	    	case R.id.button_contact:
	    		startActivity(new Intent(this, ContactInfo.class));
	    		break;
	    	default:
	    		intent = null;
	    		break;
		}
		
	}
}
