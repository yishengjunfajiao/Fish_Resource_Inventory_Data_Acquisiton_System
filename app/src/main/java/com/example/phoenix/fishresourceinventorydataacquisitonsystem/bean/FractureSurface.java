package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.exceptions.IncompleteFieldException;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class FractureSurface extends BaseNode {

    private String ID;
    private String Position;
    private float Distance2Bank;
    private String ID_MonitoringSite;

    public class Builder {
        private String ID;
        private String Position;
        private float Distance2Bank;
        private String ID_MonitoringSite;

        public Builder() {
        }

        public void id(String id) {
            this.ID = id;
        }

        public void position(String position) {
            Position = position;
        }

        public void distance2Bank(float distance2Bank) {
            Distance2Bank = distance2Bank;
        }

        public void id_monitoringSite(String id_monitoringSite) {
            this.ID_MonitoringSite = id_monitoringSite;
        }

        public BaseNode build() throws IncompleteFieldException {
            if (ID == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.FRACTURE_SURFACE).append(" : ")
                        .append("field ID is null.");
                throw new IncompleteFieldException(error.toString());
            }
            FractureSurface fs = new FractureSurface();
            fs.ID = this.ID;
            fs.Position = this.Position;
            fs.Distance2Bank = this.Distance2Bank;
            fs.ID_MonitoringSite = this.ID_MonitoringSite;
            return fs;
        }
    }

    @Override
    public String toString() {
        return "FractureSurface";
    }

    @Override
    public boolean isNodeTypeInNextLevel(BaseNode node) {
        if (node instanceof MeasuringLine || node instanceof Sediment ||
                node instanceof Zooplankton || node instanceof Phytoplankton || node instanceof Benthos) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        if (node instanceof FractureSurface || node instanceof MonitoringSite || node instanceof FishRoot) {
            return true;
        }
        return false;
    }
}
