package com.example.teacher.db042903;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MyService extends Service {
    Handler handler = new Handler();

    public MyService() {
    }

    Runnable showTime = new Runnable() {
        @Override
        public void run() {
            Log.d("SER", "Time:" + new java.util.Date());
            handler.postDelayed(this, 1000);
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
}
