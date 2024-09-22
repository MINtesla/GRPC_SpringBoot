package com.learning.GRPC.sec01;

import com.learning.GRPC.models.sec01.PersonOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProtoDump {

    private static final Logger log = LoggerFactory.getLogger(SimpleProtoDump.class);

    public static void main(String[] args) {
        var person = PersonOuterClass.Person.newBuilder()
                .setAge(20)
                .setName("don")
                .build();
        log.info("{}",person);
    }
}
