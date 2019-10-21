package com.zhou.gradlestudy1021;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvCurTheme = findViewById(R.id.curTheme);
        TextView tvCurChannel = findViewById(R.id.curChannel);

        getMetaData();

        tvCurTheme.setText(theme);
        tvCurChannel.setText(channel);

    }

    String channel;
    String theme;


    /**
     * 从manifest中读取出metadata
     */
    private void getMetaData() {
        PackageManager pm = getPackageManager();
        try {
            ApplicationInfo appInfo = pm.getApplicationInfo(BuildConfig.APPLICATION_ID, PackageManager.GET_META_DATA);
            Bundle bd = appInfo.metaData;
            channel = bd.getString("CHANNEL");
            theme = bd.getString("THEME");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
