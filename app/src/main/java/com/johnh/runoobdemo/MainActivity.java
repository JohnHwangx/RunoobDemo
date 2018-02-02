package com.johnh.runoobdemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.johnh.runoobdemo.No4_AppComponents.No4_AppComponent;
import com.johnh.runoobdemo.No6_Database_Operation.No6_Database_Operation;
import com.johnh.runoobdemo.No7_Web_Application.No7_Web_Application;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Android 6.0 后要在代码中添加读取SD卡权限
        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST_CODE_CONTACT = 101;
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_SMS};
            //验证是否许可权限
            for (String str : permissions) {
                if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    //申请权限
                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                    //ActivityCompat.requestPermissions(MainActivity.this,permissions,REQUEST_CODE_CONTACT);
                    return;
                }
            }
        }
    }

    public void No6_DatabaseOperator(View view) {
        Intent it=new Intent(MainActivity.this, No6_Database_Operation.class);
        startActivity(it);
    }

    public void No7_WebApplication(View view) {
        Intent it=new Intent(MainActivity.this, No7_Web_Application.class);
        startActivity(it);
    }

    public void No4_AppComponent(View view) {
        Intent it=new Intent(MainActivity.this, No4_AppComponent.class);
        startActivity(it);
    }
}
