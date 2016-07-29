package com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.util.Log;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.dao.DbDao;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Benthos;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Catches;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.DominantZooplanktonSpecies;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.FractureSurface;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MeasuringLine;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MeasuringPoint;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MonitoringSite;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Phytoplankton;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.WaterLayer;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Zooplankton;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.BenthicOrganismFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.CatchFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.DominantSpeciesFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.EggSampleFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.FishSampleFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.FractureSurfaceFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.MeasuringLineFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.MeasuringPointFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.MonitoringSiteFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.NettingGearFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.PhytoplanktonFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.SedimentFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.WaterCourseFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.ZooplanktonFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.base.BaseFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.ui.menu.MenuAdapter;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.ui.menu.MenuList;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.ui.menu.TreeNode;

import java.util.List;

/**
 * Created by Phoenix on 2016/6/24.
 */
public class MenuUtils {
    private static DbDao dbDao = null;

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

    /**
     * 利用数据库中查询的数据初始化 menuList
     *
     * @param menuList
     */
    public static void initMenu(Context context, MenuList menuList, FragmentManager fragmentManager) {
        dbDao = new DbDao(context);
        List<BaseNode> monitorSites = dbDao.findMonitorSites();
        for (BaseNode node : monitorSites) {
            TreeNode treeNode = new TreeNode(node);
            BaseFragment fragment = new MonitoringSiteFragment(node);
            fragmentManager.beginTransaction().add(R.id.app_main_content, fragment).commit();
            treeNode.setFragment(fragment);
            menuList.addNode(treeNode);
            initMenu(context, node, menuList, fragmentManager);
        }
    }

