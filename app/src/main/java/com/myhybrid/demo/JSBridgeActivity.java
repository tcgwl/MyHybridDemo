package com.myhybrid.demo;

import com.myhybrid.demo.jsbridge.InjectedChromeClient;

public class JSBridgeActivity extends BaseActivity {

    @Override
    protected void initData() {
        //JSBridge, 整个过程:
        //(1) 在js脚本中把对应的方法名，参数等写成一个符合协议的uri，并且通过window.prompt方法发送给java层。
        //(2) 在java层的onJsPrompt方法中接受到对应的message之后，通过JsCallJava类进行具体的解析。
        //(3) 在JsCallJava类中，我们解析得到对应的方法名，参数等信息，并且在map中查找出对应的类(JSLogical)的方法。

        webView.setWebChromeClient(new InjectedChromeClient());
        webView.loadUrl("file:///android_asset/interact_jsbridge.html");
    }
}
