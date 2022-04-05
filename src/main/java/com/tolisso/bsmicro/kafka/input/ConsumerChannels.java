package com.tolisso.bsmicro.kafka.input;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannels {

    String DIRECTED = "quickstart-events";

    @Input(DIRECTED)
    SubscribableChannel directed();

}
