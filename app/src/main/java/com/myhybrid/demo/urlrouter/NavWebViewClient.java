package com.myhybrid.demo.urlrouter;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NavWebViewClient extends WebViewClient {

    private Context context;

    public NavWebViewClient(Context context){
        this.context = context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(Nav.from(context).toUri(url)) {
            return true;
        }

        view.loadUrl(url);
        return true;
    }
}