package com.myhybrid.demo.jsbridge;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class InjectedChromeClient extends WebChromeClient {
    private final String TAG = "InjectedChromeClient";

    private JsCallJava mJsCallJava;

    public InjectedChromeClient() {
        mJsCallJava = new JsCallJava();
    }

    /**
     * 通过重写WebView中WebChromeClient类的onJsPrompt()方法来进行js和java的通信
     * @param message 约定协议，类似: hybrid://JSBridge:1538351/method?{“message”:”msg”}
     */
    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        result.confirm(mJsCallJava.call(view, message));
        return true;
    }
}