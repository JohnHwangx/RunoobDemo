package com.johnh.runoobdemo.No7_Web_Application;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.johnh.runoobdemo.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class No7_3_2_FileDownloder extends AppCompatActivity {
    private EditText editPath;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no7_3_2_file_downloder);

        editPath = findViewById(R.id.editPath);
        context = getApplicationContext();
    }


    public void SingleThreadDownload(View view) {
        new Thread() {
            @Override
            public void run() {
                try {
                    String path = editPath.getText().toString().trim();
                    URL url = new URL(path);
                    InputStream is = url.openStream();
                    //截取最后的文件名
                    String end = path.substring(path.lastIndexOf("."));
                    //打开手机对应的输出流,输出到文件中
                    OutputStream os = context.openFileOutput("Cache_" + System.currentTimeMillis() + end, Context.MODE_PRIVATE);
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    //从输入流中读取数据,读到缓冲区中
                    while ((len = is.read(buffer)) > 0) {
                        os.write(buffer, 0, len);
                    }
                    //关闭输入输出流
                    is.close();
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
