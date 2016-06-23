package com.example.phoenix.fishresourceinventorydataacquisitonsystem.db;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class DBOperator {
    private static DBOperator DBOperator;
    private DBOperator() {
    }
    static {
        DBOperator = new DBOperator();
    }
    public DBOperator getInstance() {
        return DBOperator;
    }


}
