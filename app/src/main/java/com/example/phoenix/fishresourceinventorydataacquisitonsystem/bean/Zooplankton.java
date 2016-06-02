package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.exceptions.IncompleteFieldException;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class Zooplankton extends BaseNode {

    private String SampleID;
    private String Photo;
    private float Quality;
    private float Biomass;

    public String getID_FractureSurface() {
        return ID_FractureSurface;
    }

    public String getSampleID() {
        return SampleID;
    }

    public String getPhoto() {
        return Photo;
    }

    public float getQuality() {
        return Quality;
    }

    public float getBiomass() {
        return Biomass;
    }

    private String ID_FractureSurface;

    public class Builder {
        private String SampleID;
        private String Photo;
        private float Quality;
        private float Biomass;

        public BaseNode build() throws IncompleteFieldException {
            if (SampleID == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.ZOOPLANKTON).append(" : ")
                        .append("field SampleID is null.");
                throw new IncompleteFieldException(error.toString());
            }
            Zooplankton zoop = new Zooplankton();
            zoop.SampleID = this.SampleID;
            zoop.Photo = this.Photo;
            zoop.Quality = this.Quality;
            zoop.Biomass = this.Biomass;
            zoop.ID_FractureSurface = this.ID_FractureSurface;
            return zoop;
        }

        public void setID_FractureSurface(String ID_FractureSurface) {
            this.ID_FractureSurface = ID_FractureSurface;
        }

        public void setSampleID(String sampleID) {
            SampleID = sampleID;
        }

        public void setPhoto(String photo) {
            Photo = photo;
        }

        public void setQuality(float quality) {
            Quality = quality;
        }

        public void setBiomass(float biomass) {
            Biomass = biomass;
        }

        private String ID_FractureSurface;

        public Builder() {
        }
    }

    @Override
    public boolean isNodeTypeInNextLevel(BaseNode node) {
        if (node instanceof DominantZooplanktonSpecies) {
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
