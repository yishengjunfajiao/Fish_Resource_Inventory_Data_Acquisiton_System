package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class WaterLayer extends BaseNode {
    private String ID;
    private String Layer;
    private float Depth;
    private float Temperature;
    private float WaterLevel;
    private float Velocity;
    private String ID_MeasuringPoint;

    @Override
    public String toString() {
        return TableNames.WATER_LAYER;
    }

    @Override
    public int getLevel() {
        return CreatureLevels.WATER_LAYER;
    }
}
