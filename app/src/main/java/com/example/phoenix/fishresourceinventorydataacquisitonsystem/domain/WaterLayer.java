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


    @Override
    public String toString() {
        return TableNames.WATER_LAYER;
    }

    @Override
    public int getLevel() {
        return CreatureLevels.WATER_LAYER;
    }

    public String getKey() {
        return ID;
    }

    public String getLayer() {
        return Layer;
    }

    public float getDepth() {
        return Depth;
    }

    public float getTemperature() {
        return Temperature;
    }

    public float getWaterLevel() {
        return WaterLevel;
    }

    public float getVelocity() {
        return Velocity;
    }

    public String getID_MeasuringPoint() {
        return ID_MeasuringPoint;
    }
}
