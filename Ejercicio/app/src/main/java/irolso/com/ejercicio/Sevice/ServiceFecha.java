package irolso.com.ejercicio.Sevice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ServiceConfigurationError;

/**
 * Created by Roldan on 26/06/16.
 */
public class ServiceFecha extends Service{
        private final String TAG = "user";
        public static final String BROADCAST_SEND_TIME ="com.unan.SEND_TIME";
        private long seconds;


        private Handler handler = new Handler();
        private Runnable runnable = new Runnable() {
            @Override public void run() {
                seconds++;
                Intent i = new Intent(BROADCAST_SEND_TIME);
                i.putExtra("time",seconds);
                sendBroadcast(i);
                handler.postDelayed(runnable,1000);
            }
        };

        @Nullable @Override public IBinder onBind(Intent intent) {
            return null;
        }

        @Override public void onCreate() {
            super.onCreate();
            handler.postDelayed(runnable,1000);

        }

        @Override public void onDestroy() {
            super.onDestroy();
            handler.removeCallbacks(runnable);
        }

    private void log(String message)
    {
        Log.d(TAG,message);
    }

}

