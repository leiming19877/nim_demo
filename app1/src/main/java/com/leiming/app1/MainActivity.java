package com.leiming.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.netease.nim.uikit.common.activity.UI;

public class MainActivity extends UI {

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
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
