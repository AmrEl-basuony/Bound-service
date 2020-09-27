package com.example.mybounder;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BoundService extends Service {

    IBinder myBinder = new MyLocalBinder();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.i("key","onBind");
        return myBinder;
    }

    public String getCurrentTime(){
        SimpleDateFormat dateFormat= new SimpleDateFormat("HH:MM:SS", Locale.US);
        Log.i("key","getCurrentTime");
        return dateFormat.format(new Date());
    }

    public class MyLocalBinder extends Binder{
        BoundService getService(){
            Log.i("key","getService");
            return BoundService.this;
        }

    }
}
