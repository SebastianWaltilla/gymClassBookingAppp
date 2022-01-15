package com.example.gymClassBooking;

import java.util.Date;
import java.util.TimerTask;

public class ScheduleBooking extends TimerTask{

    GymClassWithUser gymClassWithUser;

    public ScheduleBooking(GymClassWithUser gymClassWithUser) {
    this.gymClassWithUser = gymClassWithUser;
    }

    // Add your task here
    @Override
    public void run() {

        try {
            new BookingScript().book(gymClassWithUser);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
