package com.example.phoenix.fishresourceinventorydataacquisitonsystem;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Phoenix on 2016/6/1.
 */
public class FishApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
