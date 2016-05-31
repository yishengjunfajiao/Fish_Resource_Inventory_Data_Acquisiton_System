package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class MonitoringSite extends BaseNode {
    @Override
    public String toString() {
        return "MonitoringSite";
    }

    public MonitoringSite() {
        super();
        this.isShown = true;
    }

    @Override
    protected boolean isNodeTypeInNextLevel(BaseNode node) {
        if (node instanceof FractureSurface) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        if (node instanceof MonitoringSite) {
            return true;
        }
        return false;
    }
}
