package com.example.gymClassBooking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class appConfig {

    @Value("${user.sebastian.userName}")
    String user1;

    @Value("${user.sebastian.password}")
    String user1p;

    @Bean
    public void beanForUser1() throws InterruptedException {

        GymClassWithUser sebUser = new GymClassWithUser(

                //LocalDateTime.of(2022,1,8,16,30);

                "2022,1,8,16,30",
                Classes.getGymClass("BODYPUMP"),
                user1,
                user1p

              );



    }


}
