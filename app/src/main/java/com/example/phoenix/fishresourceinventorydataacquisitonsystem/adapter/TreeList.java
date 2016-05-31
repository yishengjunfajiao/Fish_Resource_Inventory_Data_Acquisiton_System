package com.example.phoenix.fishresourceinventorydataacquisitonsystem.adapter;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;

import java.util.LinkedList;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class TreeList<T extends BaseNode> {
    //将所有的节点按树形存储
    private LinkedList<T> treeList;
    //将所有可以在界面上显示的节点按照树的先序遍历存储
    private LinkedList<T> showList;

    public TreeList() {
        treeList = new LinkedList<T>();
        showList = new LinkedList<T>();
    }

    public void updateShowListIndex() {
        if (showList == null) {
            showList = new LinkedList<>();
        } else {
            showList.clear();
        }
        for (T t : treeList) {
            if (t.isShown()) {
                showList.add(t);
            }
        }
    }

    public void add(T node) {
        treeList.add(node);
        updateShowListIndex();
    }

    public void add(int index, T node) {
        treeList.add(index, node);
        updateShowListIndex();
    }

    /**
     * 打开树形菜单中，下标为index的节点
     *
     * @param index 此index是showList的下标
     */
    private void openNode(int index) {
        T preOpenedNode = showList.get(index);
        T node;
        int i = treeList.indexOf(preOpenedNode);
        for (i = i + 1; i < treeList.size(); i++) {
            node = treeList.get(i);
            //如果遍历到的节点是展开节点的直接下属，则将其 isShown = true
            if (preOpenedNode.isNodeTypeInNextLevel(node)) {
                node.show();
            } else if (preOpenedNode.isNodeTypeInParallelOrHigherLevel(node)) {
                break;
            }
        }
        updateShowListIndex();
    }

    /**
     * 关闭树形菜单中，下标为index的节点
     *
     * @param index 此index是showList的下标
     */
    private void closeNode(int index) {
        T preOpenedNode = showList.get(index);
        T node;
        int i = treeList.indexOf(preOpenedNode);
        for (i = i + 1; i < treeList.size(); i++) {
            node = treeList.get(i);
            if (preOpenedNode.isNodeTypeInParallelOrHigherLevel(node)) {
                break;
            } else {
                node.close();
                node.hide();
            }
        }
        updateShowListIndex();
    }

    protected void changeNodeState(int index) {
        T t = showList.get(index);
        if (t.isExtended()) {
            closeNode(index);
            t.close();
        } else {
            openNode(index);
            t.extend();
        }
    }

    public int getTotalSize() {
        return this.treeList.size();
    }

    public int getShownNodeSize() {
        return showList.size();
    }

    public T getItemInTree(int index) {
        return treeList.get(index);
    }

    public T getItemInShownList(int index) {
        return showList.get(index);
    }

    public String getShownItemText(int index) {
        return showList.get(index).toString();
    }

    public String getTreeItemText(int index) {
        return treeList.get(index).toString();
    }

}
