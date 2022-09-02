package com.yangxvhao.demo.proxy;

import jodd.io.FileUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangxvhao
 * @date 2018-08-13 下午7:18.
 */
public class History {
    public static void main(String[] args) {

        try {
            Map<String, String> fileNames = new HashMap<>();
            fileNames.put("2", "/home/yangxvhao/work/document/数据导出需求/0801/贷后3个月逾期14到30天用户750条.txt");
            fileNames.put("1", "/home/yangxvhao/work/document/数据导出需求/0801/贷后3个月逾期超过30天用户750条.txt");
            fileNames.put("3", "/home/yangxvhao/work/document/数据导出需求/0801/正常还款用户1000条.txt");

            StringBuilder writeString = new StringBuilder();
            writeString.append("手机号").append(",").append("标签").append("\n");
            fileNames.forEach((key, value) -> {
                try {
                    String[] file = FileUtil.readLines(value);
                    for (int i = 1; i < file.length; i++) {
                        writeString.append(file[i].split(",")[1]).append(",").append(key).append("\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            FileUtil.writeString( "/home/yangxvhao/work/document/数据导出需求/0827/用户标签.txt", writeString.toString());
            
//            SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
//
//            
//            String[] strings = FileUtil.readLines("/home/yangxvhao/.zsh_history");
//            //strings[0].split(";")[1].split(" ")[0]
//            //strings[0].split(";")[0].split(":")[1].trim()
//            
//            Set set = Stream.of(strings)
//                    .map(s -> s.split(";").length > 1 ? s.split(";")[1].split(" ")[0] : "")
//                    .collect(Collectors.toSet());
//            
////            Map f = Stream.of(strings).collect(Collectors.toMap(o ->  o.split(";")[1].split(" ")[0]
////                    ,o -> format.format(Long.decode(o.split(";")[0].split(":")[1].trim()))));
//            set.forEach(System.out::println);
//            System.out.println();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
