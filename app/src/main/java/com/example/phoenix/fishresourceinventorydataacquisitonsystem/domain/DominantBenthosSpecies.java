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


    @Override
    public String toString() {
        return TableNames.DOMINANT_BENTHOS_SPECIES;
    }

    @Override
    public int getLevel() {
        return CreatureLevels.DOMINANT_BENTHOS_SPECIES;
    }
}
