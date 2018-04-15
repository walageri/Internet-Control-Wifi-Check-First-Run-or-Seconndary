package com.blogspot.programer27android.internetcheck;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class ConnectCheck extends AppCompatActivity {
    Context c;
    //conection
    public void enableinternet(){
        WifiManager wifis= (WifiManager) getApplicationContext().getSystemService(c.WIFI_SERVICE);
        wifis.setWifiEnabled(true);
    }
    public boolean connectionChek() {
        ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nI = cm.getActiveNetworkInfo();
        if (nI != null && nI.isConnectedOrConnecting()) {
            android.net.NetworkInfo netWifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo netMobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (netMobile != null && !netMobile.isConnectedOrConnecting() || (netWifi != null && !netMobile.isConnectedOrConnecting()))
                return true;
            else return false;
        } else
            return false;
    }
    public void Buildert() {
        AlertDialog.Builder b=new AlertDialog.Builder(c);
        b.setTitle("Connention");
        b.setMessage("Aplikasi syari membutuhkan koneksi internet \nKlik Ok untuk menyalakan wifi atau jaringan data");
        b.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                enableinternet();
            }
        });
        b.show();
    }
    public void internet(){
        if (!connectionChek()){Buildert();} else{}
    }

}
