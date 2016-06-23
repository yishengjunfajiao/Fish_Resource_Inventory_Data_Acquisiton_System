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
public class SQLiteDao {
    /**
     * 通过 FractureSurface(断面) 外键来查找 Benthos(底栖生物)
     *
     * @param ID_FractureSurface
     */
    public List<BaseNode> findBenthosBySurface(Context context, String ID_FractureSurface) {
        SQLiteDatabase db = new DBOpenHelper(context).getReadableDatabase();
        String sql = "select * from " + TableNames.BENTHOS + " where ID_FractureSurface = ?";
        String[] selectionArgs = new String[]{"ID_FractureSurface"};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        //将数据结果组装成JavaBean
        cursor.moveToFirst();
        List<BaseNode> list = new ArrayList<BaseNode>();
        Benthos benthos = null;
        while (!cursor.isAfterLast()) {
            /*
            benthos = new Benthos();
            benthos.sampleID(cursor.getString(0));
            builder.photo(cursor.getString(1));
            builder.quality(cursor.getInt(2));
            builder.biomass(cursor.getInt(3));
            builder.id_fractureSurface(cursor.getString(4));
            try {
                list.add(builder.build());
            } catch (IncompleteFieldException e) {
                System.out.println(e.getMessage());
                return null;
            }
            cursor.moveToNext();
            */
        }
        return list;
    }
}
