package com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils;

/**
 * Created by Phoenix on 2016/7/29.
 */
public class StringUtils {
    public static boolean isStringEmpty(String str) {
        if (str == null || str.equals("")) {
            return true;
        }
        return false;
    }
}
