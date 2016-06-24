package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain;


import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.CreatureLevels;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class MonitoringSite extends BaseNode {
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

    public void setTemperature(float temperature) {
        Temperature = temperature;
    }

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


    @Override
    public String toString() {
        return TableNames.MONITORING_SITE;
    }

    public MonitoringSite() {
        super();
    }

    @Override
    public int getLevel() {
        return CreatureLevels.MONITORING_SITE;
    }

}
