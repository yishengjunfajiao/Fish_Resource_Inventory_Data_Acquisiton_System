package com.example.phoenix.fishresourceinventorydataacquisitonsystem.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.DBOpenHelper;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Benthos;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.exceptions.IncompleteFieldException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phoenix on 2016/6/21.
 */
public class DbDao {

    private Context context = null;

    public DbDao(Context context) {
        this.context = context;
    }

    public List<BaseNode> findMonitorSites() {
        DBOpenHelper helper = new DBOpenHelper(context);
        return null;
    }

}
