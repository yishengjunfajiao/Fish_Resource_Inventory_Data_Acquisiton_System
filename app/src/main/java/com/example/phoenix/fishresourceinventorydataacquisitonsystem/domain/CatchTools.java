package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class CatchTools extends BaseNode {
    //CatchTools主键
    private String SampleID;
    //网具名字
    private String Name;
    //照片路径，多个路径用分号隔开
    private String Photo;
    //网型
    private String NetsModel;
    //网口面积
    private float NetMouthArea;
    //网口倾角
    private float NetMouthDip;
    //开始时间
    private String StartTime;
    //结束时间
    private String EndTime;
    //网口流速
    private float NetMouthVelocity;

    public float getNetMouthVelocity() {
        return NetMouthVelocity;
    }

    public String getSampleID() {
        return SampleID;
    }

    public String getName() {
        return Name;
    }

    public String getPhoto() {
        return Photo;
    }

    public String getNetsModel() {
        return NetsModel;
    }

    public float getNetMouthArea() {
        return NetMouthArea;
    }

    public float getNetMouthDip() {
        return NetMouthDip;
    }

    public String getStartTime() {
        return StartTime;
    }


    @Override
    public String toString() {
        return TableNames.CATCH_TOOLS;
    }

    @Override
    public int getLevel() {
        return CreatureLevels.CATCH_TOOLS;
    }

}
