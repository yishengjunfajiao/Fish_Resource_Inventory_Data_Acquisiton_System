package com.example.phoenix.fishresourceinventorydataacquisitonsystem.db;

/**
 * Created by Phoenix on 2016/5/31.
 */
public class JerryOperator {
    private static JerryOperator jerryOperator;
    private JerryOperator() {
    }
    static {
        jerryOperator = new JerryOperator();
    }
    public JerryOperator getInstance() {
        return jerryOperator;
    }


}
