package com.example.gymClassBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class bookingInterface {

    List<GymClassWithUser> allBookings = new ArrayList<>();

    @Autowired
    Users users;

    @Autowired
    BookingScript bookingScript;

    @GetMapping("/one/{message}")
    String one(@PathVariable String message) {

        try {
            addABookingToList(message);
            return "Good job, your class is booked!";
        } catch (Exception e) {
            return "one: error, something wrong with: " + message;
        }
    }

    @GetMapping("/multiple/{message}")
    String multiple(@PathVariable String message)  {

        System.out.println(message);
        try {
            String[] bookings = message.split("=");
            Arrays.stream(bookings).forEach(booking -> {
                try {
                    addABookingToList(booking);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            return "Good job, right format!";
        } catch (Exception e) {
            return "multiple: error, something wrong with: " + message;
        }
    }

    @GetMapping("/allBookings")
    String multiple() {

        try {
            return allBookings.stream()
                    .map(GymClassWithUser::getBookingQuery)
                    .collect(Collectors.joining("="));
        } catch (Exception e) {
            return "Nothing in list";
        }
    }

    public void addABookingToList(String booking) throws InterruptedException {

        // sebastian-2022,1,10,16,30-BODYPUMP
        String[] dateAndClass = booking.split("-");

        String[] userAndPassword = users.getUsers(dateAndClass[0]);

        GymClassWithUser classWithUser = new GymClassWithUser(
                dateAndClass[1],
                dateAndClass[2],
                userAndPassword[0],
                userAndPassword[1],
                booking);

        allBookings.add(classWithUser);
        new TimerForClass().bookClass(allBookings.get(allBookings.size()-1));

        System.out.println("addABookingToList() sucessfull");
    }

}
