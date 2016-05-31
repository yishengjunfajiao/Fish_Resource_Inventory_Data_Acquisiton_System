package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class FractureSurface extends BaseNode {
    @Override
    public String toString() {
        return "FractureSurface";
    }

    @Override
    public boolean isNodeTypeInNextLevel(BaseNode node) {
        if (node instanceof MeasuringLine || node instanceof Sediment ||
                node instanceof Zooplankton || node instanceof Phytoplankton || node instanceof Benthos) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        if (node instanceof FractureSurface || node instanceof MonitoringSite) {
            return true;
        }
        return false;
    }
}
