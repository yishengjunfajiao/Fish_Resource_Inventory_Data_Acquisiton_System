package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.exceptions.IncompleteFieldException;

/**
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
    public String toString() {
        return "Catches";
    }

    @Override
    public boolean isNodeTypeInNextLevel(BaseNode node) {
        if (node instanceof FishEggs || node instanceof Fishes) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        if (!(node instanceof Fishes) && !(node instanceof FishEggs)) {
            return true;
        }
        return false;
    }

    public class Builder {
        private String SampleID;
        private String Name;
        private String Photo;
        private int TotalQuality;
        private int EggQuality;
        private int FryQuality;
        private String ID_WaterLayer;

        public void sampleID(String sampleID) {
            this.SampleID = sampleID;
        }

        public void name(String name) {
            this.Name = name;
        }

        public void photo(String photo) {
            this.Photo = photo;
        }

        public void totalQuality(int totalQuality) {
            this.TotalQuality = totalQuality;
        }

        public void eggQuality(int eggQuality) {
            this.EggQuality = eggQuality;
        }

        public void fryQuality(int fryQuality) {
            this.FryQuality = fryQuality;
        }

        public void id_waterLayer(String id_waterLayer) {
            this.ID_WaterLayer = id_waterLayer;
        }

        public BaseNode build() throws IncompleteFieldException {
            if (SampleID == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.CATCHES).append(" : ")
                        .append("field SampleID is null.");
                throw new IncompleteFieldException(error.toString());
            } else if (Name == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.CATCHES).append(" : ")
                        .append("field Name is null.");
                throw new IncompleteFieldException(error.toString());
            } else if (ID_WaterLayer == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.CATCHES).append(" : ")
                        .append("field ID_WaterLayer is null.");
                throw new IncompleteFieldException(error.toString());
            }
            Catches catches = new Catches();
            catches.SampleID = this.SampleID;
            catches.Name = this.Name;
            catches.Photo = this.Photo;
            catches.TotalQuality = this.TotalQuality;
            catches.EggQuality = this.EggQuality;
            catches.FryQuality = this.FryQuality;
            catches.ID_WaterLayer = this.ID_WaterLayer;
            return catches;
        }
    }

}
