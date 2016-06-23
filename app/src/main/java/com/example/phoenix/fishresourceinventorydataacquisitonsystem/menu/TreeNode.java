package com.example.phoenix.fishresourceinventorydataacquisitonsystem.menu;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class TreeNode {

    protected boolean isShown;
    protected boolean isExtended;
    private BaseNode node;

    public TreeNode(BaseNode node) {
        isShown = false;
        isExtended = false;
        this.node = node;
    }

    public BaseNode getValue() {
        return node;
    }

    protected int getLevel() {
        return node.getLevel();
    }

    protected boolean isShown() {
        return isShown;
    }

    protected boolean isExtended() {
        return isExtended;
    }

    protected void show() {
        this.isShown = true;
    }

    protected void hide() {
        this.isShown = false;
    }

    protected void extend() {
        this.isExtended = true;
    }

    protected void close() {
        this.isExtended = false;
    }

}
