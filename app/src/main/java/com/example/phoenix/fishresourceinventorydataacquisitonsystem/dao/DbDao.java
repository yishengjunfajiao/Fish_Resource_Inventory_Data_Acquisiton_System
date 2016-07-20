package com.example.phoenix.fishresourceinventorydataacquisitonsystem.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.DBOpenHelper;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Benthos;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.FractureSurface;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MeasuringLine;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MeasuringPoint;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MonitoringSite;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Phytoplankton;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Sediment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.WaterLayer;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Zooplankton;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.exceptions.IncompleteFieldException;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phoenix on 2016/6/21.
 */
public class DbDao {

    private Context context = null;
    private DBOpenHelper helper = null;

    public DbDao(Context context) {
        this.context = context;
        this.helper = new DBOpenHelper(context);
    }

    public static DbDao getInstance(Context context) {
        return new DbDao(context);
    }

    public List<BaseNode> findMonitorSites() {
        SQLiteDatabase db = helper.getReadableDatabase();
        if (db.isOpen()) {
            List<BaseNode> nodes = new ArrayList<>();
            String querySql = "SELECT * FROM MonitoringSite";
            Cursor cursor = db.rawQuery(querySql, null);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                MonitoringSite node = new MonitoringSite();
                node.setInverstigationID(cursor.getString(cursor.getColumnIndex("InverstigationID")));
                nodes.add(node);
                cursor.moveToNext();
            }
            return nodes;
        } else {
            return null;
        }
    }

    public List<BaseNode> findFractureSurfaceByFK(String key) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String querySql = "SELECT * FROM FractureSurface WHERE ID_MonitoringSite = ?";
        String[] args = new String[]{key};
        List<BaseNode> resultNodes = new ArrayList<BaseNode>();
        Cursor cursor = db.rawQuery(querySql, args);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            FractureSurface fsNode = new FractureSurface();
            fsNode.setID(cursor.getString(cursor.getColumnIndex("ID")));
            fsNode.setPosition(cursor.getString(cursor.getColumnIndex("Position")));
            fsNode.setDistance2Bank(cursor.getFloat(cursor.getColumnIndex("Distance2Bank")));
            fsNode.setID_MonitoringSite(cursor.getString(cursor.getColumnIndex("ID_MonitoringSite")));
            resultNodes.add(fsNode);
            cursor.moveToNext();
        }
        return resultNodes;
    }

    /**
     * 添加一个新节点，并返回该节点的主键
     *
     * @param node
     */
    public String addNewData(BaseNode node, String fk) {
        // 根据节点的类型判断应该添加什么记录
        String key = null;
        SQLiteDatabase db = helper.getWritableDatabase();
        if (db.isOpen()) {
            if (node instanceof MonitoringSite) {
                ContentValues cv = new ContentValues();
                key = "MON" + Utils.getTime();
                cv.put("InverstigationID", key);
                db.insert("MonitoringSite", null, cv);
            } else if (node instanceof FractureSurface) {
                ContentValues cv = new ContentValues();
                key = "SEC" + Utils.getTime();
                cv.put("ID", key);
                cv.put("ID_MonitoringSite", fk);
                db.insert("FractureSurface", null, cv);
            } else if (node instanceof MeasuringLine) {
                ContentValues cv = new ContentValues();
                key = "LIN" + Utils.getTime();
                cv.put("ID", key);
                cv.put("ID_FractureSurface", fk);
                db.insert("MeasuringLine", null, cv);
            } else if (node instanceof Sediment) {
                ContentValues cv = new ContentValues();
                key = "SED" + Utils.getTime();
                cv.put("SampleID", key);
                cv.put("ID_FractureSurface", fk);
                db.insert("Sediment", null, cv);
            } else if (node instanceof Zooplankton) {
                ContentValues cv = new ContentValues();
                key = "ZOO" + Utils.getTime();
                cv.put("SampleID", key);
                cv.put("ID_FractureSurface", fk);
                db.insert("Zooplankton", null, cv);
            } else if (node instanceof Phytoplankton) {
                ContentValues cv = new ContentValues();
                key = "PHY" + Utils.getTime();
                cv.put("SampleID", key);
                cv.put("ID_FractureSurface", fk);
                db.insert("Phytoplankton", null, cv);
            } else if (node instanceof Benthos) {
                ContentValues cv = new ContentValues();
                key = "BEN" + Utils.getTime();
                cv.put("SampleID", key);
                cv.put("ID_FractureSurface", fk);
                db.insert("Benthos", null, cv);
            } else if (node instanceof MeasuringPoint) {
                ContentValues cv = new ContentValues();
                key = "PNT" + Utils.getTime();
                cv.put("ID", key);
                cv.put("ID_MeasuringLine", fk);
                db.insert("MeasuringPoint", null, cv);
            } else if (node instanceof WaterLayer) {
                ContentValues cv = new ContentValues();
                key = "WLE" + Utils.getTime();
                cv.put("ID", key);
                cv.put("ID_MeasuringPoint", fk);
                db.insert("WaterLayer", null, cv);
            }
            db.close();
            return key;
        }
        return null;
    }

    public List<BaseNode> findMeasuringLineByFK(String key) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String querySql = "SELECT * FROM MeasuringLine WHERE ID_FractureSurface = ?";
        String[] args = new String[]{key};
        List<BaseNode> resultNodes = new ArrayList<BaseNode>();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery(querySql, args);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                MeasuringLine mlNode = new MeasuringLine();
                mlNode.setID(cursor.getString(cursor.getColumnIndex("ID")));
                mlNode.setStartLongitude(cursor.getFloat(cursor.getColumnIndex("StartLongitude")));
                mlNode.setStartLatitude(cursor.getFloat(cursor.getColumnIndex("StartLatitude")));
                mlNode.setEndLongitude(cursor.getFloat(cursor.getColumnIndex("EndLongitude")));
                mlNode.setEndLatitude(cursor.getFloat(cursor.getColumnIndex("EndLatitude")));
                mlNode.setID_FractureSurface(cursor.getString(cursor.getColumnIndex("ID_FractureSurface")));

                resultNodes.add(mlNode);
                cursor.moveToNext();
            }
            db.close();
        }
        return resultNodes;
    }

    public List<BaseNode> findSedimentByFK(String key) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String querySql = "SELECT * FROM Sediment WHERE ID_FractureSurface = ?";
        String[] args = new String[]{key};
        List<BaseNode> resultNodes = new ArrayList<BaseNode>();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery(querySql, args);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                Sediment sNode = new Sediment();
                sNode.setSampleID(cursor.getString(cursor.getColumnIndex("SampleID")));
                sNode.setPhoto(cursor.getString(cursor.getColumnIndex("Photo")));
                sNode.setID_FractureSurface(cursor.getString(cursor.getColumnIndex("ID_FractureSurface")));

                resultNodes.add(sNode);
                cursor.moveToNext();
            }
            db.close();
        }
        return resultNodes;
    }

    public List<BaseNode> findZooplanktonByFK(String key) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String querySql = "SELECT * FROM Zooplankton WHERE ID_FractureSurface = ?";
        String[] args = new String[]{key};
        List<BaseNode> resultNodes = new ArrayList<BaseNode>();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery(querySql, args);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                Zooplankton zNode = new Zooplankton();
                zNode.setSampleID(cursor.getString(cursor.getColumnIndex("SampleID")));
                zNode.setPhoto(cursor.getString(cursor.getColumnIndex("Photo")));
                zNode.setQuality(cursor.getFloat(cursor.getColumnIndex("Quality")));
                zNode.setBiomass(cursor.getFloat(cursor.getColumnIndex("Biomass")));
                zNode.setID_FractureSurface(cursor.getString(cursor.getColumnIndex("ID_FractureSurface")));
                resultNodes.add(zNode);
                cursor.moveToNext();
            }
            db.close();
        }
        return resultNodes;
    }

    public List<BaseNode> findPhytoplanktonByFK(String key) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String querySql = "SELECT * FROM Phytoplankton WHERE ID_FractureSurface = ?";
        String[] args = new String[]{key};
        List<BaseNode> resultNodes = new ArrayList<BaseNode>();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery(querySql, args);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                Phytoplankton pNode = new Phytoplankton();

                pNode.setSampleID(cursor.getString(cursor.getColumnIndex("SampleID")));
                pNode.setPhoto(cursor.getString(cursor.getColumnIndex("Photo")));
                pNode.setQuality(cursor.getFloat(cursor.getColumnIndex("Quality")));
                pNode.setBiomass(cursor.getFloat(cursor.getColumnIndex("Biomass")));
                pNode.setID_FractureSurface(cursor.getString(cursor.getColumnIndex("ID_FractureSurface")));

                resultNodes.add(pNode);
                cursor.moveToNext();
            }
            db.close();
        }
        return resultNodes;
    }

    public List<BaseNode> findBenthosByFK(String key) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String querySql = "SELECT * FROM Benthos WHERE ID_FractureSurface = ?";
        String[] args = new String[]{key};
        List<BaseNode> resultNodes = new ArrayList<BaseNode>();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery(querySql, args);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                Benthos pNode = new Benthos();

                pNode.setSampleID(cursor.getString(cursor.getColumnIndex("SampleID")));
                pNode.setPhoto(cursor.getString(cursor.getColumnIndex("Photo")));
                pNode.setQuality(cursor.getInt(cursor.getColumnIndex("Quality")));
                pNode.setBiomass(cursor.getFloat(cursor.getColumnIndex("Biomass")));
                pNode.setID_FractureSurface(cursor.getString(cursor.getColumnIndex("ID_FractureSurface")));

                resultNodes.add(pNode);
                cursor.moveToNext();
            }
            db.close();
        }
        return resultNodes;
    }

    public List<BaseNode> findMeasuringPointByFK(String key) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String querySql = "SELECT * FROM MeasuringPoint WHERE ID_MeasuringLine = ?";
        String[] args = new String[]{key};
        List<BaseNode> resultNodes = new ArrayList<BaseNode>();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery(querySql, args);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                MeasuringPoint mpNode = new MeasuringPoint();
                mpNode.setID(cursor.getString(cursor.getColumnIndex("ID")));
                mpNode.setLongitude(cursor.getFloat(cursor.getColumnIndex("Longitude")));
                mpNode.setLatitude(cursor.getFloat(cursor.getColumnIndex("Latitude")));
                mpNode.setID_MeasuringLine(cursor.getString(cursor.getColumnIndex("ID_MeasuringLine")));

                resultNodes.add(mpNode);
                cursor.moveToNext();
            }
            db.close();
        }
        return resultNodes;
    }

    public List<BaseNode> findWaterLayerByFk(String key) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String querySql = "SELECT * FROM WaterLayer WHERE ID_MeasuringPoint = ?";
        String[] args = new String[]{key};
        List<BaseNode> resultNodes = new ArrayList<BaseNode>();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery(querySql, args);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                WaterLayer wlNode = new WaterLayer();
                wlNode.setID(cursor.getString(cursor.getColumnIndex("ID")));
                wlNode.setLayer(cursor.getString(cursor.getColumnIndex("Layer")));
                wlNode.setDepth(cursor.getFloat(cursor.getColumnIndex("Depth")));
                wlNode.setTemperature(cursor.getFloat(cursor.getColumnIndex("Temperature")));
                wlNode.setWaterLevel(cursor.getFloat(cursor.getColumnIndex("WaterLevel")));
                wlNode.setVelocity(cursor.getFloat(cursor.getColumnIndex("Velocity")));
                wlNode.setID_MeasuringPoint(cursor.getString(cursor.getColumnIndex("ID_MeasuringPoint")));

                resultNodes.add(wlNode);
                cursor.moveToNext();
            }
            db.close();
        }
        return resultNodes;
    }
}
