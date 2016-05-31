package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class Catches extends BaseNode {
    @Override
    public String toString() {
        return "Catches";
    }

    @Override
    protected boolean isNodeTypeInNextLevel(BaseNode node) {
        if (node instanceof FishEggs || node instanceof Fishes) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        if (!(node instanceof Fishes) && !(node instanceof FishEggs)) {
            return true;
        }
        return false;
    }
}
