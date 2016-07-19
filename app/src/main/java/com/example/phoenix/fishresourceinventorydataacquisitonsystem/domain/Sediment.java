package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * 沉积物
 * Created by Phoenix on 2016/5/31.
 */
public class Sediment extends BaseNode {

    private String SampleID;
    private String Photo;
    private String ID_FractureSurface;

    public String getKey() {
        return SampleID;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setSampleID(String sampleID) {
        SampleID = sampleID;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }


    @Override
    public String toString() {
        return TableNames.SEDIMENT;
    }

    @Override
    public int getLevel() {
        return CreatureLevels.SEDIMENT;
    }

    public String getID_FractureSurface() {
        return ID_FractureSurface;
    }

    public void setID_FractureSurface(String ID_FractureSurface) {
        this.ID_FractureSurface = ID_FractureSurface;
    }
}
