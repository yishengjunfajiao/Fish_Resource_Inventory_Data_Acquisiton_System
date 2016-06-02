package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.exceptions.IncompleteFieldException;

/**
 * 底栖生物
 * Created by Phoenix on 2016/5/31.
 */
public class Benthos extends BaseNode {

    public String getSampleID() {
        return SampleID;
    }

    public String getPhoto() {
        return Photo;
    }

    public int getQuality() {
        return Quality;
    }

    public int getBiomass() {
        return Biomass;
    }

    public String getID_FractureSurface() {
        return ID_FractureSurface;
    }

    //地栖生物主键
    private String SampleID = null;
    //照片路径
    private String Photo = null;
    //数量
    private int Quality = 0;
    //生物量
    private int Biomass = 0;
    //断面外键
    private String ID_FractureSurface = null;

    public class Builder {
        private String SampleID = null;
        private String Photo = null;
        private int Quality = 0;
        private int Biomass = 0;
        private String ID_FractureSurface = null;

        public Builder() {
        }

        public void id_fractureSurface(String id_fractureSurface) {
            this.ID_FractureSurface = id_fractureSurface;
        }

        public void sampleID(String sampleID) {
            this.SampleID = sampleID;
        }

        public void photo(String photo) {
            this.Photo = photo;
        }

        public void quality(int quality) {
            this.Quality = quality;
        }

        public void biomass(int biomass) {
            this.Biomass = biomass;
        }

        public BaseNode build() throws IncompleteFieldException {
            if (this.SampleID == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.BENTHOS).append(" : ")
                        .append("field SampleID is null.");
                throw new IncompleteFieldException(error.toString());
            } else if (ID_FractureSurface == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.BENTHOS).append(" : ")
                        .append("field ID_FractureSurface is null.");
                throw new IncompleteFieldException(error.toString());
            }
            Benthos benthos = new Benthos();
            benthos.SampleID = this.SampleID;
            benthos.Photo = this.Photo;
            benthos.Quality = this.Quality;
            benthos.Biomass = this.Biomass;
            benthos.ID_FractureSurface = this.ID_FractureSurface;
            return benthos;
        }
    }

    @Override
    public String toString() {
        return "Benthos";
    }

    @Override
    public boolean isNodeTypeInNextLevel(BaseNode node) {
        if (node instanceof DominantBenthosSpecies) {
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
