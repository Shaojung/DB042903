package com.example.teacher.db042903;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        it = new Intent(MainActivity.this, MyService.class);
    }

    public void click1(View v)
    {
        startService(it);
    }
    public void click2(View v)
    {
        stopService(it);
    }
}
