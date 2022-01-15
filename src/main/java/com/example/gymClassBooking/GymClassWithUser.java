package com.example.gymClassBooking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GymClassWithUser {

    LocalDateTime dateWithTime;
    String userName;
    String password;
    String classId;

    public LocalDateTime getDateWithTime() {
        return dateWithTime;
    }

    String url;
    String bookingQuery;

    public String getBookingQuery() {
        return bookingQuery;
    }

    public void setBookingQuery(String bookingQuery) {
        this.bookingQuery = bookingQuery;
    }

    public GymClassWithUser(String localDateTime, String className, String userName, String password, String bookingQuery) {
        String webMainPage1 = "https://www.medl";
        String webMainPage2 = "ey.se/boka-pass#?productIds=";

        this.dateWithTime = createLocalDateTimeFromString(localDateTime);
        this.bookingQuery = bookingQuery;
        this.userName = userName;
        this.password = password;
        this.classId = Classes.getGymClass(className);
        this.url = webMainPage1 + webMainPage2 + classId + "&businessUnitIds=14378&startDate=" + dateWithTime.toLocalDate().toString();
        System.out.println(url);
    }

    public LocalDateTime createLocalDateTimeFromString(String localDateTime) {

        //LocalDateTime.of(2022,1,8,16,30);
        String[] dT = localDateTime.split(",");
        List<Integer> t = new ArrayList<>();
        for (String h : dT) {
            t.add(Integer.valueOf(h));
        }
        return LocalDateTime.of(2022, t.get(0), t.get(1), t.get(2), t.get(3));
    }

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
