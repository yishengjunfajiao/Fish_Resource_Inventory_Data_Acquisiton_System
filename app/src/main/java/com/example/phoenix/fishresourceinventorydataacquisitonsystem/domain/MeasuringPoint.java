package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class MeasuringPoint extends BaseNode {
    public String ID;
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
