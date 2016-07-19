package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class DominantZooplanktonSpecies extends BaseNode {

    private String SampleID;
    private String Name;
    private String Photo;
    private float Quality;
    private float Biomass;
    private String ID_Zooplankton;

    public void setName(String name) {
        Name = name;
    }

    public void setSampleID(String sampleID) {
        SampleID = sampleID;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public void setQuality(float quality) {
        Quality = quality;
    }

    public void setBiomass(float biomass) {
        Biomass = biomass;
    }

    public void setID_Zooplankton(String ID_Zooplankton) {
        this.ID_Zooplankton = ID_Zooplankton;
    }

    @Override
    public String toString() {
        return TableNames.DOMINANT_ZOOPLANKTON_SPECIES;
    }

    @Override
    public int getLevel() {
        return CreatureLevels.DOMINANT_ZOOPLANKTON_SPECIES;
    }

    public String getKey() {
        return SampleID;
    }

    public String getName() {
        return Name;
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

    public String getID_Zooplankton() {
        return ID_Zooplankton;
    }
}
