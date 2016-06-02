package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.exceptions.IncompleteFieldException;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class Sediment extends BaseNode {

    public String getSampleID() {
        return SampleID;
    }

    public String getPhoto() {
        return Photo;
    }

    private String SampleID;
    private String Photo;

    public class Builder {
        public void setSampleID(String sampleID) {
            SampleID = sampleID;
        }

        public void setPhoto(String photo) {
            Photo = photo;
        }

        private String SampleID;
        private String Photo;

        public BaseNode build() throws IncompleteFieldException {
            if (SampleID == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.SEDIMENT).append(" : ")
                        .append("field SampleID is null.");
                throw new IncompleteFieldException(error.toString());
            }
            Sediment sediment = new Sediment();
            sediment.SampleID = this.SampleID;
            sediment.Photo = this.Photo;
            return sediment;
        }
        public Builder() {
        }
    }

    @Override
    public String toString() {
        return "Sediment";
    }

    @Override
    public boolean isNodeTypeInNextLevel(BaseNode node) {
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
