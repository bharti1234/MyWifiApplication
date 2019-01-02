package com.example.bharti.mywifiapplication;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.aware.WifiAwareManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.hardware.Camera;


import static java.nio.file.Paths.get;

public class MainActivity extends Activity {

    WifiManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);

    }

    public void enable(View view) {
        if(manager.isWifiEnabled())
        {
            Toast.makeText(this,"Wifi Service is already running!",Toast.LENGTH_LONG).show();
        }
        else if(!manager.isWifiEnabled())
        {
            manager.setWifiEnabled(true); //to start wifi
            Toast.makeText(this,"Wifi is started now!",Toast.LENGTH_LONG).show();
        }
        else  //else if(manager==null)
        {
            Toast.makeText(this,"Sorry! No, Wifi device in your system is detected!",Toast.LENGTH_LONG).show();
        }


    }

    public void disable(View view) {
        if(manager.isWifiEnabled())
        {
            Toast.makeText(this,"Ok, Going to stop Wifi service...",Toast.LENGTH_LONG).show();
            manager.setWifiEnabled(false); //To stop Wifi
        }
        else if(!manager.isWifiEnabled())
        {
            Toast.makeText(this,"Wifi is already stopped!",Toast.LENGTH_LONG).show();
        }
    }

}

