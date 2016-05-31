package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class MeasuringPoint extends BaseNode {
    @Override
    public String toString() {
        return "MeasuringPoint";
    }

    @Override
    protected boolean isNodeTypeInNextLevel(BaseNode node) {
        if (node instanceof WaterLayer) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        if (!(node instanceof WaterLayer) && !(node instanceof Catches) && !(node instanceof CatchTools)
                && !(node instanceof Fishes) && !(node instanceof FishEggs)) {
            return true;
        }
        return false;
    }
}
