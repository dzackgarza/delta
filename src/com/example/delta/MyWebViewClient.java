package com.example.delta;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient 
{
	private Context context;
	
	public MyWebViewClient(Context context) {
		this.context = context;
	}
	
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.endsWith(".mp3")) 
        {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse(url), "audio/*");
            view.getContext().startActivity(intent);   
            return true;
        } 
        else if (url.endsWith(".mp4")) 
        {
            Intent intent = new Intent(Intent.ACTION_VIEW); 
            intent.setDataAndType(Uri.parse(url), "video/*");
            view.getContext().startActivity(intent);   
            return true;
        } 
        else 
        {
            return super.shouldOverrideUrlLoading(view, url);
        }
     }
}