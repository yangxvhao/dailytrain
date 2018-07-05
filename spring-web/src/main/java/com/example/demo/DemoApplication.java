package com.example.demo;

import com.example.demo.util.Receive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication()
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@RestController("/")
@Slf4j
public class DemoApplication implements CommandLineRunner {
    
    @Autowired
    RedisTemplate redisTemplate; 
    
    @Autowired
    ApplicationContext context;
    
    

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        for (String bean : context.getBeanDefinitionNames()) {
            log.info(bean);
        }

        RabbitAdmin rabbitAdmin = context.getBean(RabbitAdmin.class);
        CachingConnectionFactory connectionFactory = context.getBean(CachingConnectionFactory.class);
        
        TopicExchange exchange = new TopicExchange("we-chat");
        rabbitAdmin.declareExchange(exchange);
        Queue queue = new Queue("chat");
        rabbitAdmin.declareQueue(queue);
        rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange).with("100000.*.*.*.*.*.*.*.1.#"));

        SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory);
        listenerContainer.setRabbitAdmin(rabbitAdmin);
        listenerContainer.setQueues(queue);
        listenerContainer.setConcurrentConsumers(200);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        listenerContainer.setTaskExecutor(executorService);
        listenerContainer.setPrefetchCount(1);
        
        listenerContainer.setMessageListener(new MessageListenerAdapter(new Receive(), "receive"));
        listenerContainer.start();
    }
}
