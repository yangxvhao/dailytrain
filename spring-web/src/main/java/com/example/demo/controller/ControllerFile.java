package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;

@RestController()
public class ControllerFile {
  @GetMapping("/export/excel")
  public void exportFile(HttpServletResponse response){
    try {
      OutputStream outputStream = response.getOutputStream();
      File file = new File("/Users/didi/IdeaProjects/dailytrain/spring-web/src/main/java/com/example/demo/controller/ControllerFile.java");
      InputStream inputStream = new FileInputStream(file);
      byte[] read = new byte[inputStream.available()];
      inputStream.read(read);
      outputStream.write(read);

      String fileName = file.getName();
      response.setCharacterEncoding("UTF-8");
      response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
      response.setContentType("application/force-download"); //设置弹出下载框
      inputStream.close();
      outputStream.flush();
      outputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
