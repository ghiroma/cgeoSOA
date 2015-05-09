package Controllers;

import android.graphics.Color;
import android.location.Location;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by Guillermo on 09/05/2015.
 */
public class GoogleMapController {

    private GoogleMap map;
    private ArrayList<Marker> markersList;

    public GoogleMapController(GoogleMap map)
    {
        this.map = map;
        this.markersList = new ArrayList<Marker>();
    }

    public void MarkLimits(Location location,Float distance)
    {
        LatLng googleLocation = new LatLng(location.getLatitude(),location.getLongitude());
        this.map.addCircle(new CircleOptions().center(googleLocation).radius(distance).strokeColor(Color.RED).fillColor(Color.GRAY).strokeWidth(Float.parseFloat("4")));
    }

    public void MarkCurrentLocation(Location location)
    {

        LatLng googleLocation = new LatLng(location.getLatitude(), location.getLongitude());
        for(Marker marker: markersList)
        {
            marker.remove();
        }

        Marker marker = this.map.addMarker(new MarkerOptions().position(googleLocation).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        markersList.add(marker);
    }
}
