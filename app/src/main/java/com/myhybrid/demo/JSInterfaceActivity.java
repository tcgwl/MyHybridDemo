package com.myhybrid.demo;

import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class JSInterfaceActivity extends BaseActivity {

    @Override
    protected void initData() {
        // 传统的JSInterface
        // Android 4.2之前有漏洞,之后使用@JavascriptInterface这个注解修复
        // 使用Android原生的JavascriptInterface来进行js和java的通信
        webView.addJavascriptInterface(new JsInterface(), "control");
        webView.loadUrl("file:///android_asset/interact.html");
    }

    public class JsInterface {

        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(JSInterfaceActivity.this, toast, Toast.LENGTH_SHORT).show();
            log("show toast success");
        }

        private void log(final String msg){
            webView.post(new Runnable() {
                @Override
                public void run() {
                    //android调用js
                    webView.loadUrl("javascript: log(" + "'" + msg + "'" + ")");
                }
            });
        }
    }
}
