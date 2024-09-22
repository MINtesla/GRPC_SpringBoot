package com.learning.GRPC.sec02;

import com.learning.GRPC.models.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {
    private static final Logger log = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(String[] args) {
        // create two proto class
        Person person1 = Person.newBuilder()
                .setAge(14)
                .setName("salshi")
                .build();

        Person person2 = Person.newBuilder()
                .setAge(14)
                .setName("salshi")
                .build();

        // compare them
        log.info("are they equals :{}",person1.equals(person2));
        log.info("are they == :{}",person1==person2);

        // mutable? No

        // create another instance with diff value - if not mutable
        Person person3 = person1.toBuilder().setAge(15).build();

        // compare again
        log.info("are they equals :{}",person1.equals(person3));
        log.info("are they == :{}",person1==person3);

        // null value to be set ? use clearName clearAge functions
        Person person4 = Person.newBuilder().clearName().setAge(10).clearAge().build();

        log.info("Person 4::{}",person4);

    }
}
