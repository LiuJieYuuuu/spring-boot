package com.online.demo.util;

import java.util.Map;

public class MapUtils {
    public static String getMapNullString(Map data,String key){
        return data == null ? "" : data.get(key) == null ? "" : data.get(key).toString();
    }
}
