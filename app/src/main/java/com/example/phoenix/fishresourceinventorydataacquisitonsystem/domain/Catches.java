package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;

/**
 * 渔获物
 * Created by Phoenix on 2016/5/31.
 */
public class Catches extends BaseNode {

    //主键
    private String SampleID = null;
    //鱼类名称
    private String Name = null;
    //图片路径
    private String Photo = null;
    //卵苗总数
    private int TotalQuality;
    //鱼卵总数
    private int EggQuality;
    //幼鱼数
    private int FryQuality;
    //水层外键
    private String ID_WaterLayer = null;

    public int getFryQuality() {
        return FryQuality;
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

    public int getTotalQuality() {
        return TotalQuality;
    }

    public int getEggQuality() {
        return EggQuality;
    }

    public String getID_WaterLayer() {
        return ID_WaterLayer;
    }

    @Override
    public int getLevel() {
        return 6;
    }

    @Override
    public String toString() {
        return TableNames.CATCHES;
    }
}
