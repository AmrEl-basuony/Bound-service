package com.example.mybounder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BoundService myService ;
    boolean isBound=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,BoundService.class);
        bindService(intent,myConnection, Context.BIND_AUTO_CREATE);
        Log.i("key","onCreate ");
    }

    public void showTime(View view){
        String currentTime=myService.getCurrentTime();
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText(currentTime);
        Log.i("key","showTime");
    }

    private ServiceConnection myConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i("key","onServiceConnected");
            BoundService.MyLocalBinder binder = (BoundService.MyLocalBinder) iBinder;
            myService = binder.getService();
            isBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i("key","onServiceDisconnected");
            isBound=false;
        }

    };

}