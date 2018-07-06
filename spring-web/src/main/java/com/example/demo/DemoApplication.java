package com.example.demo;

import com.example.demo.processor.Receive;
import com.example.demo.processor.ReceiveA;
import com.example.demo.processor.ReceiveB;
import lombok.extern.slf4j.Slf4j;
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
import org.springframework.web.bind.annotation.RestController;

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
        Queue queue = new Queue("chat1");
        rabbitAdmin.declareQueue(queue);
        rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange).with("1.#"));

        Queue queue1 = new Queue("chat2");
        rabbitAdmin.declareQueue(queue1);
        rabbitAdmin.declareBinding(BindingBuilder.bind(queue1).to(exchange).with("1.#"));
        
        SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
        SimpleMessageListenerContainer listenerContainer1 = new SimpleMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory);
        listenerContainer1.setConnectionFactory(connectionFactory);
        listenerContainer.setRabbitAdmin(rabbitAdmin);
        listenerContainer.setQueues(queue);
        listenerContainer1.setQueues(queue1);
        //设置并发的消费者数量
        listenerContainer.setConcurrentConsumers(50);
        //使用自定义的线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        listenerContainer.setTaskExecutor(executorService);
        //分给一个消费者要处理的消息数量，
        listenerContainer.setPrefetchCount(8);
        
        listenerContainer.setMessageListener(new MessageListenerAdapter(new ReceiveA(), "receive"));
        listenerContainer1.setMessageListener(new MessageListenerAdapter(new ReceiveB(), "receive"));
        listenerContainer.start();
        listenerContainer1.start();
    }
}
