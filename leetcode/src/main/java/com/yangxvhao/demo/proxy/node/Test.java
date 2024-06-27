package com.yangxvhao.demo.proxy.node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangxuhao <yangxuhao@kuaishou.com>
 * Created on 2024-06-05
 */
public class Test {
    /**
     * excel
     * a-z,aa-az,ba-bz,ca-cz...za-zz,aaa-aaz,aba-abz
     * 0-25,26-51,.....26*26
     * aa=(26*1 + 0), ab=(26*1+1)...az=(26*1+25)
     * ba=(26*2 +0),bb=(26*2+1)...bz=(26*2+25)
     * ca...
     * za=(26*26+0).. zz=(26*26+25)
     * aaa=(26*26+26+0),aab=(26*26+26+1)...aaz=(26*26+26+25)
     * aba=(26*26+26*2+0)
     */
    public static void main(String[] args) {
        String str = "aaa";
        char[] chars = str.toCharArray();
        int n = chars.length - 1;

        char[] dict = new char[]{'a','b'};
        Map<Character, Integer> dictMap = new HashMap<>();

        int result = 0;
        for(int i = n; i >= 0; i++){
            dictMap.get(str.charAt(i))
        }
    }
}
