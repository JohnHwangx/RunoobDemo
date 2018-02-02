package com.johnh.runoobdemo.No6_Database_Operation;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.johnh.runoobdemo.R;

import java.io.IOException;

public class No6_1_File_Operator extends AppCompatActivity implements View.OnClickListener {

    private EditText editname;
    private EditText editdetail;
    private Button btnsave;
    private Button btnclean;
    private Button btnread;

    private Button btnSdSave;
    private Button btnSdRead;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no6_1_file__operator);

        mContext = getApplicationContext();
        bindViews();


        //Android 6.0 后要在代码中添加读取SD卡权限
        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST_CODE_CONTACT = 101;
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            //验证是否许可权限
            for (String str : permissions) {
                if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    //申请权限
                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                    return;
                }
            }
        }
    }

    private void bindViews() {
        editdetail = findViewById(R.id.editContent);
        editname = findViewById(R.id.editName);
        btnclean = findViewById(R.id.btnClear);
        btnsave = findViewById(R.id.btnSave);
        btnread = findViewById(R.id.btnRead);

        btnSdRead = findViewById(R.id.btnSdSave);
        btnSdSave=findViewById(R.id.btnSdRead);

        btnclean.setOnClickListener(this);
        btnsave.setOnClickListener(this);
        btnread.setOnClickListener(this);
        btnSdSave.setOnClickListener(this);
        btnSdRead.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnClear:
                editname.setText("");
                editdetail.setText("");
                break;
            case R.id.btnSave:
                FileHelper fileHelper = new FileHelper(mContext);
                String filename = editname.getText().toString().trim();
                String fileDetail = editdetail.getText().toString().trim();
                try {
                    fileHelper.save(filename, fileDetail);
                    Toast.makeText(getApplicationContext(), "数据写入成功", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "数据写入失败", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnRead:
                String detail = "";
                FileHelper fHelper2 = new FileHelper(getApplicationContext());
                try {
                    String fName = editname.getText().toString();
                    detail = fHelper2.read(fName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), detail, Toast.LENGTH_SHORT).show();

                break;
            case R.id.btnSdSave:
                FileHelper fileHelper3 = new FileHelper(mContext);
                String filename2 = editname.getText().toString().trim();
                String fileDetail2 = editdetail.getText().toString().trim();
                try {
                    fileHelper3.saveFileToSD(filename2, fileDetail2);
                    Toast.makeText(getApplicationContext(), "数据写入成功", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "数据写入失败", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnSdRead:
                String detail2 = "";
                FileHelper fHelper4 = new FileHelper(getApplicationContext());
                try {
                    String fName = editname.getText().toString();
                    detail2 = fHelper4.readFromSD(fName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), detail2, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
