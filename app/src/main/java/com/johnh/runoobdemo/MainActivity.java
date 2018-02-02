package com.johnh.runoobdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.johnh.runoobdemo.No6_Database_Operation.No6_Database_Operation;
import com.johnh.runoobdemo.No7_Web_Application.No7_Web_Application;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void No6_DatabaseOperator(View view) {
        Intent it=new Intent(MainActivity.this, No6_Database_Operation.class);
        startActivity(it);
    }

    public void No7_WebApplication(View view) {
        Intent it=new Intent(MainActivity.this, No7_Web_Application.class);
        startActivity(it);
    }
}
