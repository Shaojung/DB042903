package com.example.teacher.db042903;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

public class MyService extends Service {
    Handler handler = new Handler();
    int i;
    public MyService() {
        i = 0;
    }

    Runnable showTime = new Runnable() {
        @Override
        public void run() {
            Log.d("SER", "Time:" + new java.util.Date());
            i++;
            if (i <= 2)
            {
                handler.postDelayed(this, 1000);
            }
            else
            {
                Context context;
                context = getApplicationContext();
                NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context.getApplicationContext());
                builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("10 sec")
                        .setContentText("十秒鐘到了");
                Notification notification = builder.build();
                manager.notify(3122, notification);

            }

        }
    };


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // throw new UnsupportedOperationException("Not yet implemented");
        Log.d("SER", "onBind");

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("SER", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("SER", "on Start Command");
        handler.post(showTime);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(showTime);
    }
}
