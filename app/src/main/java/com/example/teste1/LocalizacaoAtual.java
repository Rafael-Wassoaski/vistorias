package com.example.teste1;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

public class LocalizacaoAtual implements LocationListener {


    private Activity contexto;
    private String locationLat, locationLong;
    private LocationManager manager;

    public LocalizacaoAtual(Activity contexto) {
        this.contexto = contexto;
    }

    public boolean checkPermission() {
        if (ActivityCompat.checkSelfPermission(contexto, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(contexto, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(contexto, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},101);

        }

        return false;
    }

    public String getLocation() {

         manager = (LocationManager) contexto.getSystemService(contexto.LOCATION_SERVICE);
        checkPermission();
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 5, this);

        return locationLat+";"+locationLong;
    }


    @Override
    public void onLocationChanged(Location location) {
        locationLat = String.valueOf(location.getLatitude());
        locationLong = String.valueOf(location.getLongitude());


    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {
        Toast.makeText(contexto, "Por favor, ative sua localização", Toast.LENGTH_LONG).show();
    }
}
