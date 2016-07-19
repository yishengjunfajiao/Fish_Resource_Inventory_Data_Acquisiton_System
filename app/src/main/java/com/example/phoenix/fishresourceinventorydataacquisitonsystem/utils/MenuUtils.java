package com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.dao.DbDao;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.ui.menu.MenuAdapter;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.ui.menu.MenuList;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.ui.menu.TreeNode;

import java.util.List;

/**
 * Created by Phoenix on 2016/6/24.
 */
public class MenuUtils {
    /**
     * 将position位置的节点展示出来
     *
     * @param position
     */
    public static void showNodeInfo(FragmentManager fragmentManager, MenuAdapter menuAdapter, int position) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        menuAdapter.showNodeInfo(position, transaction);
        transaction.commit();
    }

    /*
    void deepth(BaseNode node, MenuList menuList) {
    // 获取node的主键Key
    String mainKey = node.getKey();
    // 根据node的类型判断进行何种表操作
    if (node instanceOf Benthos) {
        List<BaseNode> nodeList = dao.find...ByFk(mainKey);
        for (BaseNode cNode : nodeList) {
            // 将该节点放入menuList
            menuList.addNode(new TreeNode(node));
            // 递归调用
            deepth(cNode, menuList);
        }
    } else if (node instanceOf ...) {

    } else if (如果节点是最底层节点) {
        return;
    }
}
     */

    /**
     * 利用数据库中查询的数据初始化 menuList
     *
     * @param menuList
     */
    public static void initMenu(Context context, MenuList menuList) {
        DbDao dbDao = new DbDao(context);
        List<BaseNode> monitorSites = dbDao.findMonitorSites();
        for (BaseNode node : monitorSites) {
            menuList.addNode(new TreeNode(node));
            initMenu(context, node, menuList);
        }
    }

    private static void initMenu(Context context, BaseNode node, MenuList menuList) {
        String key = node.getKey();
    }

}
