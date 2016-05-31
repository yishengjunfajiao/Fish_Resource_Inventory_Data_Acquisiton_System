package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class DominantBenthosSpecies extends BaseNode {
    @Override
    public boolean isNodeTypeInNextLevel(BaseNode node) {
        return false;
    }

    @Override
    public boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        if (node instanceof WaterLayer || node instanceof Catches || node instanceof CatchTools
                || node instanceof Fishes || node instanceof FishEggs) {
            return false;
        }
        return true;
    }
}
