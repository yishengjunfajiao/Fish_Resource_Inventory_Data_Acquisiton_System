package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import android.test.suitebuilder.annotation.SmallTest;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.exceptions.IncompleteFieldException;

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

    public class Builder {
        private String SampleID;
        private String Name;
        private String Photo;
        private String NetsModel;
        private float NetMouthArea;
        private float NetMouthDip;
        private String StartTime;
        private String EndTime;
        private float NetMouthVelocity;

        public void sampleID(String sampleID) {
            this.SampleID = sampleID;
        }

        public void photo(String photo) {
            this.Photo = photo;
        }

        public void name(String name) {
            this.Name = name;
        }

        public void netsModel(String netsModel) {
            this.NetsModel = netsModel;
        }

        public void netMouthArea(float netMouthArea) {
            this.NetMouthArea = netMouthArea;
        }

        public void netMouthDip(float netMouthDip) {
            this.NetMouthDip = netMouthDip;
        }

        public void startTime(String startTime) {
            this.StartTime = startTime;
        }

        public void endTime(String endTime) {
            this.EndTime = endTime;
        }

        public void netMouthVelocity(float netMouthVelocity) {
            this.NetMouthVelocity = netMouthVelocity;
        }

        public BaseNode build() throws IncompleteFieldException {
            if (SampleID == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.CATCH_TOOLS).append(" : ")
                        .append("field SampleID is null.");
                throw new IncompleteFieldException(error.toString());
            } else if (NetsModel == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.CATCH_TOOLS).append(" : ")
                        .append("field NetsModel is null.");
                throw new IncompleteFieldException(error.toString());
            }
            CatchTools catchTools = new CatchTools();
            catchTools.SampleID = this.SampleID;
            catchTools.Photo = this.Photo;
            catchTools.NetsModel = this.NetsModel;
            catchTools.NetMouthArea = this.NetMouthArea;
            catchTools.NetMouthDip = this.NetMouthDip;
            catchTools.StartTime = this.StartTime;
            catchTools.EndTime = this.SampleID;
            catchTools.SampleID = this.SampleID;
            return catchTools;
        }
    }

    @Override
    public String toString() {
        return "CatchTools";
    }

    @Override
    public boolean isNodeTypeInNextLevel(BaseNode node) {
        return false;
    }

    @Override
    public boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        if (node instanceof FishEggs || node instanceof Fishes) {
            return false;
        }
        return true;
    }
}
