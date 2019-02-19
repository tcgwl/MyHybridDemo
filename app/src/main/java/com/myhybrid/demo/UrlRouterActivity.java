package com.myhybrid.demo;

import com.myhybrid.demo.urlrouter.NavWebViewClient;

public class UrlRouterActivity extends BaseActivity {

    @Override
    protected void initData() {
        //UrlRouter
        //通过拦截前端写的url，发现如果是符合UrlRouter的协议的话，就跳转到相应的页面
        webView.setWebViewClient(new NavWebViewClient(this));
        webView.loadUrl("file:///android_asset/interact_urlrouter.html");
    }
}
