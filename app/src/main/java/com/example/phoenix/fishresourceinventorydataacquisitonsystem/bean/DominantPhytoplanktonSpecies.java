package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.exceptions.IncompleteFieldException;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class DominantPhytoplanktonSpecies extends BaseNode {
    private String SampleID;
    private String Name;
    private String Photo;
    private float Quality;
    private float Biomass;
    private String ID_Phytoplankton;

    public class Builder {
        private String SampleID;
        private String Name;
        private String Photo;
        private float Quality;
        private float Biomass;
        private String ID_Phytoplankton;

        public Builder() {
        }

        public void id_benthos(String id_benthos) {
            this.ID_Phytoplankton = id_benthos;
        }

        public void bimomass(float biomass) {
            this.Biomass = biomass;
        }

        public void quality(float quality) {
            this.Quality = quality;
        }

        public void photo(String photo) {
            this.Photo = photo;
        }

        public void sampleID(String sampleID) {
            this.SampleID = sampleID;
        }

        public void name(String name) {
            this.Name = name;
        }

        public BaseNode build() throws IncompleteFieldException {
            if (SampleID == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.DOMINANT_PHYTOPLANKTON_SPECIES).append(" : ")
                        .append("field SampleID is null.");
                throw new IncompleteFieldException(error.toString());
            } else if (Name == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.DOMINANT_PHYTOPLANKTON_SPECIES).append(" : ")
                        .append("field Name is null.");
                throw new IncompleteFieldException(error.toString());
            } else if (ID_Phytoplankton == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.DOMINANT_PHYTOPLANKTON_SPECIES).append(" : ")
                        .append("field ID_Phytoplankton is null.");
                throw new IncompleteFieldException(error.toString());
            }
            DominantPhytoplanktonSpecies dbs = new DominantPhytoplanktonSpecies();
            dbs.SampleID = this.SampleID;
            dbs.Name = this.Name;
            dbs.Photo = this.Photo;
            dbs.Quality = this.Quality;
            dbs.Biomass = this.Biomass;
            dbs.ID_Phytoplankton = this.ID_Phytoplankton;
            return dbs;
        }
    }
    @Override
    public boolean isNodeTypeInNextLevel(BaseNode node) {
        return false;
    }

    @Override
    public boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        if (node instanceof WaterLayer || node instanceof Catches || node instanceof CatchTools
                || node instanceof Fishes || node instanceof FishEggs || node instanceof FishRoot) {
            return false;
        }
        return true;
    }
}
