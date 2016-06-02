package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.exceptions.IncompleteFieldException;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class Fishes extends BaseNode {
    private String SampleID;
    private String Photo;
    private float BodyLength;
    private float Length;
    private float BodyWeight;
    private float Age;
    private String ID_Catches;

    public class Builder {
        private String SampleID;
        private String Photo;
        private float BodyLength;
        private float Length;
        private float BodyWeight;
        private float Age;
        private String ID_Catches;

        public void sampelID(String sampleID) {
            this.SampleID = sampleID;
        }

        public void photo(String photo) {
            this.Photo = photo;
        }

        public void bodyLength(float bodyLength) {
            this.BodyLength = bodyLength;
        }

        public void lenght(float length) {
            this.Length = length;
        }

        public void bodyWeight(float bodyWeight) {
            this.BodyWeight = bodyWeight;
        }

        public void age(float age) {
            this.Age = age;
        }

        public void id_catches(String id_catches) {
            this.ID_Catches = id_catches;
        }

        public BaseNode build() throws IncompleteFieldException {
            if (SampleID == null) {
                StringBuilder error = new StringBuilder();
                error.append("Table ").append(TableNames.FISHES).append(" : ")
                        .append("field SampleID is null.");
                throw new IncompleteFieldException(error.toString());

            }
            Fishes fishes = new Fishes();
            fishes.SampleID = this.SampleID;
            fishes.Photo = this.Photo;
            fishes.BodyLength = this.BodyLength;
            fishes.Length = this.Length;
            fishes.BodyWeight = this.BodyWeight;
            fishes.Age = this.Age;
            fishes.ID_Catches = this.ID_Catches;
            return fishes;
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
