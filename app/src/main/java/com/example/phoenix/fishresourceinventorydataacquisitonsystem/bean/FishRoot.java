package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;

/**
 * Created by Phoenix on 2016/6/1.
 */
public class FishRoot extends BaseNode {

    public FishRoot() {
        super();
        this.show();
    }

    @Override
    public String toString() {
        return "root";
    }

    @Override
    public boolean isNodeTypeInNextLevel(BaseNode node) {
        if (node instanceof MonitoringSite) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        return false;
    }
}
