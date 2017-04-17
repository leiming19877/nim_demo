package com.leiming.app1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.netease.nim.uikit.common.activity.UI;
import com.netease.nim.uikit.common.util.storage.StorageUtil;

public class MainActivity extends UI {

    private static final String TAG = "MainActivity";

    private Button openPercent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openPercent = (Button) this.findViewById(R.id.open_percent);
        openPercent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent();
                intent.setClass(MainActivity.this,PercentActivity.class);
                MainActivity.this.startActivityForResult(intent,1);
            }
        });
    }

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
        Log.i(TAG, this.getExternalCacheDir().getAbsolutePath());
        Log.i(TAG, this.getCacheDir().getAbsolutePath());
        Log.i(TAG, "cont.getPackageCodePath() = " + this.getPackageCodePath());
        Log.i(TAG, "cont.getPackageResourcePath() = " + this.getPackageResourcePath());
        Log.i(TAG, "path:"+Environment.getExternalStorageDirectory().getPath());
        Log.i(TAG, "image-path:"+StorageUtil.getSystemImagePath());
        Log.i(TAG, "fisrt-sd-path:"+StorageUtil.getFirstSDCardPath());

    }
}
