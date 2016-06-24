package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class MeasuringPoint extends BaseNode {
    public String ID;

    public void setLongitude(float longitude) {
        Longitude = longitude;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setLatitude(float latitude) {
        Latitude = latitude;
    }

    public void setID_MeasuringLine(String ID_MeasuringLine) {
        this.ID_MeasuringLine = ID_MeasuringLine;
    }

    public float Longitude;
    public float Latitude;
    public String ID_MeasuringLine;

    @Override
    public String toString() {
        return TableNames.MEASURING_POINT;
    }

    @Override
    public int getLevel() {
        return CreatureLevels.MEASURING_POINT;
    }
}
