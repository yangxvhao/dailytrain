package com.yangxvhao.demo.proxy;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangxuhao
 * @date 2018-11-26 15:01.
 */
public class GoogleGuava {
    public static void main(String[] args) {
        HashMap<String, String> params = Maps.newHashMap();
        params.put("name", null);
        params.put("age", "12");
        params.put(null, "man");
        params.put(null, "female");

        Map resultMap;
        resultMap = Maps.transformEntries(params, (key, value) -> {
            if(key == null) {
                return "";
            }
            if(value == null){
                return key + "=";
            }
            return key + "=" + value;
        });

        String result = Joiner.on("&").join(resultMap.values());
        System.out.println(result);
    }
}
