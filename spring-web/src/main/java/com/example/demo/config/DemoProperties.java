package com.example.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yangxvhao
 * @date 18-7-10.
 */
@ConfigurationProperties(prefix = "yang.demo")
@Data
public class DemoProperties {
    private String name;
    
    private int age;
    
    private Host host;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Host{
        private String ip;
        
        private int port;
    }
}
