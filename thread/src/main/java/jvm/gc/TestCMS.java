package jvm.gc;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xmx500M -Xms500M -Xmn200M -XX:+UseConcMarkSweepGC -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=80 -XX:+CMSScavengeBeforeRemark
 * @author yangxuhao
 * @date 2019-06-05 14:58.
 */
@Slf4j
public class TestCMS {
    public static void main(String[] args) {
        try {
            Thread.sleep(30000);
            allocateMemory();
            Thread.sleep(100000);
        } catch (Exception e) {
            log.error("e");
        }

    }

    public static void allocateMemory() {

        int size = 1024 * 1024 * 480;
        int len = size / (1024 * 21);
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            try {
                list.add(new byte[20 * 1024]);
            } catch (OutOfMemoryError e) {
                System.out.println("i = " + i);
                log.error("i = {}", i);
            }

        }
    }
}
