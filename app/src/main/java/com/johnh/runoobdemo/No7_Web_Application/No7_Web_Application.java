package com.johnh.runoobdemo.No7_Web_Application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.johnh.runoobdemo.MainActivity;
import com.johnh.runoobdemo.R;

public class No7_Web_Application extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no7_web_application);
    }

    public void No7_3_2_FileDownloader1(View view) {
        Intent it=new Intent(No7_Web_Application.this, No7_3_2_FileDownloder.class);
        startActivity(it);
    }
}
