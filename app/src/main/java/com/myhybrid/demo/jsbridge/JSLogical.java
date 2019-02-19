package com.myhybrid.demo.jsbridge;

import android.webkit.WebView;
import android.widget.Toast;

import org.json.JSONObject;

class JSLogical implements IInject {
    /**
     * toast
     *
     * @param webView 浏览器
     * @param param   提示信息
     */
    public static void toast(WebView webView, JSONObject param, final JsCallback callback) {
        String message = param.optString("message");
        int isShowLong = param.optInt("isShowLong");
        Toast.makeText(webView.getContext(), message, isShowLong == 0 ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG).show();
        if (null != callback) {
            try {
                JSONObject object = new JSONObject();
                object.put("result", true);
                invokeJSCallback(callback, object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 加一
     *
     * @param webView 提供可能需要的context, 另外java执行js方法也需要WebView对象
     * @param param js脚本传递过来的参数
     * @param callback 在java中回调js脚本
     */
    public static void plus(WebView webView, final JSONObject param, final JsCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    int original = param.optInt("data");
                    original = original + 1;
                    if (null != callback) {
                        JSONObject object = new JSONObject();
                        object.put("after plussing", original);
                        invokeJSCallback(callback, object);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void invokeJSCallback(JsCallback callback, JSONObject objects) {
        invokeJSCallback(callback, true, null, objects);
    }

    public static void invokeJSCallback(JsCallback callback, boolean isSuccess, String message, JSONObject objects) {
        try {
            callback.apply(isSuccess, message, objects);
        } catch (JsCallback.JsCallbackException e) {
            e.printStackTrace();
        }
    }
}
