package com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils;

/**
 * Created by Phoenix on 2016/7/28.
 * 用于将数据库中的地址字段进行处理，输出是
 */
public class AddressUtils {
    //城市所在省在常量表中的下标
    private static int cityPosition = 0;
    //城市在常量表中的下标
    private static int cityIndex = 0;
    //详细信息
    private static String addressDetails = null;

    //处理地址的函数
    public static void processAddress(String rawAddress) {

        if (rawAddress == null || rawAddress.equals("")) {
            addressDetails = "";
            return;
        }

        int firstIndex = rawAddress.indexOf("|");
        int secIndex = rawAddress.indexOf("$");

        rawAddress.substring(0, firstIndex - 1);

        cityPosition = Integer.parseInt(rawAddress.substring(0, firstIndex));
        cityIndex = Integer.parseInt(rawAddress.substring(firstIndex + 1, secIndex));
        addressDetails = rawAddress.substring(secIndex + 1, rawAddress.length());
    }

    public static int getCityIndex() {
        return cityIndex;
    }

    public static int getCityPosition() {
        return cityPosition;
    }

    public static String getAddressDetails() {
        return addressDetails;
    }
}
