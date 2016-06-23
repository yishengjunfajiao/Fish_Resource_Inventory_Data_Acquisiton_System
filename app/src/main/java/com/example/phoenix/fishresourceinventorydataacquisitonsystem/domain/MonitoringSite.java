package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class MonitoringSite extends BaseNode {
    private String InverstigationID;
    private String Institution;
    private String Investigator;
    private String InvestigationDate;
    private String Site;
    private String River;
    private String Photo;
    private String StartTime;
    private String EndTime;
    private float StartLongitude;
    private float StartLatitude;
    private float EndLongitude;
    private float EndLatitude;
    private String Weather;
    private float Temperature;


    @Override
    public String toString() {
        return TableNames.MONITORING_SITE;
    }

    public MonitoringSite() {
        super();
    }

    @Override
    public int getLevel() {
        return CreatureLevels.MONITORING_SITE;
    }

}
