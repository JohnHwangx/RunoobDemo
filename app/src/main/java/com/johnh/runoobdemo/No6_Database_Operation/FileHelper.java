package com.johnh.runoobdemo.No6_Database_Operation;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by johnh on 2018/1/24.
 */

public class FileHelper {
    private Context mContext;

    public FileHelper() {

    }

    public FileHelper(Context mContext) {
        super();
        this.mContext = mContext;
    }

    /**
     * 这里定义的是文件保存的方法，写入到文件中，所以是输出流
     *
     * @param fileName
     * @param fileContent
     * @throws Exception
     */
    public void save(String fileName, String fileContent) throws Exception {
        //使用私有模式，创建出来的文件只能被本应用访问，还会覆盖原文件
        FileOutputStream outputStream = mContext.openFileOutput(fileName, Context.MODE_PRIVATE);
        outputStream.write(fileContent.getBytes());//将string字符串以字节流的形式写入到输出流中
        outputStream.close();
    }

    public String read(String fileName) throws IOException {
        FileInputStream inputStream = mContext.openFileInput(fileName);
        byte[] temp = new byte[1024];
        StringBuilder sb = new StringBuilder("");
        int len = 0;
        while ((len = inputStream.read(temp)) > 0) {
            sb.append(new String(temp, 0, len));
        }
        inputStream.close();
        return sb.toString();
    }

    //往SD卡写入文件的方法
    public void saveFileToSD(String fileName, String fileContent) throws Exception {
        //如果手机已插入sd卡,且app具有读写sd卡的权限
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            fileName = Environment.getExternalStorageDirectory().getCanonicalPath() + "/" + fileName;
            //这里就不要用openFileOutput了,那个是往手机内存中写数据的
            FileOutputStream output = new FileOutputStream(fileName);
            output.write(fileContent.getBytes());
            //将String字符串以字节流的形式写入到输出流中
            output.close();
            //关闭输出流
        } else
            Toast.makeText(mContext, "SD卡不存在或者不可读写", Toast.LENGTH_SHORT).show();
    }

    public String readFromSD(String fileName) throws IOException{
        StringBuilder sb = new StringBuilder("");
        //如果手机已插入sd卡,且app具有读写sd卡的权限
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            fileName = Environment.getExternalStorageDirectory().getCanonicalPath() + "/" + fileName;
            //打开文件输入流
            FileInputStream inputStream=new FileInputStream(fileName);
            byte[] temp=new byte[1024];
            int len=0;
            //读取文件内容:
            while ((len=inputStream.read(temp))>0){
                sb.append(new String(temp,0,len));
            }
            inputStream.close();
        }
        return sb.toString();
    }
}
