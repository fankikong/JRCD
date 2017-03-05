package com.example.jose.layouts;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.eddystone.Eddystone;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by Dani on 04/03/2017.
 */

public class Aplicacion extends Application {

    private BeaconManager beaconManager;

    @Override
    public void onCreate() {
        super.onCreate();

        beaconManager = new BeaconManager(getApplicationContext());
        beaconManager.setEddystoneListener(new BeaconManager.EddystoneListener() {
            @Override
            public void onEddystonesFound(List<Eddystone> list) {
                for (Eddystone eddystone : list) {
                    if (eddystone.isUid() && eddystone.namespace.equals("beac011211abcdef1234")) {
                        try {
                            URL url = new URL("https://nullhackathon.eu-gb.mybluemix.net/beacons/id/" + eddystone.instance);
                            if(BeaconData.beaconId != null && BeaconData.beaconId.equals(eddystone.instance) && BeaconData.serverResponse != null) return;
                            BeaconData.beaconId = eddystone.instance;
                            new LoadUrl().execute(url);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startEddystoneScanning();
            }
        });
        beaconManager.setMonitoringListener(new BeaconManager.MonitoringListener() {
            @Override
            public void onEnteredRegion(Region region, List<Beacon> list) {
                showNotification(
                        "Your gate closes in 47 minutes.",
                        "Current security wait time is 15 minutes, "
                                + "and it's a 5 minute walk from security to the gate. "
                                + "Looks like you've got plenty of time!");
            }

            @Override
            public void onExitedRegion(Region region) {
                // could add an "exit" notification too if you want (-:
            }
        });
    }

    public void showNotification(String title, String message) {
        Intent notifyIntent = new Intent(this, Principal.class);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivities(this, 0,
                new Intent[]{notifyIntent}, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();
        notification.defaults |= Notification.DEFAULT_SOUND;
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

    class LoadUrl extends AsyncTask<URL, Void, String> {
        @Override
        protected String doInBackground(URL... urls) {
            System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
            if (urls.length != 1) return null;
            URL url = urls[0];
            System.out.println("Cargando url " + url);
            try {
                URLConnection con = url.openConnection();
                System.out.println("conexion abierta");
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                System.out.println("leyendo");
                while ((inputLine = in.readLine()) != null)
                    response.append(inputLine);
                in.close();
                return response.toString();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if(result == null) return;
            System.out.println("Terminado " + result);
            try {
                JSONArray array = new JSONArray(result);
                if(array != null && array.length() > 0) {
                    int[] serverResponse = new int[array.length()];
                    for(int i = 0; i < array.length(); i++) {
                        serverResponse[i] = array.optInt(i);
                    }
                    BeaconData.serverResponse = serverResponse;
                    Context context = Aplicacion.this.getApplicationContext();
                    System.out.println("lanzando activity");
                    Intent intent = new Intent().setClass(context, Principal.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else {
                    BeaconData.beaconId = null;
                    BeaconData.serverResponse = null;
                }
            } catch (JSONException e) {
            }
            System.out.println("response from server: " + result);
        }
    }
}
