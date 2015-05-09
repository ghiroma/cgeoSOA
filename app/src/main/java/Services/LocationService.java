package Services;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Guillermo on 09/05/2015.
 */
public class LocationService extends IntentService {

    public LocationService()
    {
        super("LocationService");
    }

    protected void onHandleIntent(Intent intent)
    {
        String name ="#";
    }

    public int onStartCommand(Intent intent, int flags, int startId)
    {
        return Service.START_NOT_STICKY;
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }
}
