package com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.ui.menu.MenuAdapter;

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

}
