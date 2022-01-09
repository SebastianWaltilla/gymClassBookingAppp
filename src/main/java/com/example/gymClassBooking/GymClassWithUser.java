package com.example.gymClassBooking;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GymClassWithUser {

    // https://www.medley.se/boka-pass#?productIds=20574,21493&businessUnitIds=14378&startDate=2022-01-12
    // https://www.medley.se/boka-pass#?productIds=16601,16809,16577&businessUnitIds=14378&startDate=2022-01-14
    // https://www.medley.se/boka-pass#?productIds=20875&businessUnitIds=14378&startDate=2022-01-11
    // BODYPUMP = "16601,16809,16577"

    LocalDateTime dateWithTime;
    String userName;
    String password;
    String classId;
    String url;

    @Value("${webmainpage}")
    String webMainPage;





    public GymClassWithUser(String localDateTime, String className, String userName, String password) {

        //LocalDateTime.of(2022,1,8,16,30);
        String[] dT = localDateTime.split(",");
        List<Integer> ej = new ArrayList<>();
        for (String h : dT) {
            ej.add(Integer.valueOf(h));
        }

        this.dateWithTime = LocalDateTime.of(
                ej.get(0), ej.get(1), ej.get(2), ej.get(3), ej.get(4)
        );

        this.userName = userName;
        this.password = password;
        this.classId = Classes.getGymClass(className);
        // https://www.GYMHERE.se/boka-pass#?businessUnitIds= + classId + &startDate= + 2022-01-03
        this.url = webMainPage + classId + "&startDate=" + dateWithTime.toLocalDate().toString();

        System.out.println(url);
    }



        //System.out.println(LocalDateTime.now());



    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

}
