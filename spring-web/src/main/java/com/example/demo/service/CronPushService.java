package com.example.demo.service;

import com.example.demo.Content;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.websocket.Session;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yangxuhao
 * @date 2019-04-19 10:54.
 */
@Service
public class CronPushService {
    @PostConstruct
    public void sendMessage() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            while (true) {
                Optional.ofNullable(Content.liveSocketSession).map(stringSessionMap -> {
                    stringSessionMap.forEach((userId, session) -> {
                        try {
                            int count = 1000000;
                            while (count > 0) {
                                if (count % 50 == 0) {
                                    Thread.sleep(10000);
                                    session.getBasicRemote().sendText("service send to " + userId + "!, count = " + count);
                                }
                                count--;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                    return stringSessionMap.size();
                });
            }
        });
    }
}
