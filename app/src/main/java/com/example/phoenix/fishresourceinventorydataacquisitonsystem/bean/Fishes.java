package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class Fishes extends BaseNode {
    @Override
    protected boolean isNodeTypeInNextLevel(BaseNode node) {
        return false;
    }

    @Override
    protected boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        return true;
    }
}
