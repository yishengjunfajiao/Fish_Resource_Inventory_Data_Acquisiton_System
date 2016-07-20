package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;

/**
 * 底栖生物
 * Created by Phoenix on 2016/5/31.
 */
public class Benthos extends BaseNode {

    //地栖生物主键
    private String SampleID = null;
    //照片路径
    private String Photo = null;
    //数量
    private int Quality = 0;
    //生物量
    private float Biomass = 0;
    //断面外键
    private String ID_FractureSurface = null;

    public void setSampleID(String sampleID) {
        SampleID = sampleID;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public void setQuality(int quality) {
        Quality = quality;
    }

    public void setBiomass(float biomass) {
        Biomass = biomass;
    }

    public void setID_FractureSurface(String ID_FractureSurface) {
        this.ID_FractureSurface = ID_FractureSurface;
    }


    public String getKey() {
        return SampleID;
    }

    public String getPhoto() {
        return Photo;
    }

    public int getQuality() {
        return Quality;
    }

    public float getBiomass() {
        return Biomass;
    }

    public String getID_FractureSurface() {
        return ID_FractureSurface;
    }

    @Override
    public int getLevel() {
        return 3;
    }

    @Override
    public String toString() {
        return TableNames.BENTHOS;
    }
}
