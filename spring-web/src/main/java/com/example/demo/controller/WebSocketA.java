package com.example.demo.controller;

import com.example.demo.Content;
import com.example.demo.service.CronPushService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangxuhao
 * @date 2019-04-18 15:14.
 */
@Slf4j
@Component
@ServerEndpoint(value = "/websocket/{id}")
public class WebSocketA {
    @Resource
    private CronPushService cronPushService;

    private String userId;

    @OnOpen
    public void onOpen(@PathParam("id") String userId, Session session) throws Exception {
        log.info("create new link, id = {}", userId);
        this.userId = userId;
        Content.liveSocketSession.put(userId, session);
    }

    @OnClose
    public void onClose(){
        Content.liveSocketSession.remove(this.userId);
        log.info("link is close, id");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.info("receive message, id = {}, message = {}", this.userId, message);
        session.getBasicRemote().sendText("total size = " + Content.liveSocketSession.size());
    }

    @OnError
    public void onError(Throwable e){
        Content.liveSocketSession.remove(this.userId);
        log.info("id = {} link is error!", this.userId);
        e.printStackTrace();
    }

    public Session getSession(String userId){
        return Content.liveSocketSession.get(userId);
    }
}
