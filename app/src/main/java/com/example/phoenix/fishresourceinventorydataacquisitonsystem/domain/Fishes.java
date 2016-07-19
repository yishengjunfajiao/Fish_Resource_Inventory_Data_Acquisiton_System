package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class Fishes extends BaseNode {

    private String SampleID;
    private String Photo;
    private float BodyLength;
    private float Length;
    private float BodyWeight;
    private float Age;
    private String ID_Catches;

    public void setSampleID(String sampleID) {
        SampleID = sampleID;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public void setBodyLength(float bodyLength) {
        BodyLength = bodyLength;
    }

    public void setLength(float length) {
        Length = length;
    }

    public void setBodyWeight(float bodyWeight) {
        BodyWeight = bodyWeight;
    }

    public void setAge(float age) {
        Age = age;
    }

    public void setID_Catches(String ID_Catches) {
        this.ID_Catches = ID_Catches;
    }

    @Override
    public String toString() {
        return TableNames.FISHES;
    }

    @Override
    public int getLevel() {
        return CreatureLevels.FISHES;
    }

    public String getKey() {
        return SampleID;
    }

    public String getPhoto() {
        return Photo;
    }

    public float getBodyLength() {
        return BodyLength;
    }

    public float getLength() {
        return Length;
    }

    public float getBodyWeight() {
        return BodyWeight;
    }

    public float getAge() {
        return Age;
    }

    public String getID_Catches() {
        return ID_Catches;
    }
}
