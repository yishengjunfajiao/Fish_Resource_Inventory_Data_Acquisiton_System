package com.example.phoenix.fishresourceinventorydataacquisitonsystem;

import android.test.AndroidTestCase;
import android.util.Log;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.dao.DbDao;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MonitoringSite;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.TimeUtils;

import java.util.List;

/**
 * Created by Phoenix on 2016/7/20.
 */
public class Test extends AndroidTestCase {

    public void testTime() {
        String time = TimeUtils.getTime();
        Log.e("test", TimeUtils.getTime());
    }

    public void testAddMonitor() {
        DbDao dbDao = DbDao.getInstance(getContext());
        dbDao.addNewData(new MonitoringSite(), null);
        Log.e("test", "xx");
    }

    public void testQueryMonitor() {
        DbDao dbDao = DbDao.getInstance(getContext());
//        String s = dbDao.addNewData(new MonitoringSite(), null);
        List<BaseNode> monitorSites = dbDao.findMonitorSites();
        Log.e("test", "queryMonitor");
    }

    public void testQueryFrac() {
        DbDao instance = DbDao.getInstance(getContext());
        List<BaseNode> monitorSites = instance.findMonitorSites();
        BaseNode baseNode = monitorSites.get(0);
        List<BaseNode> fracNodes = instance.findFractureSurfaceByFK(baseNode.getKey());
        Log.e("testQueryFrac", "xx");
    }
}

