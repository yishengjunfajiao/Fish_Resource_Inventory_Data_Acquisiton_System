package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.exceptions.IncompleteFieldException;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class MeasuringPoint extends BaseNode {
    public String ID;
    public float Longitude;
    public float Latitude;
    public String ID_MeasuringLine;
    public class Builder {
        public String ID;
        public float Longitude;
        public float Latitude;
        public String ID_MeasuringLine;
        public Builder(){}
        public void id(String id) {this.ID = id;}
        public void longitude(float longitude) {this.Longitude = longitude;}
        public void latitude(float latitude) {this.Latitude = latitude;}
        public void id_measuringLine(String id_measuringLine) {this.ID_MeasuringLine = id_measuringLine;}
        public BaseNode build() throws IncompleteFieldException {
            if (ID == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.MEASURING_POINT).append(" : ")
                        .append("field ID is null.");
                throw new IncompleteFieldException(error.toString());
            }
            MeasuringPoint fe = new MeasuringPoint();
            fe.ID = this.ID;
            fe.Longitude = this.Longitude;
            fe.Latitude = this.Latitude;
            fe.ID_MeasuringLine = this.ID_MeasuringLine;
            return fe;
        }

    }
    @Override
    public String toString() {
        return "MeasuringPoint";
    }

    @Override
    public boolean isNodeTypeInNextLevel(BaseNode node) {
        if (node instanceof WaterLayer) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        if (!(node instanceof WaterLayer) && !(node instanceof Catches) && !(node instanceof CatchTools)
                && !(node instanceof Fishes) && !(node instanceof FishEggs)) {
            return true;
        }
        return false;
    }
}
