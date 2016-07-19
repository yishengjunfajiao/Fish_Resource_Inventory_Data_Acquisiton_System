package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class FishEggs extends BaseNode {

    private String SampleID;
    private String Photo;
    private String Period;
    private float Diameter;
    private float EMDiameter;
    private String PigmentProp;
    private String EmbryoProp;
    private String ID_Catches;

    public void setSampleID(String sampleID) {
        SampleID = sampleID;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public void setPeriod(String period) {
        Period = period;
    }

    public void setDiameter(float diameter) {
        Diameter = diameter;
    }

    public void setEMDiameter(float EMDiameter) {
        this.EMDiameter = EMDiameter;
    }

    public void setPigmentProp(String pigmentProp) {
        PigmentProp = pigmentProp;
    }

    public void setEmbryoProp(String embryoProp) {
        EmbryoProp = embryoProp;
    }

    public void setID_Catches(String ID_Catches) {
        this.ID_Catches = ID_Catches;
    }


    @Override
    public String toString() {
        return TableNames.FISH_EGGS;
    }

    @Override
    public int getLevel() {
        return CreatureLevels.FISH_EGGS;
    }

    public String getKey() {
        return SampleID;
    }

    public String getPhoto() {
        return Photo;
    }

    public String getPeriod() {
        return Period;
    }

    public float getDiameter() {
        return Diameter;
    }

    public float getEMDiameter() {
        return EMDiameter;
    }

    public String getPigmentProp() {
        return PigmentProp;
    }

    public String getEmbryoProp() {
        return EmbryoProp;
    }

    public String getID_Catches() {
        return ID_Catches;
    }
}
