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
    @Override
    public String toString() {
        return TableNames.FISHES;
    }
    @Override
    public int getLevel() {
        return CreatureLevels.FISHES;
    }
}
