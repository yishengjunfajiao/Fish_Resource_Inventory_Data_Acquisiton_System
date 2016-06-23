package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class FractureSurface extends BaseNode {

    private String ID;
    private String Position;
    private float Distance2Bank;
    private String ID_MonitoringSite;


    @Override
    public String toString() {
        return TableNames.FRACTURE_SURFACE;
    }

    @Override
    public int getLevel() {
        return CreatureLevels.FRACTURE_SURFACE;
    }
}
