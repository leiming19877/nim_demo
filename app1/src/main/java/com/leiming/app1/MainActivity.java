package com.leiming.app1;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;

import com.netease.nim.uikit.common.activity.UI;
import com.netease.nim.uikit.common.util.storage.StorageUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends UI {

    private static final String TAG = "MainActivity";

    @BindView(R2.id.open_percent)
     Button openPercent;

    @BindView(R2.id.open_webview1)
      Button openWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        /*openPercent = (Button) this.findViewById(R.id.open_percent);
        openPercent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent();
                intent.setClass(MainActivity.this,PercentActivity.class);
                MainActivity.this.startActivityForResult(intent,1);
            }
        });
        openWebView = this.findView(R.id.open_webview1);
        openWebView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    @OnClick(R.id.open_percent)
    public void openPercent(Button bt){
        Intent intent  = new Intent();
        intent.setClass(MainActivity.this,PercentActivity.class);
        //MainActivity.this.startActivityForResult(intent,1);
        this.startActivityForResult(intent,1);
    }

    @OnClick(R.id.open_webview1)
    public void openWebView(Button bt){

    }

    @TargetApi(21)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        StorageUtil.init(this,null);
        Log.v(TAG,"收到信息-vrequestCode:"+requestCode+",resultCode:"+resultCode);
        Log.d(TAG,"收到信息-drequestCode:"+requestCode+",resultCode:"+resultCode);
        Log.w(TAG,"收到信息-wrequestCode:"+requestCode+",resultCode:"+resultCode);
        Log.i(TAG,"收到信息-irequestCode:"+requestCode+",resultCode:"+resultCode);
        Log.e(TAG,"收到信息-erequestCode:"+requestCode+",resultCode:"+resultCode);
        Log.i(TAG, this.getExternalCacheDir().getAbsolutePath());
        Log.i(TAG, this.getCacheDir().getAbsolutePath());
        Log.i(TAG, "cont.getPackageCodePath() = " + this.getPackageCodePath());
        Log.i(TAG, "cont.getPackageResourcePath() = " + this.getPackageResourcePath());
        Log.i(TAG, "path:"+Environment.getExternalStorageDirectory().getPath());
        Log.i(TAG, "image-path:"+StorageUtil.getSystemImagePath());
        Log.i(TAG,"code-path:"+ this.getCodeCacheDir().getAbsolutePath());
        String str[] = StorageUtil.getStoragePaths(this);
        for(String s:str){
            Log.i(TAG, "path:"+s);
        }
        Log.i(TAG,"pod:"+ Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS));
        Log.i(TAG,"data-path:"+ Environment.getDataDirectory().getAbsolutePath());
        Log.i(TAG,"rootPath:"+ Environment.getRootDirectory().getAbsolutePath());
        Log.i(TAG,"dowloadPath:"+ Environment.getDownloadCacheDirectory().getAbsolutePath());
        Log.i(TAG,"db-path:"+    this.getDatabasePath("aa"));
        try {
            //testWriterFile();
            readTestFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void testWriterFile() throws IOException {
        //File pf = this.getCacheDir();
        File pf = this.getExternalCacheDir();
        File file = new File(pf,"leiming.txt");
        Log.i(TAG,file.getAbsolutePath());
        FileOutputStream fo = new FileOutputStream(file);
        OutputStreamWriter ow = new OutputStreamWriter(fo,"utf-8");
        BufferedWriter bw = new BufferedWriter(ow);
        bw.write("leiming-test");
        bw.newLine();
        bw.write("leiming2");
        bw.flush();
        bw.close();
        ow.close();
        fo.close();
    }

    public void readTestFile() throws IOException {
        File pf = this.getCacheDir();
        File file = new File(pf,"leiming.txt");
        Log.i(TAG,file.getAbsolutePath());
        FileInputStream fi = new FileInputStream(file);
        InputStreamReader ir = new InputStreamReader(fi,"utf-8");
        BufferedReader br = new BufferedReader(ir);
        String line = null;
        while ((line = br.readLine()) != null){
            Log.i(TAG,"line:"+line);
        }
        br.close();
        ir.close();
        fi.close();

    }
}
