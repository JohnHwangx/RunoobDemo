package com.johnh.runoobdemo.No4_AppComponents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.johnh.runoobdemo.R;

public class No4_AppComponent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no4_app_component);
    }

    public void No4_4_1_ContentProvider1(View view) {
        Intent it=new Intent(No4_AppComponent.this, No4_4_1_ContentProvider1.class);
        startActivity(it);
    }
}
