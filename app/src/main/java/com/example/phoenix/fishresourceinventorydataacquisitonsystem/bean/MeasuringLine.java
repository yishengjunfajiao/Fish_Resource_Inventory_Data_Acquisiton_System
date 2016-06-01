package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class MeasuringLine extends BaseNode {
    @Override
    public String toString() {
        return "MeasuringLine";
    }

    @Override
    public boolean isNodeTypeInNextLevel(BaseNode node) {
        if (node instanceof MeasuringPoint) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        if (node instanceof Phytoplankton || node instanceof Zooplankton || node instanceof Sediment || node instanceof MeasuringLine
                || node instanceof Benthos) {
            return true;
        } else if (node instanceof MonitoringSite || node instanceof FractureSurface || node instanceof FishRoot) {
            return true;
        }
        return false;
    }
}
