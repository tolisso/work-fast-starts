package com.tolisso.bsmicro.kafka.input;

import com.tolisso.bsmicro.kafka.GreetingMessage;
import org.apache.log4j.Logger;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageListener {


    @StreamListener(ConsumerChannels.DIRECTED)
    public void directed(GreetingMessage message) {
        System.out.println("Directed: " + message);
    }
}
