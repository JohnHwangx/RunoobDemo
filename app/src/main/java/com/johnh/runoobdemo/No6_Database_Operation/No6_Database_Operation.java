package com.johnh.runoobdemo.No6_Database_Operation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.johnh.runoobdemo.R;

public class No6_Database_Operation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no6__database__operation);
    }

    public void No6_1_FileOperator(View view) {
        Intent it=new Intent(No6_Database_Operation.this,No6_1_File_Operator.class);
        startActivity(it);
    }
}
