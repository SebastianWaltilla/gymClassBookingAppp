package com.example.gymClassBooking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GymClassWithUser {

    LocalDateTime dateWithTime;
    String userName;
    String password;
    String classId;
    String url;

    String webMainPage1 = "https://www.medl";
    String webMainPage2 = "ey.se/boka-pass#?productIds=";

    public GymClassWithUser(String localDateTime, String className, String userName, String password) {

        //LocalDateTime.of(2022,1,8,16,30);
        String[] dT = localDateTime.split(",");
        List<Integer> ej = new ArrayList<>();
        for (String h : dT) {
            ej.add(Integer.valueOf(h));
        }

        this.dateWithTime = LocalDateTime.of(
                2022, ej.get(0), ej.get(1), ej.get(2), ej.get(3)
        );

        this.userName = userName;
        this.password = password;
        this.classId = Classes.getGymClass(className);

        this.url = webMainPage1 + webMainPage2 + classId + "&businessUnitIds=14378&startDate=" + dateWithTime.toLocalDate().toString();

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
