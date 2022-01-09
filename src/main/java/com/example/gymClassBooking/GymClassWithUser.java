package com.example.gymClassBooking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GymClassWithUser {

    LocalDateTime localDateTime;
    String userName;
    String password;
    String classId;

    public GymClassWithUser(String localDateTime, String userName, String password, String classId) {

        //LocalDateTime.of(2022,1,8,16,30);
        String[] dT = localDateTime.split(",");
        List<Integer> ej = new ArrayList<>();
        for (String h : dT) {
            ej.add(Integer.valueOf(h));
        }

        this.localDateTime = LocalDateTime.of(
                ej.get(0), ej.get(1), ej.get(2), ej.get(3), ej.get(4)
        );

        this.userName = userName;
        this.password = password;
        this.classId = classId;
    }

    public static void main(String[] args) {

        System.out.println(LocalDateTime.now());

    }


}
