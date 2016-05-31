package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base;

/**
 * Created by Phoenix on 2016/5/31.
 */
public abstract class BaseNode {
    public boolean isShown() {
        return isShown;
    }

    protected boolean isShown;

    protected boolean isExtended;

    public BaseNode() {
        isShown = false;
        isExtended = false;
    }

    public boolean isExtended() {
        return isExtended;
    }

    public void extend() {
        isExtended = true;
    }

    public void close() {
        isExtended = false;
    }

    public abstract boolean isNodeTypeInNextLevel(BaseNode node);

    public abstract boolean isNodeTypeInParallelOrHigherLevel(BaseNode node);

    public void show() {
        this.isShown = true;
    }

    public void hide() {
        this.isShown = false;
    }
}
