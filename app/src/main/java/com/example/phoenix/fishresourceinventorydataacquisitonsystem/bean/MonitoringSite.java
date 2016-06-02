package com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.exceptions.IncompleteFieldException;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class MonitoringSite extends BaseNode {
    private String InverstigationID;
    private String Institution;
    private String Investigator;
    private String InvestigationDate;
    private String Site;
    private String River;
    private String Photo;
    private String StartTime;
    private String EndTime;
    private float StartLongitude;
    private float StartLatitude;
    private float EndLongitude;
    private float EndLatitude;
    private String Weather;
    private float Temperature;

    public class Builder {
        private String InverstigationID;
        private String Institution;
        private String Investigator;
        private String InvestigationDate;
        private String Site;
        private String River;
        private String Photo;
        private String StartTime;
        private String EndTime;
        private float StartLongitude;
        private float StartLatitude;
        private float EndLongitude;
        private float EndLatitude;
        private String Weather;

        public void setTemperature(float temperature) {
            Temperature = temperature;
        }

        public void setInverstigationID(String inverstigationID) {
            InverstigationID = inverstigationID;
        }

        public void setInstitution(String institution) {
            Institution = institution;
        }

        public void setInvestigator(String investigator) {
            Investigator = investigator;
        }

        public void setInvestigationDate(String investigationDate) {
            InvestigationDate = investigationDate;
        }

        public void setSite(String site) {
            Site = site;
        }

        public void setRiver(String river) {
            River = river;
        }

        public void setPhoto(String photo) {
            Photo = photo;
        }

        public void setStartTime(String startTime) {
            StartTime = startTime;
        }

        public void setEndTime(String endTime) {
            EndTime = endTime;
        }

        public void setStartLongitude(float startLongitude) {
            StartLongitude = startLongitude;
        }

        public void setStartLatitude(float startLatitude) {
            StartLatitude = startLatitude;
        }

        public void setEndLongitude(float endLongitude) {
            EndLongitude = endLongitude;
        }

        public void setEndLatitude(float endLatitude) {
            EndLatitude = endLatitude;
        }

        public void setWeather(String weather) {
            Weather = weather;
        }

        private float Temperature;

        public BaseNode build() throws IncompleteFieldException {
            if (InverstigationID == null) {
                if (InverstigationID == null) {
                    StringBuilder error = new StringBuilder();
                    error.append("Table ").append(TableNames.MONITORING_SITE).append(" : ")
                            .append("field InverstigationID is null.");
                    throw new IncompleteFieldException(error.toString());
                }
            }
            MonitoringSite ms = new MonitoringSite();
            ms.InverstigationID = this.InverstigationID;
            ms.Institution = this.Institution;
            ms.InvestigationDate = this.InvestigationDate;
            ms.Site = this.Site;
            ms.River = this.River;
            ms.Photo = this.Photo;
            ms.StartTime = this.StartTime;
            ms.EndTime = this.EndTime;
            ms.StartLongitude = this.StartLongitude;
            ms.StartLatitude = this.StartLatitude;
            ms.EndLongitude = this.EndLongitude;
            ms.EndLatitude = this.EndLatitude;
            ms.Weather = this.Weather;
            ms.Temperature = this.Temperature;
            return ms;
        }

    }

    @Override
    public String toString() {
        return "MonitoringSite";
    }

    public MonitoringSite() {
        super();
        this.isShown = true;
    }

    @Override
    public boolean isNodeTypeInNextLevel(BaseNode node) {
        if (node instanceof FractureSurface) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isNodeTypeInParallelOrHigherLevel(BaseNode node) {
        if (node instanceof MonitoringSite || node instanceof FishRoot) {
            return true;
        }
        return false;
    }
}
