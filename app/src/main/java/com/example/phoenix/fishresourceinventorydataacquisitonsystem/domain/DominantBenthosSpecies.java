package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * 底栖生物优势种
 * Created by Phoenix on 2016/5/31.
 */
public class DominantBenthosSpecies extends BaseNode {

    private String SampleID;
    private String Name;
    private String Photo;
    private float Quality;
    private float Biomass;
    private String ID_Benthos;

    public void setSampleID(String sampleID) {
        SampleID = sampleID;
    }

    public void setName(String name) {
        Name = name;
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

    public void setID_Benthos(String ID_Benthos) {
        this.ID_Benthos = ID_Benthos;
    }


    @Override
    public String toString() {
        return TableNames.DOMINANT_BENTHOS_SPECIES;
    }

    @Override
    public int getLevel() {
        return CreatureLevels.DOMINANT_BENTHOS_SPECIES;
    }

    @Override
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

    public String getID_Benthos() {
        return ID_Benthos;
    }
}
