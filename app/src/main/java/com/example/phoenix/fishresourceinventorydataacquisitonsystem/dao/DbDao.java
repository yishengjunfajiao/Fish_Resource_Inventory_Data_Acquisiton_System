package com.example.phoenix.fishresourceinventorydataacquisitonsystem.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.DBOpenHelper;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Benthos;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.CatchTools;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Catches;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.DominantBenthosSpecies;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.DominantPhytoplanktonSpecies;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.DominantZooplanktonSpecies;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.FishEggs;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Fishes;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.FractureSurface;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MeasuringLine;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MeasuringPoint;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MonitoringSite;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Phytoplankton;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Sediment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.WaterLayer;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Zooplankton;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.TimeUtils;

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
                node.setInvestigator(cursor.getString(cursor.getColumnIndex("Investigator")));
                node.setInvestigationDate(cursor.getString(cursor.getColumnIndex("InvestigationDate")));
                node.setSite(cursor.getString(cursor.getColumnIndex("Site")));
                node.setRiver(cursor.getString(cursor.getColumnIndex("River")));
                node.setPhoto(cursor.getString(cursor.getColumnIndex("Photo")));
                node.setStartTime(cursor.getString(cursor.getColumnIndex("StartTime")));
                node.setEndTime(cursor.getString(cursor.getColumnIndex("EndTime")));
                node.setStartLongitude(cursor.getFloat(cursor.getColumnIndex("StartLongitude")));
                node.setStartLatitude(cursor.getFloat(cursor.getColumnIndex("StartLatitude")));
                node.setEndLongitude(cursor.getFloat(cursor.getColumnIndex("EndLongitude")));
                node.setEndLatitude(cursor.getFloat(cursor.getColumnIndex("EndLatitude")));
                node.setWeather(cursor.getString(cursor.getColumnIndex("Weather")));
                node.setTemperature(cursor.getFloat(cursor.getColumnIndex("Temperature")));

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
                key = "MON" + TimeUtils.getTime();
                ((MonitoringSite) node).setInverstigationID(key);
                cv.put("InverstigationID", key);
                db.insert("MonitoringSite", null, cv);
            } else if (node instanceof FractureSurface) {
                ContentValues cv = new ContentValues();
                key = "SEC" + TimeUtils.getTime();
                ((FractureSurface) node).setID(key);
                ((FractureSurface) node).setID_MonitoringSite(fk);
                cv.put("ID", key);
                cv.put("ID_MonitoringSite", fk);
                db.insert("FractureSurface", null, cv);
            } else if (node instanceof MeasuringLine) {
                ContentValues cv = new ContentValues();
                key = "LIN" + TimeUtils.getTime();
                ((MeasuringLine) node).setID(key);
                ((MeasuringLine) node).setID_FractureSurface(fk);
                cv.put("ID", key);
                cv.put("ID_FractureSurface", fk);
                db.insert("MeasuringLine", null, cv);
            } else if (node instanceof Sediment) {
                ContentValues cv = new ContentValues();
                key = "SED" + TimeUtils.getTime();
                ((Sediment) node).setSampleID(key);
                ((Sediment) node).setID_FractureSurface(fk);
                cv.put("SampleID", key);
                cv.put("ID_FractureSurface", fk);
                db.insert("Sediment", null, cv);
            } else if (node instanceof Zooplankton) {
                ContentValues cv = new ContentValues();
                key = "ZOO" + TimeUtils.getTime();
                ((Zooplankton) node).setSampleID(key);
                ((Zooplankton) node).setID_FractureSurface(fk);
                cv.put("SampleID", key);
                cv.put("ID_FractureSurface", fk);
                db.insert("Zooplankton", null, cv);
            } else if (node instanceof Phytoplankton) {
                ContentValues cv = new ContentValues();
                key = "PHY" + TimeUtils.getTime();
                ((Phytoplankton) node).setSampleID(key);
                ((Phytoplankton) node).setID_FractureSurface(fk);
                cv.put("SampleID", key);
                cv.put("ID_FractureSurface", fk);
                db.insert("Phytoplankton", null, cv);
            } else if (node instanceof Benthos) {
                ContentValues cv = new ContentValues();
                key = "BEN" + TimeUtils.getTime();
                ((Benthos) node).setSampleID(key);
                ((Benthos) node).setID_FractureSurface(fk);
                cv.put("SampleID", key);
                cv.put("ID_FractureSurface", fk);
                db.insert("Benthos", null, cv);
            } else if (node instanceof MeasuringPoint) {
                ContentValues cv = new ContentValues();
                key = "PNT" + TimeUtils.getTime();
                ((MeasuringPoint) node).setID(key);
                ((MeasuringPoint) node).setID_MeasuringLine(fk);
                cv.put("ID", key);
                cv.put("ID_MeasuringLine", fk);
                db.insert("MeasuringPoint", null, cv);
            } else if (node instanceof WaterLayer) {
                ContentValues cv = new ContentValues();
                key = "WLE" + TimeUtils.getTime();
                ((WaterLayer) node).setID_MeasuringPoint(fk);
                ((WaterLayer) node).setID(key);
                cv.put("ID", key);
                cv.put("ID_MeasuringPoint", fk);
                db.insert("WaterLayer", null, cv);
            } else if (node instanceof DominantZooplanktonSpecies) {
                ContentValues cv = new ContentValues();
                key = "PZO" + TimeUtils.getTime();
                ((DominantZooplanktonSpecies) node).setSampleID(key);
                ((DominantZooplanktonSpecies) node).setID_Zooplankton(fk);
                cv.put("SampleID", key);
                cv.put("ID_Zooplankton", fk);
                db.insert("DominantZooplanktonSpecies", null, cv);
            } else if (node instanceof DominantPhytoplanktonSpecies) {
                ContentValues cv = new ContentValues();
                key = "PPH" + TimeUtils.getTime();
                ((DominantPhytoplanktonSpecies) node).setSampleID(key);
                ((DominantPhytoplanktonSpecies) node).setID_Phytoplankton(fk);
                cv.put("SampleID", key);
                cv.put("ID_Phytoplankton", fk);
                db.insert("DominantPhytoplanktonSpecies", null, cv);
            } else if (node instanceof DominantBenthosSpecies) {
                ContentValues cv = new ContentValues();
                key = "PBE" + TimeUtils.getTime();
                ((DominantBenthosSpecies) node).setSampleID(key);
                ((DominantBenthosSpecies) node).setID_Benthos(fk);
                cv.put("SampleID", key);
                cv.put("ID_Benthos", fk);
                db.insert("DominantBenthosSpecies", null, cv);
            } else if (node instanceof CatchTools) {
                ContentValues cv = new ContentValues();
                key = "NET" + TimeUtils.getTime();
                ((CatchTools) node).setSampleID(key);
                ((CatchTools) node).setID_WaterLayer(fk);
                cv.put("SampleID", key);
                cv.put("ID_WaterLayer", fk);
                db.insert("CatchTools", null, cv);
            } else if (node instanceof Catches) {
                ContentValues cv = new ContentValues();
                key = "CTH" + TimeUtils.getTime();
                ((Catches) node).setSampleID(key);
                ((Catches) node).setID_WaterLayer(fk);
                cv.put("SampleID", key);
                cv.put("ID_WaterLayer", fk);
                db.insert("Catches", null, cv);
            } else if (node instanceof FishEggs) {
                ContentValues cv = new ContentValues();
                key = "FSE" + TimeUtils.getTime();
                ((FishEggs) node).setSampleID(key);
                ((FishEggs) node).setID_Catches(fk);
                cv.put("SampleID", key);
                cv.put("ID_Catches", fk);
                db.insert("FishEggs", null, cv);
            } else if (node instanceof Fishes) {
                ContentValues cv = new ContentValues();
                key = "FSS" + TimeUtils.getTime();
                ((Fishes) node).setSampleID(key);
                ((Fishes) node).setID_Catches(fk);
                cv.put("SampleID", key);
                cv.put("ID_Catches", fk);
                db.insert("Fishes", null, cv);
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
                zNode.setQuality(cursor.getInt(cursor.getColumnIndex("Quality")));
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

    public List<BaseNode> findDominantZooplanktonSpeciesByFk(String key) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String querySql = "SELECT * FROM DominantZooplanktonSpecies WHERE ID_Zooplankton = ?";
        String[] args = new String[]{key};
        List<BaseNode> resultNodes = new ArrayList<BaseNode>();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery(querySql, args);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                DominantZooplanktonSpecies dzs = new DominantZooplanktonSpecies();
                dzs.setSampleID(cursor.getString(cursor.getColumnIndex("SampleID")));
                dzs.setName(cursor.getString(cursor.getColumnIndex("Name")));
                dzs.setPhoto(cursor.getString(cursor.getColumnIndex("Photo")));
                dzs.setQuality(cursor.getFloat(cursor.getColumnIndex("Quality")));
                dzs.setBiomass(cursor.getFloat(cursor.getColumnIndex("Biomass")));
                dzs.setID_Zooplankton(cursor.getString(cursor.getColumnIndex("ID_Zooplankton")));

                resultNodes.add(dzs);
                cursor.moveToNext();
            }
            db.close();
        }
        return resultNodes;
    }

    public List<BaseNode> findDominantPhytoplanktonByFk(String key) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String querySql = "SELECT * FROM DominantPhytoplanktonSpecies WHERE ID_Phytoplankton = ?";
        String[] args = new String[]{key};
        List<BaseNode> resultNodes = new ArrayList<BaseNode>();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery(querySql, args);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                DominantPhytoplanktonSpecies dps = new DominantPhytoplanktonSpecies();

                dps.setSampleID(cursor.getString(cursor.getColumnIndex("SampleID")));
                dps.setName(cursor.getString(cursor.getColumnIndex("Name")));
                dps.setPhoto(cursor.getString(cursor.getColumnIndex("Photo")));
                dps.setQuality(cursor.getFloat(cursor.getColumnIndex("Quality")));
                dps.setBiomass(cursor.getFloat(cursor.getColumnIndex("Biomass")));
                dps.setID_Phytoplankton(cursor.getString(cursor.getColumnIndex("ID_Phytoplankton")));

                resultNodes.add(dps);
                cursor.moveToNext();
            }
            db.close();
        }
        return resultNodes;
    }

    public List<BaseNode> findDominantBenthosByFk(String key) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String querySql = "SELECT * FROM DominantBenthosSpecies WHERE ID_Benthos = ?";
        String[] args = new String[]{key};
        List<BaseNode> resultNodes = new ArrayList<BaseNode>();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery(querySql, args);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                DominantBenthosSpecies dps = new DominantBenthosSpecies();

                dps.setSampleID(cursor.getString(cursor.getColumnIndex("SampleID")));
                dps.setName(cursor.getString(cursor.getColumnIndex("Name")));
                dps.setPhoto(cursor.getString(cursor.getColumnIndex("Photo")));
                dps.setQuality(cursor.getFloat(cursor.getColumnIndex("Quality")));
                dps.setBiomass(cursor.getFloat(cursor.getColumnIndex("Biomass")));
                dps.setID_Benthos(cursor.getString(cursor.getColumnIndex("ID_Benthos")));

                resultNodes.add(dps);
                cursor.moveToNext();
            }
            db.close();
        }
        return resultNodes;
    }

    public List<BaseNode> findCatchesByFK(String key) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String querySql = "SELECT * FROM Catches WHERE ID_WaterLayer = ?";
        String[] args = new String[]{key};
        List<BaseNode> resultNodes = new ArrayList<BaseNode>();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery(querySql, args);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                Catches catches = new Catches();
                catches.setSampleID(cursor.getString(cursor.getColumnIndex("SampleID")));
                catches.setName(cursor.getString(cursor.getColumnIndex("Name")));
                catches.setPhoto(cursor.getString(cursor.getColumnIndex("Photo")));
                catches.setTotalQuality(cursor.getInt(cursor.getColumnIndex("TotalQuality")));
                catches.setEggQuality(cursor.getInt(cursor.getColumnIndex("EggQuality")));
                catches.setFryQuality(cursor.getInt(cursor.getColumnIndex("FryQuality")));
                catches.setID_WaterLayer(cursor.getString(cursor.getColumnIndex("ID_WaterLayer")));

                resultNodes.add(catches);
                cursor.moveToNext();
            }
            db.close();
        }
        return resultNodes;
    }

    public List<BaseNode> findCatchToolsByFK(String key) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String querySql = "SELECT * FROM CatchTools WHERE ID_WaterLayer = ?";
        String[] args = new String[]{key};
        List<BaseNode> resultNodes = new ArrayList<BaseNode>();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery(querySql, args);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                CatchTools catchTools = new CatchTools();
                catchTools.setSampleID(cursor.getString(cursor.getColumnIndex("SampleID")));
                catchTools.setName(cursor.getString(cursor.getColumnIndex("Name")));
                catchTools.setPhoto(cursor.getString(cursor.getColumnIndex("Photo")));
                catchTools.setNetsModel(cursor.getString(cursor.getColumnIndex("NetsModel")));
                catchTools.setNetMouthArea(cursor.getFloat(cursor.getColumnIndex("NetMouthArea")));
                catchTools.setNetMouthDip(cursor.getFloat(cursor.getColumnIndex("NetMouthDip")));
                catchTools.setStartTime(cursor.getString(cursor.getColumnIndex("StartTime")));
                catchTools.setEndTime(cursor.getString(cursor.getColumnIndex("EndTime")));
                catchTools.setNetMouthVelocity(cursor.getFloat(cursor.getColumnIndex("NetMouthVelocity")));
                catchTools.setID_WaterLayer(cursor.getString(cursor.getColumnIndex("ID_WaterLayer")));

                resultNodes.add(catchTools);
                cursor.moveToNext();
            }
            db.close();
        }
        return resultNodes;
    }

    public List<BaseNode> findFishesByFK(String key) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String querySql = "SELECT * FROM Fishes WHERE ID_Catches = ?";
        String[] args = new String[]{key};
        List<BaseNode> resultNodes = new ArrayList<BaseNode>();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery(querySql, args);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                Fishes fishes = new Fishes();
                fishes.setSampleID(cursor.getString(cursor.getColumnIndex("SampleID")));
                fishes.setPhoto(cursor.getString(cursor.getColumnIndex("Photo")));
                fishes.setBodyLength(cursor.getFloat(cursor.getColumnIndex("BodyLength")));
                fishes.setLength(cursor.getFloat(cursor.getColumnIndex("Length")));
                fishes.setBodyWeight(cursor.getFloat(cursor.getColumnIndex("BodyWeight")));
                fishes.setAge(cursor.getFloat(cursor.getColumnIndex("Age")));
                fishes.setID_Catches(cursor.getString(cursor.getColumnIndex("ID_Catches")));

                resultNodes.add(fishes);
                cursor.moveToNext();
            }
            db.close();
        }
        return resultNodes;
    }

    public List<BaseNode> findFishEggsByFK(String key) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String querySql = "SELECT * FROM FishEggs WHERE ID_Catches = ?";
        String[] args = new String[]{key};
        List<BaseNode> resultNodes = new ArrayList<BaseNode>();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery(querySql, args);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                FishEggs fishEggs = new FishEggs();
                fishEggs.setSampleID(cursor.getString(cursor.getColumnIndex("SampleID")));
                fishEggs.setPhoto(cursor.getString(cursor.getColumnIndex("Photo")));
                fishEggs.setPeriod(cursor.getString(cursor.getColumnIndex("Period")));
                fishEggs.setDiameter(cursor.getFloat(cursor.getColumnIndex("Diameter")));
                fishEggs.setEMDiameter(cursor.getFloat(cursor.getColumnIndex("EMDiameter")));
                fishEggs.setPigmentProp(cursor.getString(cursor.getColumnIndex("PigmentProp")));
                fishEggs.setEmbryoProp(cursor.getString(cursor.getColumnIndex("EmbryoProp")));
                fishEggs.setID_Catches(cursor.getString(cursor.getColumnIndex("ID_Catches")));

                resultNodes.add(fishEggs);
                cursor.moveToNext();
            }
            db.close();
        }
        return resultNodes;
    }

    /**
     * 更新结点
     *
     * @param node
     */
    public void updateNode(BaseNode node) {
        SQLiteDatabase db = helper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues cv = new ContentValues();
            String whereClause = null;
            String[] whereArgs = new String[]{node.getKey()};
            if (node instanceof MonitoringSite) {
                MonitoringSite ms = (MonitoringSite) node;
                whereClause = "InverstigationID=?";
                cv.put("Institution", ms.getInstitution());
                cv.put("Investigator", ms.getInvestigator());
                cv.put("InvestigationDate", ms.getInvestigationDate());
                cv.put("Site", ms.getSite());
                cv.put("River", ms.getRiver());
                cv.put("Photo", ms.getPhoto());
                cv.put("StartTime", ms.getStartTime());
                cv.put("EndTime", ms.getEndTime());
                cv.put("StartLongitude", ms.getStartLongitude());
                cv.put("StartLatitude", ms.getStartLatitude());
                cv.put("EndLongitude", ms.getEndLongitude());
                cv.put("EndLatitude", ms.getEndLatitude());
                cv.put("Weather", ms.getWeather());
                cv.put("Temperature", ms.getTemperature());
                db.update("MonitoringSite", cv, whereClause, whereArgs);
            } else if (node instanceof FractureSurface) {
                FractureSurface fs = (FractureSurface) node;
                whereClause = "ID=?";
                cv.put("Position", String.valueOf(fs.getPosition()));
                cv.put("Distance2Bank", fs.getDistance2Bank());
                db.update("FractureSurface", cv, whereClause, whereArgs);
            } else if (node instanceof MeasuringLine) {
                MeasuringLine ml = (MeasuringLine) node;
                whereClause = "ID=?";
                cv.put("StartLongitude", String.valueOf(ml.getStartLongitude()));
                cv.put("StartLatitude", String.valueOf(ml.getStartLatitude()));
                cv.put("EndLongitude", String.valueOf(ml.getEndLongitude()));
                cv.put("EndLatitude", String.valueOf(ml.getEndLatitude()));
                db.update("MeasuringLine", cv, whereClause, whereArgs);
            } else if (node instanceof MeasuringPoint) {
                MeasuringPoint mp = (MeasuringPoint) node;
                whereClause = "ID=?";
                cv.put("Longitude", String.valueOf(mp.getLongitude()));
                cv.put("Latitude", String.valueOf(mp.getLatitude()));
                db.update("MeasuringPoint", cv, whereClause, whereArgs);
            } else if (node instanceof WaterLayer) {
                WaterLayer waterLayer = (WaterLayer) node;
                whereClause = "ID=?";
                cv.put("Velocity", waterLayer.getVelocity());
                cv.put("WaterLevel", waterLayer.getWaterLevel());
                cv.put("Temperature", waterLayer.getTemperature());
                cv.put("Depth", waterLayer.getDepth());
                cv.put("Layer", waterLayer.getLayer());
                db.update("WaterLayer", cv, whereClause, whereArgs);
            } else if (node instanceof CatchTools) {
                CatchTools ct = (CatchTools) node;
                whereClause = "SampleID=?";
                cv.put("Name", ct.getName());
                cv.put("Photo", ct.getPhoto());
                cv.put("NetsModel", ct.getNetsModel());
                cv.put("NetMouthArea", ct.getNetMouthArea());
                cv.put("NetMouthDip", ct.getNetMouthDip());
                cv.put("StartTime", ct.getStartTime());
                cv.put("EndTime", ct.getEndTime());
                cv.put("NetMouthVelocity", ct.getNetMouthVelocity());
                db.update("CatchTools", cv, whereClause, whereArgs);
            } else if (node instanceof Phytoplankton) {
                Phytoplankton p = (Phytoplankton) node;
                whereClause = "SampleID=?";
                cv.put("Photo", p.getPhoto());
                cv.put("Quality", p.getQuality());
                cv.put("Biomass", p.getBiomass());
                db.update("Phytoplankton", cv, whereClause, whereArgs);
            } else if (node instanceof Zooplankton) {
                Zooplankton z = (Zooplankton) node;
                whereClause = "SampleID=?";
                cv.put("Photo", z.getPhoto());
                cv.put("Quality", z.getQuality());
                cv.put("Biomass", z.getBiomass());
                db.update("Zooplankton", cv, whereClause, whereArgs);
            } else if (node instanceof Benthos) {
                Benthos b = (Benthos) node;
                whereClause = "SampleID=?";
                cv.put("Photo", b.getPhoto());
                cv.put("Quality", b.getQuality());
                cv.put("Biomass", b.getBiomass());
                db.update("Benthos", cv, whereClause, whereArgs);
            }
            db.close();
        }
    }
}
