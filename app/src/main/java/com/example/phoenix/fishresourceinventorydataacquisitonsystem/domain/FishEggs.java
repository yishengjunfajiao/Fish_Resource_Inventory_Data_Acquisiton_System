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

    @Override
    public String toString() {
        return TableNames.FISH_EGGS;
    }

    @Override
    public int getLevel() {
        return CreatureLevels.FISH_EGGS;
    }
}
