package com.example.demo;

import lombok.Data;

import javax.websocket.Session;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangxuhao
 * @date 2019-04-19 11:10.
 */
@Data
public class Content {
    public static Map<String, Session> liveSocketSession = new HashMap<>();
}
