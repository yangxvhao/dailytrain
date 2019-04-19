package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.Session;
import java.io.IOException;

/**
 * @author yangxuhao
 * @date 2019-04-18 18:25.
 */
@RestController
public class ControllerC {
    @Autowired
    WebSocketA webSocketA;

    @GetMapping("/send/{id}/{message}")
    public String sendMessage(@PathVariable("id") String userId, @PathVariable("message") String message) throws IOException {
        Session session = webSocketA.getSession(userId);
        if(session != null){
            session.getBasicRemote().sendText(message);
        }
        return "ok";
    }
}
