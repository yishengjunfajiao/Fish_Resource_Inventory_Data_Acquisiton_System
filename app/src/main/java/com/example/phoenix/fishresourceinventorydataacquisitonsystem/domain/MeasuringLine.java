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

    public void setStartLongitude(float startLongitude) {
        StartLongitude = startLongitude;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setStartLatitude(float startLatitude) {
        StartLatitude = startLatitude;
    }

    public void setEndLongitude(float endLongitude) {
        EndLongitude = endLongitude;
    }

    public void setEndLatitude(float endLatitude) {
        EndLatitude = endLatitude;
    }

    public void setID_FractureSurface(String ID_FractureSurface) {
        this.ID_FractureSurface = ID_FractureSurface;
    }


    @Override
    public int getLevel() {
        return CreatureLevels.MEASURING_LINE;
    }

    @Override
    public String toString() {
        return TableNames.MEASURING_LINE;
    }

    public String getKey() {
        return ID;
    }

    public float getStartLongitude() {
        return StartLongitude;
    }

    public float getStartLatitude() {
        return StartLatitude;
    }

    public float getEndLongitude() {
        return EndLongitude;
    }

    public float getEndLatitude() {
        return EndLatitude;
    }

    public String getID_FractureSurface() {
        return ID_FractureSurface;
    }
}
