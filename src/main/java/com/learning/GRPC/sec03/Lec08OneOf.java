package com.learning.GRPC.sec03;

import com.learning.GRPC.models.Credentials;
import com.learning.GRPC.models.Email;
import com.learning.GRPC.models.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec08OneOf { // kind of interface
    private static final Logger log = LoggerFactory.getLogger(Lec08OneOf.class);

    public static void main(String[] args) {

        var email = Email.newBuilder().setAddress("sam@gmail.com").setPassword("admin").build();
        var phone = Phone.newBuilder().setNumber(123456789).setCode(123).build();

        login(Credentials.newBuilder().setEmail(email).build());
        login(Credentials.newBuilder().setPhone(phone).build());

        // what will happen if we set both?
        // last one wins!
        login(Credentials.newBuilder().setEmail(email).setPhone(phone).build());
        // take only one the last one set

    }

    private static void login(Credentials credentials){
        switch (credentials.getLoginTypeCase()){
            case EMAIL -> log.info("email -> {}", credentials.getEmail());
            case PHONE -> log.info("phone -> {}", credentials.getPhone());
        }
    }
}
