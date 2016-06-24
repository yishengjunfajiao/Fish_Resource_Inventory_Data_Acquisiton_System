package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class WaterLayer extends BaseNode {
    private String ID;

    public void setLayer(String layer) {
        Layer = layer;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setDepth(float depth) {
        Depth = depth;
    }

    public void setTemperature(float temperature) {
        Temperature = temperature;
    }

    public void setWaterLevel(float waterLevel) {
        WaterLevel = waterLevel;
    }

    public void setVelocity(float velocity) {
        Velocity = velocity;
    }

    public void setID_MeasuringPoint(String ID_MeasuringPoint) {
        this.ID_MeasuringPoint = ID_MeasuringPoint;
    }

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
