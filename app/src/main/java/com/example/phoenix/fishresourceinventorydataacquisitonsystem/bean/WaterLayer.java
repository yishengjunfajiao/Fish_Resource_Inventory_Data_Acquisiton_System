package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class WaterLayer extends BaseNode {
    @Override
    public String toString() {
        return "WaterLayer";
    }

    @Override
    protected boolean isNodeTypeInNextLevel(BaseNode node) {
        if (node instanceof Catches || node instanceof CatchTools) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        if (!(node instanceof CatchTools) && !(node instanceof Catches)
                && !(node instanceof Fishes) && !(node instanceof FishEggs)) {
            return true;
        }
        return false;
    }
}
