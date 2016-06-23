package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class MeasuringLine extends BaseNode {
    private String ID;
    private float StartLongitude;
    private float StartLatitude;
    private float EndLongitude;
    private float EndLatitude;
    private String ID_FractureSurface;

    @Override
    public int getLevel() {
        return CreatureLevels.MEASURING_LINE;
    }

    @Override
    public String toString() {
        return TableNames.MEASURING_LINE;
    }
}
