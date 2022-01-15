package com.example.gymClassBooking;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Timer;


public class TimerForClass {


        public void bookClass(GymClassWithUser gymClassWithUser) throws InterruptedException {

            LocalDateTime dateWithTime = gymClassWithUser.getDateWithTime().plusSeconds(1);
            LocalDateTime dateWithTimeMinus3 = dateWithTime.minusDays(3);
            Date whenToBookClass = Date.from(dateWithTimeMinus3.atZone(ZoneId.systemDefault()).toInstant());

            new Timer().schedule(new ScheduleBooking(gymClassWithUser), whenToBookClass);

        }

}

