package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.exceptions.IncompleteFieldException;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class MeasuringLine extends BaseNode {
    private String ID;
    private float StartLongitude;
    private float StartLatitude;
    private float EndLongitude;
    private float EndLatitude;
    private String ID_FractureSurface;
    public class Builder {
        private String ID;
        private float StartLongitude;
        private float StartLatitude;
        private float EndLongitude;
        private float EndLatitude;
        private String ID_FractureSurface;
        public Builder(){}
        public void id(String id) {
            this.ID = id;
        }
        public void startLongitude(float startLongitude) {this.StartLatitude = startLongitude;}
        public void startLatitude(float startLatitude) {this.StartLatitude = startLatitude;}
        public void endLongitude(float endLongitude) {this.EndLongitude = endLongitude;};
        public void endLatitude(float endLatitude) {this.EndLatitude = endLatitude;}
        public void id_fractureSurface(String id_fractureSurface) {this.ID_FractureSurface = id_fractureSurface;}
        public BaseNode build() throws IncompleteFieldException {
            if (ID == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.MEASURING_LINE).append(" : ")
                        .append("field ID is null.");
                throw new IncompleteFieldException(error.toString());
            }
            MeasuringLine fe = new MeasuringLine();
            fe.ID = this.ID;
            fe.StartLongitude = this.StartLongitude;
            fe.StartLatitude = this.StartLatitude;
            fe.EndLongitude = this.EndLongitude;
            fe.EndLatitude = this.EndLatitude;
            fe.ID_FractureSurface = this.ID_FractureSurface;
            return fe;
        }
    }

    @Override
    public String toString() {
        return "MeasuringLine";
    }

    @Override
    public boolean isNodeTypeInNextLevel(BaseNode node) {
        if (node instanceof MeasuringPoint) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        if (node instanceof Phytoplankton || node instanceof Zooplankton || node instanceof Sediment || node instanceof MeasuringLine
                || node instanceof Benthos) {
            return true;
        } else if (node instanceof MonitoringSite || node instanceof FractureSurface || node instanceof FishRoot) {
            return true;
        }
        return false;
    }
}
