package Handlers;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Guillermo on 02/05/2015.
 */
public class GPSHandler implements LocationListener {

    @Override
    public void onLocationChanged(Location location) {
        Log.i("GPSHandler - onLocationChanged","Latitude: "+ String.valueOf(location.getLatitude()) + " Longitude: " + String.valueOf(location.getLongitude()));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
