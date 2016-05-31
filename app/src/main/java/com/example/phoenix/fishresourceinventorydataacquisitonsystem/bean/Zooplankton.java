package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class Zooplankton extends BaseNode {
    @Override
    protected boolean isNodeTypeInNextLevel(BaseNode node) {
        if (node instanceof DominantZooplanktonSpecies) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        if (node instanceof Phytoplankton || node instanceof Zooplankton || node instanceof Sediment || node instanceof MeasuringLine
                || node instanceof Benthos) {
            return true;
        } else if (node instanceof MonitoringSite || node instanceof FractureSurface) {
            return true;
        }
        return false;
    }
}