package com.example.gymClassBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class bookingInterface {

    List<GymClassWithUser> allBookings = new ArrayList<>();

    @Autowired
    Users users;

    @Autowired
    BookingScript bookingScript;

    @GetMapping("/one/{message}")
    String one(@PathVariable String message) {

        try{
            bookClass(message);
            bookingScript.run(allBookings.get(0));
            return "Good job, your class is booked!";
        } catch(Exception e){
            return "one: error, something wrong with: " + message;
        }


    }

    @GetMapping("/multiple/{message}")
    String multiple(@PathVariable String message) {

        System.out.println(message);
        try{
            String[] bookings = message.split("=");
            Arrays.stream(bookings).forEach(s -> bookClass(s));
            return "Good job, right format!";
        } catch(Exception e){
            return "multiple: error, something wrong with: " + message;
        }
    }


    public void bookClass(String booking){

        // sebastian-2022,1,10,16,30-BODYPUMP
        String[] dateAmdClass = booking.split("-");

        String[] userAndPassword = users.getUsers(dateAmdClass[0]);

        GymClassWithUser classWithUser = new GymClassWithUser(
                dateAmdClass[1],
                dateAmdClass[2],
                userAndPassword[0],
                userAndPassword[1]);

        allBookings.add(classWithUser);
        System.out.println("bookClass() sucessfull");
    }

}
