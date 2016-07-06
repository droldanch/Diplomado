package irolso.com.practica2.Service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import irolso.com.practica2.DetalleActivity;
import irolso.com.practica2.R;

/**
 * Created by Roldan on 06/07/16.
 */
public class Notification extends Service {

    private MyAsyncTask myAsyncTask;
    private int id;

    @Override
    public void onCreate() {

        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent.getExtras()!=null && intent.getExtras().containsKey("key_id"))
        {
            id=intent.getExtras().getInt("key_id");
        }

        if(myAsyncTask==null)
        {
            myAsyncTask= new MyAsyncTask();
            myAsyncTask.execute();
        }

        return START_STICKY;
    }

    private class MyAsyncTask extends AsyncTask<Integer,Integer,Boolean>
    {
        private NotificationCompat.Builder mNotif;

        @Override
        protected void onPreExecute() {

            mNotif = new NotificationCompat
                    .Builder(getApplicationContext())
                    .setContentTitle(getString(R.string.Actualizando))
                    .setContentText(getString(R.string.Actualizando))
                 ;
        }

        @Override
        protected Boolean doInBackground(Integer... params) {
            for (int i=0;i<10;i++)
            {
                publishProgress(i);
                try {
                    Thread.sleep(1000*1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mNotif.setProgress(6,values[0],false);
            NotificationManager manager  = (NotificationManager)
                    getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(id,mNotif.build());
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if(result)
            {
                //elimina progres cuando lo seteamos a 0
                mNotif.setProgress(0,0,false);
                mNotif.setContentTitle(getString(R.string.Actualizando));
                mNotif.setContentText(getString(R.string.ActualizacionCompleta));
                mNotif.setAutoCancel(true);
                PendingIntent pendingIntent =PendingIntent.
                        getActivity(getApplicationContext(),
                                0,new Intent(getApplicationContext(), DetalleActivity.class),PendingIntent.FLAG_UPDATE_CURRENT);
                mNotif.setContentIntent(pendingIntent);

                NotificationManager manager  = (NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(id,mNotif.build());
            }
            myAsyncTask=null;
            stopSelf();
        }
    }

}
