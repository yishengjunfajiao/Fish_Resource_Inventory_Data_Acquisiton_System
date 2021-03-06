package com.example.phoenix.fishresourceinventorydataacquisitonsystem.ui.menu;


import android.app.Fragment;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.base.BaseFragment;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class TreeNode {

    protected boolean isShown;
    protected boolean isExtended;
    private BaseNode node;
    private BaseFragment fragment;

    public TreeNode(BaseNode node) {
        isShown = false;
        isExtended = false;
        this.node = node;
    }

    public boolean isInfoComplete() {
        return false;
    }

    public void setFragment(BaseFragment fragment) {
        this.fragment = fragment;
    }

    public BaseFragment getFragment() {
        return this.fragment;
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
