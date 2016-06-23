package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class Phytoplankton extends BaseNode {

    private String SampleID;
    private String Photo;
    private float Quality;
    private float Biomass;

    public String getID_FractureSurface() {
        return ID_FractureSurface;
    }

    public String getSampleID() {
        return SampleID;
    }

    public String getPhoto() {
        return Photo;
    }

    public float getQuality() {
        return Quality;
    }

    public float getBiomass() {
        return Biomass;
    }

    private String ID_FractureSurface;


    @Override
    public String toString() {
        return TableNames.PHYTOPLANKTON;
    }

    @Override
    public int getLevel() {
        return CreatureLevels.PHYTOPLANKTON;
    }
}
