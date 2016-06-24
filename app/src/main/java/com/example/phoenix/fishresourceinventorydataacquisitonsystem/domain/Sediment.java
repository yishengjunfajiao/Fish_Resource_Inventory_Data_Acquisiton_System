package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * 沉积物
 * Created by Phoenix on 2016/5/31.
 */
public class Sediment extends BaseNode {

    public String getSampleID() {
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

    private String SampleID;
    private String Photo;

    @Override
    public String toString() {
        return TableNames.SEDIMENT;
    }

    @Override
    public int getLevel() {
        return CreatureLevels.SEDIMENT;
    }
}
