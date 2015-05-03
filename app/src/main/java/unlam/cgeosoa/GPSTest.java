package unlam.cgeosoa;

import android.location.Location;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import Controllers.GPSController;


public class GPSTest extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpstest);
        EditText txtLatitud = (EditText)findViewById((R.id.txtLatitud));
        EditText txtLongitud = (EditText)findViewById(R.id.txtLongitud);
        GPSController gpsController = new GPSController(getApplicationContext());
        Location currentLocation = gpsController.GetCurrentLocation();
        Double latitude = currentLocation.getLatitude();
        Double longitude = currentLocation.getLongitude();
        txtLatitud.setText(String.valueOf(latitude));
        txtLongitud.setText(String.valueOf(longitude));

        gpsController.RegisterContinuousLocationUpdate();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gpstest, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
