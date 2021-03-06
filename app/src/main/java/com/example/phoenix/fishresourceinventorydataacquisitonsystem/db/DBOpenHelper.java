package com.example.phoenix.fishresourceinventorydataacquisitonsystem.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    public final static String DB_NAME = "Fish";
    public final static int DB_VERSION = 1;

    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateSQLs.ACCOUNT);
        db.execSQL(CreateSQLs.MONITORING_SITE);
        db.execSQL(CreateSQLs.FRACTURE_SURFACE);
        db.execSQL(CreateSQLs.PHYTOPLANKTON);
        db.execSQL(CreateSQLs.ZOOPLANKTON);
        db.execSQL(CreateSQLs.BENTHOS);
        db.execSQL(CreateSQLs.DOMINANT_PHYTOPLANKTON_SPECIES);
        db.execSQL(CreateSQLs.DOMINANT_ZOOPLANKTON_SPECIES);
        db.execSQL(CreateSQLs.DOMINANT_BENTHOSE_SPECIES);
        db.execSQL(CreateSQLs.SEDIMENT);
        db.execSQL(CreateSQLs.MEASURING_LINE);
        db.execSQL(CreateSQLs.MEASURING_POINT);
        db.execSQL(CreateSQLs.WATER_LAYER);
        db.execSQL(CreateSQLs.CATCHES);
        db.execSQL(CreateSQLs.FISHES);
        db.execSQL(CreateSQLs.FISH_EGGS);
        db.execSQL(CreateSQLs.CATCH_TOOLS);
        db.execSQL(CreateSQLs.WATER_LAYER_CATCH_TOOLS);
//        db.execSQL(CreateSQLs.CREATE_MONITOR_SITE);
//        db.execSQL(CreateSQLs.CREATE_FRACTURE_SURFACE);
//        db.execSQL(CreateSQLs.CREATE_PHYTOPLANKTON);
//        db.execSQL(CreateSQLs.CREATE_ZOOPLANKTON);
//        db.execSQL(CreateSQLs.CREATE_BENTHOS);
//        db.execSQL(CreateSQLs.CREATE_DOMINANT_PHYTOPLANKTON_SPECIES);
//        db.execSQL(CreateSQLs.CREATE_DOMINANT_ZOOPLANKTON_SPECIES);
//        db.execSQL(CreateSQLs.CREATE_DOMINANT_BENTHOS_SPECIES);
//        db.execSQL(CreateSQLs.CREATE_SEDIMENT);
//        db.execSQL(CreateSQLs.CREATE_FRACTURE_SURFACE_SEDIMENT);
//        db.execSQL(CreateSQLs.CREATE_MEASURE_LINE);
//        db.execSQL(CreateSQLs.CREATE_MEASURE_POINT);
//        db.execSQL(CreateSQLs.CREATE_WATER_LAYER);
//        db.execSQL(CreateSQLs.CREATE_CATCHES);
//        db.execSQL(CreateSQLs.CREATE_FISHES);
//        db.execSQL(CreateSQLs.CREATE_FISH_EGGS);
//        db.execSQL(CreateSQLs.CREATE_CATCH_TOOLS);
//        db.execSQL(CreateSQLs.CREATE_WATER_LAYER_CATCH_TOOLS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
