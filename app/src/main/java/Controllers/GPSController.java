package Controllers;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import com.google.android.gms.maps.GoogleMap;

import Constants.GPSConfigurationConstants;
import Handlers.GPSHandler;

/**
 * Created by Guillermo on 02/05/2015.
 */
public class GPSController {

    private LocationManager locationManager;
    private LocationListener locationListener;
    private Context context;

    public GPSController(Context context) {
        this.locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        this.context = context;
        if(this.locationManager == null)
        {
            throw new RuntimeException("Could not get Location Service");
        }
    }

    public void RegisterContinuousLocationUpdate(GoogleMap map)
    {
        Location hardcodeReference = new Location("Point Reference");
        Location firstLocation = new Location("Point 1");
        firstLocation.setLatitude(Double.parseDouble("-34.7448911"));
        firstLocation.setLongitude(Double.parseDouble("-58.7002165"));
        ////TODO Get distance and location from configuration
        GPSHandler listener = new GPSHandler(firstLocation, Float.parseFloat("100"), map);
        this.locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, GPSConfigurationConstants.LOCATION_REFRESHTIME, GPSConfigurationConstants.LOCATION_MINDISTANCE, listener);
        this.locationListener = listener;
    }

    public void UnregisterContinousLocationUpdate()
    {
        if(locationListener != null)
        {
            this.locationManager.removeUpdates(locationListener);
        }
    }

    public void RegisterProximityAlert()
    {

    }

    public Location GetCurrentLocation(){
        if(this.IsGPSEnabled()) {
            return this.locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }
        else if(this.IsNetworkEnabled())
        {
            return this.locationManager.getLastKnownLocation((LocationManager.NETWORK_PROVIDER));
        }
        else
        {
            return null;
        }
    }

    private boolean IsGPSEnabled()
    {
        return this.locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    private boolean IsNetworkEnabled()
    {
        return this.locationManager.isProviderEnabled((LocationManager.NETWORK_PROVIDER));
    }


}
