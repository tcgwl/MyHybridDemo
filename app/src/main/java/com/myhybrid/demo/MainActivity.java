package com.myhybrid.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void useJSInterface(View view) {
        startWebActivity(JSInterfaceActivity.class);
    }

    public void useJSBridge(View view) {
        startWebActivity(JSBridgeActivity.class);
    }

    public void useUrlRouter(View view) {
        startWebActivity(UrlRouterActivity.class);
    }

    private void startWebActivity(Class activityClass) {
        startActivity(new Intent(MainActivity.this, activityClass));
    }
}
