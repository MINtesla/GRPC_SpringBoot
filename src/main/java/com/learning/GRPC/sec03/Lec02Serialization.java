package com.learning.GRPC.sec03;

import com.learning.GRPC.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lec02Serialization {
    private static final Logger log = LoggerFactory.getLogger(Lec02Serialization.class);
    private static final Path PATH = Path.of("person.out");

    public static void main(String[] args) throws IOException {
        var person = Person.newBuilder()
                .setLastName("sam")
                .setAge(12)
                .setEmail("sam@gmail.com")
                .setEmployed(true)
                .setSalary(1000.2345)
                .setBankAccountNumber(123456789012L)
                .setBalance(-10000)
                .build();

        log.info("{}", person);

        serialise(person);
        log.info("{}", deserialise(person));

        log.info("person to byte size:{}",person.toByteArray().length);

    }
    public static void serialise(Person person) throws IOException {
        // this close it by default when using it should be used always in try block
        try(var stream = Files.newOutputStream(PATH)) {
            person.writeTo(stream);
        }

//        person.writeTo(Files.newOutputStream(PATH));
    }

    public static Person deserialise(Person person) throws IOException {
        // this close it by default when using it should be used always in try block
        try(var stream = Files.newInputStream(PATH)){
            return Person.parseFrom(stream);
        }
//       return Person.parseFrom(Files.newInputStream(PATH));
    }
}
