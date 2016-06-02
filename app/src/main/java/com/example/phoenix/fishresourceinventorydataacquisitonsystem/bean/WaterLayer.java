package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.exceptions.IncompleteFieldException;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class WaterLayer extends BaseNode {
    private String ID;
    private String Layer;
    private float Depth;
    private float Temperature;
    private float WaterLevel;
    private float Velocity;
    private String ID_MeasuringPoint;

    public class Builder {
        private String ID;
        private String Layer;

        public void setDepth(float depth) {
            Depth = depth;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public void setLayer(String layer) {
            Layer = layer;
        }

        public void setTemperature(float temperature) {
            Temperature = temperature;
        }

        public void setWaterLevel(float waterLevel) {
            WaterLevel = waterLevel;
        }

        public void setVelocity(float velocity) {
            Velocity = velocity;
        }

        public void setID_MeasuringPoint(String ID_MeasuringPoint) {
            this.ID_MeasuringPoint = ID_MeasuringPoint;
        }

        private float Depth;
        private float Temperature;
        private float WaterLevel;
        private float Velocity;
        private String ID_MeasuringPoint;

        public BaseNode build() throws IncompleteFieldException {
            if (ID == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.WATER_LAYER).append(" : ")
                        .append("field ID is null.");
                throw new IncompleteFieldException(error.toString());
            }
            WaterLayer wl = new WaterLayer();
            wl.ID = this.ID;
            wl.Layer = this.Layer;
            wl.Depth = this.Depth;
            wl.Temperature = this.Temperature;
            wl.WaterLevel = this.WaterLevel;
            wl.Velocity = this.Velocity;
            wl.ID_MeasuringPoint = this.ID_MeasuringPoint;
            return wl;
        }

    }

    @Override
    public String toString() {
        return "WaterLayer";
    }

    @Override
    public boolean isNodeTypeInNextLevel(BaseNode node) {
        if (node instanceof Catches || node instanceof CatchTools) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        if (!(node instanceof CatchTools) && !(node instanceof Catches)
                && !(node instanceof Fishes) && !(node instanceof FishEggs)) {
            return true;
        }
        return false;
    }
}
