package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.exceptions.IncompleteFieldException;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class FishEggs extends BaseNode {

    private String SampleID;
    private String Photo;
    private String Period;
    private float Diameter;
    private float EMDiameter;
    private String PigmentProp;
    private String EmbryoProp;
    private String ID_Catches;

    public class Builder {
        private String SampleID;
        private String Photo;
        private String Period;
        private float Diameter;
        private float EMDiameter;
        private String PigmentProp;
        private String EmbryoProp;
        private String ID_Catches;

        public Builder() {
        }

        public void sampleID(String sampelID) {
            this.SampleID = sampelID;
        }

        public void photo(String photo) {
            this.Photo = photo;
        }

        public void period(String period) {
            this.Period = period;
        }

        public void diameter(float diameter) {
            this.Diameter = diameter;
        }

        ;

        public void emdDiameter(float emdDiameter) {
            this.EMDiameter = emdDiameter;
        }

        public void pigmentProp(String pigmentProp) {
            this.PigmentProp = pigmentProp;
        }

        public void embryoProp(String embryoProp) {
            this.EmbryoProp = embryoProp;
        }

        public void id_catches(String id_catches) {
            this.ID_Catches = id_catches;
        }

        public BaseNode build() throws IncompleteFieldException {
            if (SampleID == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.FISH_EGGS).append(" : ")
                        .append("field SampleID is null.");
                throw new IncompleteFieldException(error.toString());
            }
            FishEggs fe = new FishEggs();
            fe.SampleID = this.SampleID;
            fe.Photo = this.Photo;
            fe.Period = this.Period;
            fe.Diameter = this.Diameter;
            fe.EMDiameter = this.EMDiameter;
            fe.PigmentProp = this.PigmentProp;
            fe.EmbryoProp = this.EmbryoProp;
            fe.ID_Catches = this.ID_Catches;
            return fe;
        }
    }

    @Override
    public boolean isNodeTypeInNextLevel(BaseNode node) {
        return false;
    }

    @Override
    public boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        return true;
    }
}
