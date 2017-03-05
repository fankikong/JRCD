package com.example.jose.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WaitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);
        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(BeaconData.serverResponse == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        inte
                    }
                });
            }
        })*/
    }
}
