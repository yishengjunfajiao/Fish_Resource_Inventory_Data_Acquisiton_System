package com.example.phoenix.fishresourceinventorydataacquisitonsystem.ui.menu;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Phoenix on 2016/6/23.
 */
public class MenuList {

    private LinkedList<TreeNode> totalList = new LinkedList<>();
    private LinkedList<TreeNode> shownList = new LinkedList<>();

    /**
     * 返回状态为shown的节点
     *
     * @return 返回的所有节点
     */
    public List<TreeNode> getShownList() {
        return shownList;
    }

    public List<TreeNode> getTotalList() {
        return totalList;
    }

    public void updateNodes() {
        if (shownList == null) {
            shownList = new LinkedList<>();
        } else {
            shownList.clear();
        }
        for (TreeNode t : totalList) {
            if (t.isShown()) {
                shownList.add(t);
            }
        }
    }

    /**
     * 将index位置的节点展开，使得该节点的下一层节点状态为show
     *
     * @param index 该index是shownList的位置
     */
    public void open(int index) {
        TreeNode t = shownList.get(index);
        int pos = totalList.indexOf(t) + 1;
        t.extend();
        while (pos < totalList.size() && totalList.get(pos).getLevel() > t.getLevel()) {
            if (totalList.get(pos).getLevel() == t.getLevel() + 1) {
                totalList.get(pos).show();
                totalList.get(pos).close();
            } else {
                totalList.get(pos).hide();
                totalList.get(pos).close();
            }
            pos++;
        }
        updateNodes();
    }

    public void close(int index) {
        TreeNode t = shownList.get(index);
        int pos = totalList.indexOf(t) + 1;
        t.close();
        while (pos < totalList.size() && totalList.get(pos).getLevel() > t.getLevel()) {
            totalList.get(pos).hide();
            totalList.get(pos).close();
            pos++;
        }
        updateNodes();
    }

    /**
     * 删除index位置上的节点，然后刷新节点状态
     *
     * @param index index是shownList链上的下标
     */
    public void deleteNode(int index) {
        int pos = totalList.indexOf(shownList.get(index));
        totalList.remove(pos);
        updateNodes();
    }

    /**
     * 在index位置的后面一个（index + 1)处添加一个节点，然后展开index节点，刷新节点状态
     * 之所以用index + 1是为了方便处理
     *
     * @param t     TreeNode节点
     * @param index 位置
     */
    public void addNode(TreeNode t, int index) {
        t.show();
        t.close();
        if (index == -1) {
            totalList.add(0, t);
            updateNodes();
            return;
        }
        int pos = totalList.indexOf(shownList.get(index));
        totalList.add(pos + 1, t);
        open(index);
        updateNodes();
    }

    /**
     * 在树的尾部添加一个节点
     *
     * @param t
     */
    public void addNode(TreeNode t) {
        addNode(t, totalList.size() - 1);
    }

}
