package com.example.demo;

/**
 * @author yangxuhao
 * @DATE 2020-04-22 17:54.
 */
public class SuperClass {

  private void privateDisplay1(){
    System.out.println("private");
  }

  protected void protectedDisplay2(){
    System.out.println("protected");
  }

  final void finalDisplay3(){
    System.out.println("final");
  }
}
