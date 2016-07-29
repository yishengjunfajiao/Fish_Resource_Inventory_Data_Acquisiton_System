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
    private int Quality;
    private float Biomass;
    private String ID_FractureSurface;

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


    public String getID_FractureSurface() {
        return ID_FractureSurface;
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


    @Override
    public String toString() {
        return TableNames.PHYTOPLANKTON;
    }

    @Override
    public int getLevel() {
        return CreatureLevels.PHYTOPLANKTON;
    }
}
