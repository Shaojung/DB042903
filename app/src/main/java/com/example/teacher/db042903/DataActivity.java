package com.example.teacher.db042903;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        TextView tv = (TextView) findViewById(R.id.textView);
        String data = getIntent().getStringExtra("data");
        tv.setText(data);
    }
}
