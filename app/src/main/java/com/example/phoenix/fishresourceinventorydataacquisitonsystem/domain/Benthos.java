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
    private int Biomass = 0;
    //断面外键
    private String ID_FractureSurface = null;

    public String getSampleID() {
        return SampleID;
    }

    public String getPhoto() {
        return Photo;
    }

    public int getQuality() {
        return Quality;
    }

    public int getBiomass() {
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
