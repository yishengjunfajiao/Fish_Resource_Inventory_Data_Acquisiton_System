package com.example.phoenix.fishresourceinventorydataacquisitonsystem.db;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class CreateSQLs {

    //use FishCat;
    /*public final static String CREATE_MONITOR_SITE = "CREATE TABLE MonitoringSite ("
           + "InverstigationID VARCHAR(17) PRIMARY KEY,"
           + "Institution VARCHAR(60) NOT NULL,"
           + "Investigator     VARCHAR(40) NOT NULL,"
           + "InvestigationDate SMALLDATETIME NOT NULL,"
           + "Site VARCHAR(200) NOT NULL,"
           + "River VARCHAR(20) NOT NULL,"
           + "Photo VARCHAR(50),"
           + "StartTime SMALLDATETIME,"
           + "EndTime SMALLDATETIME,"
           + "StartLongitude NUMERIC(13,9),"
           + "StartLatitude NUMERIC(13,9),"
           + "EndLongitude NUMERIC(13,9),"
           + "EndLatitude NUMERIC(13,9),"
           + "Weather VARCHAR(4),"
           + "Temperature NUMERIC(4,2))";*/
    public final static String CREATE_MONITOR_SITE = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.MONITORING_SITE)
            .append(" (")
            .append("InverstigationID VARCHAR(17) PRIMARY KEY,")
            .append("Institution VARCHAR(60) NOT NULL,")
            .append("Investigator     VARCHAR(40) NOT NULL,")
            .append("InvestigationDate SMALLDATETIME NOT NULL,")
            .append("Site VARCHAR(200) NOT NULL,")
            .append("River VARCHAR(20) NOT NULL,")
            .append("Photo VARCHAR(50),")
            .append("StartTime SMALLDATETIME,")
            .append("EndTime SMALLDATETIME,")
            .append("StartLongitude NUMERIC(13,9),")
            .append("StartLatitude NUMERIC(13,9),")
            .append("EndLongitude NUMERIC(13,9),")
            .append("EndLatitude NUMERIC(13,9),")
            .append("Weather VARCHAR(4),")
            .append("Temperature NUMERIC(4,2))")
            .toString();

    /*public final static String CREATE_FRACTURE_SURFACE = "CREATE TABLE FractureSurface ("
            + "ID VARCHAR(15) PRIMARY KEY,"
            + "Position VARCHAR(2) NOT NULL,"
            + "Distance2Bank NUMERIC(10),"
            + "ID_MonitoringSite VARCHAR(17),"
            + "FOREIGN KEY (ID_MonitoringSite) REFERENCES MonitoringSite(InverstigationID))";*/
    public final static String CREATE_FRACTURE_SURFACE = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.FRACTURE_SURFACE)
            .append(" (")
            .append("ID VARCHAR(15) PRIMARY KEY,")
            .append("Position VARCHAR(2) NOT NULL,")
            .append("Distance2Bank NUMERIC(10),")
            .append("ID_MonitoringSite VARCHAR(17),")
            .append("FOREIGN KEY (ID_MonitoringSite) REFERENCES ").append(TableNames.MONITORING_SITE).append("(InverstigationID))")
            .toString();

    /*public final static String CREATE_PHYTOPLANKTON = "CREATE TABLE Phytoplankton("
            + "SampleID VARCHAR(17) PRIMARY KEY,"
            + "Photo VARCHAR(50),"
            + "Quality NUMERIC(10),"
            + "Biomass NUMERIC(5,1),"
            + "ID_FractureSurface VARCHAR(15),"
            + "FOREIGN KEY (ID_FractureSurface) REFERENCES FractureSurface(ID))";*/
    public final static String CREATE_PHYTOPLANKTON = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.PHYTOPLANKTON)
            .append(" (")
            .append("SampleID VARCHAR(17) PRIMARY KEY,")
            .append("Photo VARCHAR(50),")
            .append("Quality NUMERIC(10),")
            .append("Biomass NUMERIC(5,1),")
            .append("ID_FractureSurface VARCHAR(15),")
            .append("FOREIGN KEY (ID_FractureSurface) REFERENCES ").append(TableNames.FRACTURE_SURFACE).append("(ID))")
            .toString();

    /*public final static String CREATE_ZOOPLANKTON = "CREATE TABLE Zooplankton ("
            + "SampleID VARCHAR(17) PRIMARY KEY,"
            + "Photo VARCHAR(50),"
            + "Quality NUMERIC(10),"
            + "Biomass NUMERIC(10),"
            + "ID_FractureSurface VARCHAR(15),"
            + "FOREIGN KEY (ID_FractureSurface) REFERENCES FractureSurface(ID))";*/
    public final static String CREATE_ZOOPLANKTON = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.ZOOPLANKTON)
            .append(" (")
            .append("SampleID VARCHAR(17) PRIMARY KEY,")
            .append("Photo VARCHAR(50),")
            .append("Quality NUMERIC(10),")
            .append("Biomass NUMERIC(10),")
            .append("ID_FractureSurface VARCHAR(15),")
            .append("FOREIGN KEY (ID_FractureSurface) REFERENCES ").append(TableNames.FRACTURE_SURFACE).append("(ID))")
            .toString();

    /*public final static String CREATE_BENTHOS = "CREATE TABLE Benthos ("
            + "SampleID VARCHAR(17) PRIMARY KEY,"
            + "Photo VARCHAR(50),"
            + "Quality NUMERIC(10),"
            + "Biomass NUMERIC(10),"
            + "ID_FractureSurface VARCHAR(15),"
            + "FOREIGN KEY (ID_FractureSurface) REFERENCES FractureSurface(ID))";*/
    public final static String CREATE_BENTHOS = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.BENTHOS)
            .append(" (")
            .append("SampleID VARCHAR(17) PRIMARY KEY,")
            .append("Photo VARCHAR(50),")
            .append("Quality NUMERIC(10),")
            .append("Biomass NUMERIC(10),")
            .append("ID_FractureSurface VARCHAR(15),")
            .append("FOREIGN KEY (ID_FractureSurface) REFERENCES ").append(TableNames.FRACTURE_SURFACE).append("(ID))")
            .toString();

    /*public final static String CREATE_DOMINANT_PHYTOPLANKTON_SPECIES = "CREATE TABLE DominantPhytoplanktonSpecies("
            + "SampleID VARCHAR(17) PRIMARY KEY,"
            + "Name VARCHAR(30),"
            + "Photo VARCHAR(50),"
            + "Quality NUMERIC(10),"
            + "Biomass NUMERIC(5,1),"
            + "ID_Phytoplankton VARCHAR(17),"
            + "FOREIGN KEY (ID_Phytoplankton) REFERENCES Phytoplankton(SampleID))";*/
    public final static String CREATE_DOMINANT_PHYTOPLANKTON_SPECIES = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.DOMINANT_PHYTOPLANKTON_SPECIES)
            .append(" (")
            .append("SampleID VARCHAR(17) PRIMARY KEY,")
            .append("Name VARCHAR(30),")
            .append("Photo VARCHAR(50),")
            .append("Quality NUMERIC(10),")
            .append("Biomass NUMERIC(5,1),")
            .append("ID_Phytoplankton VARCHAR(17),")
            .append("FOREIGN KEY (ID_Phytoplankton) REFERENCES ").append(TableNames.PHYTOPLANKTON).append("(SampleID))")
            .toString();

    /*public final static String CREATE_DOMINANT_ZOOPLANKTON_SPECIES = "CREATE TABLE DominantZooplanktonSpecies("
            + "SampleID VARCHAR(17) PRIMARY KEY,"
            + "Name VARCHAR(30),"
            + "Photo VARCHAR(50),"
            + "Quality NUMERIC(10),"
            + "Biomass NUMERIC(5,1),"
            + "ID_Zooplankton VARCHAR(17),"
            + "FOREIGN KEY (ID_Zooplankton) REFERENCES Zooplankton(SampleID))";*/
    public final static String CREATE_DOMINANT_ZOOPLANKTON_SPECIES = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.DOMINANT_ZOOPLANKTON_SPECIES)
            .append(" (")
            .append("SampleID VARCHAR(17) PRIMARY KEY,")
            .append("Name VARCHAR(30),")
            .append("Photo VARCHAR(50),")
            .append("Quality NUMERIC(10),")
            .append("Biomass NUMERIC(5,1),")
            .append("ID_Zooplankton VARCHAR(17),")
            .append("FOREIGN KEY (ID_Zooplankton) REFERENCES ").append(TableNames.ZOOPLANKTON).append("(SampleID))")
            .toString();

    /*public final static String CREATE_DOMINANT_BENTHOS_SPECIES = "CREATE TABLE DominantBenthosSpecies("
            + "SampleID VARCHAR(17) PRIMARY KEY,"
            + "Name VARCHAR(30),"
            + "Photo VARCHAR(50),"
            + "Quality NUMERIC(10),"
            + "Biomass NUMERIC(5,1),"
            + "ID_Benthos VARCHAR(17),"
            + "FOREIGN KEY (ID_Benthos) REFERENCES Benthos(SampleID))";*/
    public final static String CREATE_DOMINANT_BENTHOS_SPECIES = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.DOMINANT_BENTHOS_SPECIES)
            .append(" (")
            .append("SampleID VARCHAR(17) PRIMARY KEY,")
            .append("Name VARCHAR(30),")
            .append("Photo VARCHAR(50),")
            .append("Quality NUMERIC(10),")
            .append("Biomass NUMERIC(5,1),")
            .append("ID_Benthos VARCHAR(17),")
            .append("FOREIGN KEY (ID_Benthos) REFERENCES ").append(TableNames.BENTHOS).append("(SampleID))")
            .toString();

    /*public final static String CREATE_SEDIMENT = "CREATE TABLE Sediment("
            + "SampleID VARCHAR(17) PRIMARY KEY,"
            + "Photo VARCHAR(50))";*/
    public final static String CREATE_SEDIMENT = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.SEDIMENT)
            .append(" (")
            .append("SampleID VARCHAR(17) PRIMARY KEY,")
            .append("Photo VARCHAR(50))")
            .toString();

    /*public final static String CREATE_FRACTURE_SURFACE_SEDIMENT = "CREATE TABLE FractureSurface_Sediment ("
            + "ID_FractureSurface VARCHAR(15) PRIMARY KEY,"
            + "ID_Sediment VARCHAR(17),"
            + "FOREIGN KEY (ID_FractureSurface) REFERENCES FractureSurface(ID),"
            + "FOREIGN KEY (ID_Sediment) REFERENCES Sediment(SampleID))";*/
    public final static String CREATE_FRACTURE_SURFACE_SEDIMENT = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.FRACTURE_SURFACE_SEDIMENT)
            .append(" (")
            .append("ID_FractureSurface VARCHAR(15) PRIMARY KEY,")
            .append("ID_Sediment VARCHAR(17),")
            .append("FOREIGN KEY (ID_FractureSurface) REFERENCES ").append(TableNames.FRACTURE_SURFACE).append("(ID),")
            .append("FOREIGN KEY (ID_Sediment) REFERENCES ").append(TableNames.SEDIMENT).append("(SampleID))")
            .toString();

    /*public final static String CREATE_MEASURE_LINE = "CREATE TABLE MeasuringLine("
            + "ID VARCHAR(15) PRIMARY KEY,"
            + "StartLongitude NUMERIC(12,9),"
            + "StartLatitude NUMERIC(11,9),"
            + "EndLongitude NUMERIC(12,9),"
            + "EndLatitude NUMERIC(11,9),"
            + "ID_FractureSurface VARCHAR(15),"
            + "FOREIGN KEY (ID_FractureSurface) REFERENCES FractureSurface(ID))";*/
    public final static String CREATE_MEASURE_LINE = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.MEASURING_LINE)
            .append(" (")
            .append("ID VARCHAR(15) PRIMARY KEY,")
            .append("StartLongitude NUMERIC(12,9),")
            .append("StartLatitude NUMERIC(11,9),")
            .append("EndLongitude NUMERIC(12,9),")
            .append("EndLatitude NUMERIC(11,9),")
            .append("ID_FractureSurface VARCHAR(15),")
            .append("FOREIGN KEY (ID_FractureSurface) REFERENCES ").append(TableNames.FRACTURE_SURFACE).append("(ID))")
            .toString();

    /*public final static String CREATE_MEASURE_POINT = "CREATE TABLE MeasuringPoint("
            + "ID VARCHAR(15) PRIMARY KEY,"
            + "Longitude NUMERIC(12,9),"
            + "Latitude NUMERIC(11,9),"
            + "ID_MeasuringLine VARCHAR(15),"
            + "FOREIGN KEY (ID_MeasuringLine) REFERENCES MeasuringLine(ID))";*/
    public final static String CREATE_MEASURE_POINT = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.MEASURING_POINT)
            .append(" (")
            .append("ID VARCHAR(15) PRIMARY KEY,")
            .append("Longitude NUMERIC(12,9),")
            .append("Latitude NUMERIC(11,9),")
            .append("ID_MeasuringLine VARCHAR(15),")
            .append("FOREIGN KEY (ID_MeasuringLine) REFERENCES ").append(TableNames.MEASURING_LINE).append("(ID))")
            .toString();

    /*public final static String CREATE_WATER_LAYER = "CREATE TABLE WaterLayer("
            + "ID VARCHAR(15) PRIMARY KEY,"
            + "Layer VARCHAR(2) NOT NULL,"
            + "Depth NUMERIC(5,2),"
            + "Temperature NUMERIC(5,2),"
            + "WaterLevel NUMERIC(5,2),"
            + "Velocity NUMERIC(10,2),"
            + "ID_MeasuringPoint VARCHAR(15),"
            + "FOREIGN KEY (ID_MeasuringPoint) REFERENCES MeasuringPoint(ID))";*/
    public final static String CREATE_WATER_LAYER = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.WATER_LAYER)
            .append(" (")
            .append("ID VARCHAR(15) PRIMARY KEY,")
            .append("Layer VARCHAR(2) NOT NULL,")
            .append("Depth NUMERIC(5,2),")
            .append("Temperature NUMERIC(5,2),")
            .append("WaterLevel NUMERIC(5,2),")
            .append("Velocity NUMERIC(10,2),")
            .append("ID_MeasuringPoint VARCHAR(15),")
            .append("FOREIGN KEY (ID_MeasuringPoint) REFERENCES ").append(TableNames.MEASURING_POINT).append("(ID))")
            .toString();

    /*public final static String CREATE_CATCHES = "CREATE TABLE Catches("
            + "SampleID VARCHAR(17) PRIMARY KEY,"
            + "Name VARCHAR(30),"
            + "Photo VARCHAR(50),"
            + "TotalQuality NUMERIC(8),"
            + "EggQuality NUMERIC(8),"
            + "FryQuality NUMERIC(8),"
            + "ID_WaterLayer VARCHAR(15),"
            + "FOREIGN KEY (ID_WaterLayer) REFERENCES WaterLayer(ID))";*/
    public final static String CREATE_CATCHES = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.CATCHES)
            .append(" (")
            .append("SampleID VARCHAR(17) PRIMARY KEY,")
            .append("Name VARCHAR(30),")
            .append("Photo VARCHAR(50),")
            .append("TotalQuality NUMERIC(8),")
            .append("EggQuality NUMERIC(8),")
            .append("FryQuality NUMERIC(8),")
            .append("ID_WaterLayer VARCHAR(15),")
            .append("FOREIGN KEY (ID_WaterLayer) REFERENCES ").append(TableNames.WATER_LAYER).append("(ID))")
            .toString();

    /*public final static String CREATE_FISHES = "CREATE TABLE Fishes("
            + "SampleID VARCHAR(17) PRIMARY KEY,"
            + "Photo VARCHAR(50),"
            + "BodyLength NUMERIC(10),"
            + "Length NUMERIC(10),"
            + "BodyWeight NUMERIC(10,1),"
            + "Age NUMERIC(2),"
            + "ID_Catches VARCHAR(17),"
            + "FOREIGN KEY (ID_Catches) REFERENCES Catches(SampleID))";*/
    public final static String CREATE_FISHES = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.FISHES)
            .append(" (")
            .append("SampleID VARCHAR(17) PRIMARY KEY,")
            .append("Photo VARCHAR(50),")
            .append("BodyLength NUMERIC(10),")
            .append("Length NUMERIC(10),")
            .append("BodyWeight NUMERIC(10,1),")
            .append("Age NUMERIC(2),")
            .append("ID_Catches VARCHAR(17),")
            .append("FOREIGN KEY (ID_Catches) REFERENCES ").append(TableNames.CATCHES).append("(SampleID))")
            .toString();

    /*public final static String CREATE_FISH_EGGS = "CREATE TABLE FishEggs("
            + "SampleID VARCHAR(17) PRIMARY KEY,"
            + "Photo VARCHAR(50),"
            + "Period VARCHAR(50),"
            + "Diameter NUMERIC(10,2),"
            + "EMDiameter NUMERIC(10,2),"
            + "PigmentProp VARCHAR(100),"
            + "EmbryoProp VARCHAR(100),"
            + "ID_Catches VARCHAR(17),"
            + "FOREIGN KEY (ID_Catches) REFERENCES Catches(SampleID))";*/
    public final static String CREATE_FISH_EGGS = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.FISH_EGGS)
            .append(" (")
            .append("SampleID VARCHAR(17) PRIMARY KEY,")
            .append("Photo VARCHAR(50),")
            .append("Period VARCHAR(50),")
            .append("Diameter NUMERIC(10,2),")
            .append("EMDiameter NUMERIC(10,2),")
            .append("PigmentProp VARCHAR(100),")
            .append("EmbryoProp VARCHAR(100),")
            .append("ID_Catches VARCHAR(17),")
            .append("FOREIGN KEY (ID_Catches) REFERENCES ").append(TableNames.CATCHES).append("(SampleID))")
            .toString();

    /*public final static String CREATE_CATCH_TOOLS = "CREATE TABLE CatchTools("
            + "SampleID VARCHAR(17) PRIMARY KEY,"
            + "Name VARCHAR(40),"
            + "Photo VARCHAR(50),"
            + "NetsModel VARCHAR(8),"
            + "NetMouthArea NUMERIC(10,3),"
            + "NetMouthDip NUMERIC(3),"
            + "StartTime TIME,"
            + "EndTime TIME,"
            + "NetMouthVelocity NUMERIC(10,3))";*/
    public final static String CREATE_CATCH_TOOLS = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.CATCH_TOOLS)
            .append(" (")
            .append("SampleID VARCHAR(17) PRIMARY KEY,")
            .append("Name VARCHAR(40),")
            .append("Photo VARCHAR(50),")
            .append("NetsModel VARCHAR(8),")
            .append("NetMouthArea NUMERIC(10,3),")
            .append("NetMouthDip NUMERIC(3),")
            .append("StartTime TIME,")
            .append("EndTime TIME,")
            .append("NetMouthVelocity NUMERIC(10,3))")
            .toString();

    /*public final static String CREATE_WATER_LAYER_CATCH_TOOLS =  "CREATE TABLE WaterLayer_CatchTools ("
            + "ID_WaterLayer VARCHAR(15) PRIMARY KEY,"
            + "ID_CatchTools VARCHAR(17),"
            + "FOREIGN KEY (ID_WaterLayer) REFERENCES WaterLayer(ID),"
            + "FOREIGN KEY (ID_CatchTools) REFERENCES CatchTools(SampleID))";*/
    public final static String CREATE_WATER_LAYER_CATCH_TOOLS = new StringBuffer()
            .append("CREATE TABLE ")
            .append(TableNames.WATER_LAYER_CATCH_TOOLS)
            .append(" (")
            .append("ID_WaterLayer VARCHAR(15) PRIMARY KEY,")
            .append("ID_CatchTools VARCHAR(17),")
            .append("FOREIGN KEY (ID_WaterLayer) REFERENCES ").append(TableNames.WATER_LAYER).append("(ID),")
            .append("FOREIGN KEY (ID_CatchTools) REFERENCES ").append(TableNames.CATCH_TOOLS).append("(SampleID))")
            .toString();

}
