package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class DominantPhytoplanktonSpecies extends BaseNode {
    private String SampleID;
    private String Name;
    private String Photo;
    private float Quality;
    private float Biomass;
    private String ID_Phytoplankton;
    @Override
    public String toString() {
        return TableNames.DOMINANT_PHYTOPLANKTON_SPECIES;
    }
    @Override
    public int getLevel() {
        return CreatureLevels.DOMINANT_PHYTOPLANKTON_SPECIES;
    }
}