    private static void initMenu(Context context, BaseNode node, MenuList menuList, FragmentManager fragmentManager) {
        // 获取节点的主键
        String key = node.getKey();
        Log.e("initMenu", key);
        // 对node类型进行判断
        if (node instanceof MonitoringSite) {
            List<BaseNode> nodes = dbDao.findFractureSurfaceByFK(key);
            for (BaseNode anode : nodes) {
                TreeNode treeNode = new TreeNode(anode);
                BaseFragment fragment = new FractureSurfaceFragment(anode);
                fragmentManager.beginTransaction().add(R.id.app_main_content, fragment).commit();
                treeNode.setFragment(fragment);
                menuList.addNode(treeNode);
                initMenu(context, anode, menuList, fragmentManager);
            }
        } else if (node instanceof FractureSurface) {
            List<BaseNode> mnodes = dbDao.findMeasuringLineByFK(key);
            for (BaseNode anode : mnodes) {
                TreeNode treeNode = new TreeNode(anode);
                BaseFragment fragment = new MeasuringLineFragment(anode);
                fragmentManager.beginTransaction().add(R.id.app_main_content, fragment).commit();
                treeNode.setFragment(fragment);
                menuList.addNode(treeNode);
                initMenu(context, anode, menuList, fragmentManager);
            }
            List<BaseNode> snodes = dbDao.findSedimentByFK(key);
            for (BaseNode anode : snodes) {
                TreeNode treeNode = new TreeNode(anode);
                BaseFragment fragment = new SedimentFragment(anode);
                fragmentManager.beginTransaction().add(R.id.app_main_content, fragment).commit();
                treeNode.setFragment(fragment);
                menuList.addNode(treeNode);
                initMenu(context, anode, menuList, fragmentManager);
            }
            List<BaseNode> znodes = dbDao.findZooplanktonByFK(key);
            for (BaseNode anode : znodes) {
                TreeNode treeNode = new TreeNode(anode);
                BaseFragment fragment = new ZooplanktonFragment(anode);
                fragmentManager.beginTransaction().add(R.id.app_main_content, fragment).commit();
                treeNode.setFragment(fragment);
                menuList.addNode(treeNode);
                initMenu(context, anode, menuList, fragmentManager);
            }
            List<BaseNode> pnodes = dbDao.findPhytoplanktonByFK(key);
            for (BaseNode anode : pnodes) {
                TreeNode treeNode = new TreeNode(anode);
                BaseFragment fragment = new PhytoplanktonFragment(anode);
                fragmentManager.beginTransaction().add(R.id.app_main_content, fragment).commit();
                treeNode.setFragment(fragment);
                menuList.addNode(treeNode);
                initMenu(context, anode, menuList, fragmentManager);
            }
            List<BaseNode> bnodes = dbDao.findBenthosByFK(key);
            for (BaseNode anode : pnodes) {
                TreeNode treeNode = new TreeNode(anode);
                BaseFragment fragment = new BenthicOrganismFragment(anode);
                fragmentManager.beginTransaction().add(R.id.app_main_content, fragment).commit();
                treeNode.setFragment(fragment);
                menuList.addNode(treeNode);
                initMenu(context, anode, menuList, fragmentManager);
            }
        } else if (node instanceof MeasuringLine) {
            List<BaseNode> mpnodes = dbDao.findMeasuringPointByFK(key);
            for (BaseNode anode : mpnodes) {
                TreeNode treeNode = new TreeNode(anode);
                BaseFragment fragment = new MeasuringPointFragment(anode);
                fragmentManager.beginTransaction().add(R.id.app_main_content, fragment).commit();
                treeNode.setFragment(fragment);
                menuList.addNode(treeNode);
                initMenu(context, anode, menuList, fragmentManager);
            }
        } else if (node instanceof MeasuringPoint) {
            List<BaseNode> wlNodes = dbDao.findWaterLayerByFk(key);
            for (BaseNode anode : wlNodes) {
                TreeNode treeNode = new TreeNode(anode);
                BaseFragment fragment = new WaterCourseFragment(anode);
                fragmentManager.beginTransaction().add(R.id.app_main_content, fragment).commit();
                treeNode.setFragment(fragment);
                menuList.addNode(treeNode);
                initMenu(context, anode, menuList, fragmentManager);
            }
        } else if (node instanceof Zooplankton) {
            List<BaseNode> dzsNodes = dbDao.findDominantZooplanktonSpeciesByFk(key);
            for (BaseNode anode : dzsNodes) {
                TreeNode treeNode = new TreeNode(anode);
                BaseFragment fragment = new DominantSpeciesFragment(anode);
                fragmentManager.beginTransaction().add(R.id.app_main_content, fragment).commit();
                treeNode.setFragment(fragment);
                menuList.addNode(treeNode);
                initMenu(context, anode, menuList, fragmentManager);
            }
        } else if (node instanceof Phytoplankton) {
            List<BaseNode> dzsNodes = dbDao.findDominantPhytoplanktonByFk(key);
            for (BaseNode anode : dzsNodes) {
                TreeNode treeNode = new TreeNode(anode);
                BaseFragment fragment = new DominantSpeciesFragment(anode);
                fragmentManager.beginTransaction().add(R.id.app_main_content, fragment).commit();
                treeNode.setFragment(fragment);
                menuList.addNode(treeNode);
                initMenu(context, anode, menuList, fragmentManager);
            }
        } else if (node instanceof Benthos) {
            List<BaseNode> dzsNodes = dbDao.findDominantBenthosByFk(key);
            for (BaseNode anode : dzsNodes) {
                TreeNode treeNode = new TreeNode(anode);
                BaseFragment fragment = new DominantSpeciesFragment(anode);
                fragmentManager.beginTransaction().add(R.id.app_main_content, fragment).commit();
                treeNode.setFragment(fragment);
                menuList.addNode(treeNode);
                initMenu(context, anode, menuList, fragmentManager);
            }
        } else if (node instanceof WaterLayer) {
            List<BaseNode> cth = dbDao.findCatchesByFK(key);
            for (BaseNode anode : cth) {
                TreeNode treeNode = new TreeNode(anode);
                BaseFragment fragment = new CatchFragment(anode);
                fragmentManager.beginTransaction().add(R.id.app_main_content, fragment).commit();
                treeNode.setFragment(fragment);
                menuList.addNode(treeNode);
                initMenu(context, anode, menuList, fragmentManager);
            }
            List<BaseNode> ct = dbDao.findCatchToolsByFK(key);
            for (BaseNode anode : cth) {
                TreeNode treeNode = new TreeNode(anode);
                BaseFragment fragment = new NettingGearFragment(anode);
                fragmentManager.beginTransaction().add(R.id.app_main_content, fragment).commit();
                treeNode.setFragment(fragment);
                menuList.addNode(treeNode);
                initMenu(context, anode, menuList, fragmentManager);
            }
        } else if (node instanceof Catches) {
            List<BaseNode> fs = dbDao.findFishesByFK(key);
            for (BaseNode anode : fs) {
                TreeNode treeNode = new TreeNode(anode);
                BaseFragment fragment = new FishSampleFragment(anode);
                fragmentManager.beginTransaction().add(R.id.app_main_content, fragment).commit();
                treeNode.setFragment(fragment);
                menuList.addNode(treeNode);
                initMenu(context, anode, menuList, fragmentManager);
            }
            List<BaseNode> fes = dbDao.findFishEggsByFK(key);
            for (BaseNode anode : fes) {
                TreeNode treeNode = new TreeNode(anode);
                BaseFragment fragment = new EggSampleFragment(anode);
                fragmentManager.beginTransaction().add(R.id.app_main_content, fragment).commit();
                treeNode.setFragment(fragment);
                menuList.addNode(treeNode);
                initMenu(context, anode, menuList, fragmentManager);
            }
        }
    }
}
