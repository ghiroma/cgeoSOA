package Handlers;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;

import Controllers.GoogleMapController;

/**
 * Created by Guillermo on 02/05/2015.
 */
public class GPSHandler implements LocationListener {

    Location referencePoint;
    Float availableDistance;
    GoogleMapController googleMapController;

    public GPSHandler(Location referencePoint, Float distance, GoogleMap map)
    {
        this.referencePoint = referencePoint;
        this.availableDistance = distance;
        this.googleMapController = new GoogleMapController(map);
    }

    @Override
    public void onLocationChanged(Location location) {
        this.googleMapController.MarkCurrentLocation(location);
        Log.i("GPSHandler - onLocationChanged","Latitude: "+ String.valueOf(location.getLatitude()) + " Longitude: " + String.valueOf(location.getLongitude()));
        if(location.distanceTo(this.referencePoint)>availableDistance)
        {
            Log.i("GPSHandler - onLocationChanged","Distance passed");
            ////TODO Send email or sms
        }
        else
        {
            Log.i("GPHandler - onLocationChanged", "Distance NOT passed");
        }
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
