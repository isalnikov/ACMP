/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp89;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "3\n"
                + "\"ER-200\" 06:43 10:40\n"
                + "\"Red Arrow\" 23:55 07:55\n"
                + "\"Express\" 23:59 08:00";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("The fastest train is \"ER-200\".\n"
                + "It's speed is 165 km/h, approximately.", outContent.toString());

    }

    @Test
    public void test2() {
        String data = "3\n"
                + "\"Train1\" 00:00 00:00\n"
                + "\"Train2\" 00:00 00:01\n"
                + "\"Train3\" 00:01 00:01";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("The fastest train is \"Train2\".\n"
                + "It's speed is 39000 km/h, approximately.", outContent.toString());

    }

    @Test
    public void test3() {
        String data = "2\n"
                + "\"Slow Train 1\" 10:00 09:59\n"
                + "\"Slow Train 2\" 10:00 10:00";

       System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("The fastest train is \"Slow Train 1\".\n"
                + "It's speed is 27 km/h, approximately.", outContent.toString());

    }

    @Test
    public void test4() {
        String data = "2 \n"
                + "\"Slow Train 1\" 23:59 23:55\n"
                + "\"Slow Train 2\" 23:59 23:00";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("The fastest train is \"Slow Train 2\".\n"
                + "It's speed is 28 km/h, approximately.", outContent.toString());

    }
    
     @Test
    public void time1() {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        LocalTime startTime = LocalTime.parse("00:00",formatter);
        LocalTime stopTime = LocalTime.parse("00:01",formatter);
        
        LocalDateTime startOfDay = LocalDateTime.now().with(LocalTime.MIN);
        System.err.println(startOfDay);
         
        LocalDateTime start = startOfDay.plusHours(startTime.getHour()).plusMinutes(startTime.getMinute());
        LocalDateTime stop;
        
        stop = startOfDay.plusHours(stopTime.getHour()).plusMinutes(stopTime.getMinute());
        if (startTime.equals(stopTime) || stopTime.isBefore(startTime)) {
            stop = stop.plusDays(1);
        }
        
         System.err.println(start);
         System.err.println(stop);
        
         
           long minutesBetween = ChronoUnit.MINUTES.between(start,stop );
        long hoursBetween = ChronoUnit.HOURS.between(start, stop);
        System.err.println(minutesBetween);
        System.err.println(hoursBetween + "  = " + minutesBetween/60);

        int fastSpeed =(int) Math.ceil(650.0 * 60 / minutesBetween );
        System.err.println(fastSpeed);
        
        
        System.err.println(String.format("The fastest train is %s.","\"ER-200\"" ));
        System.err.println(String.format("It's speed is %d km/h, approximately.",fastSpeed ));
    }

    
    
     @Test
    public void time2() {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        LocalTime startTime = LocalTime.parse("00:01",formatter);
        LocalTime stopTime = LocalTime.parse("00:01",formatter);
        
        LocalDateTime startOfDay = LocalDateTime.now().with(LocalTime.MIN);
        System.err.println(startOfDay);
         
        LocalDateTime start = startOfDay.plusHours(startTime.getHour()).plusMinutes(startTime.getMinute());
        LocalDateTime stop;
        
        stop = startOfDay.plusHours(stopTime.getHour()).plusMinutes(stopTime.getMinute());
        if (startTime.equals(stopTime) || stopTime.isBefore(startTime)) {
            stop = stop.plusDays(1);
        }
        
         System.err.println(start);
         System.err.println(stop);
        
         
           long minutesBetween = ChronoUnit.MINUTES.between(start,stop );
        long hoursBetween = ChronoUnit.HOURS.between(start, stop);
        System.err.println(minutesBetween);
        System.err.println(hoursBetween + "  = " + minutesBetween/60);

        int fastSpeed =(int) Math.ceil(650.0 * 60 / minutesBetween );
        System.err.println(fastSpeed);
        
        
        System.err.println(String.format("The fastest train is %s.","\"ER-200\"" ));
        System.err.println(String.format("It's speed is %d km/h, approximately.",fastSpeed ));
    }

    
    @Test
    public void time() {

               String data = "3\n"
                + "\"ER-200\" 06:43 10:40\n"
                + "\"Red Arrow\" 23:55 07:55\n"
                + "\"Express\" 23:59 08:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        LocalTime startTime = LocalTime.parse("06:43",formatter);
        LocalTime stopTime = LocalTime.parse("10:40",formatter);
        
        LocalDateTime startOfDay = LocalDateTime.now().with(LocalTime.MIN);
        System.err.println(startOfDay);
         
        LocalDateTime start = startOfDay.plusHours(startTime.getHour()).plusMinutes(startTime.getMinute());
        LocalDateTime stop;
        
        stop = startOfDay.plusHours(stopTime.getHour()).plusMinutes(stopTime.getMinute());
        if (stopTime.isBefore(startTime)) {
            stop = stop.plusDays(1);
        }
        
         System.err.println(start);
         System.err.println(stop);
        
        long minutesBetween = ChronoUnit.MINUTES.between(start,stop );
        long hoursBetween = ChronoUnit.HOURS.between(start, stop);
        System.err.println(minutesBetween);
        System.err.println(hoursBetween + "  = " + minutesBetween/60);

        int fastSpeed =(int) Math.ceil(650.0 * 60 / minutesBetween );
        System.err.println(fastSpeed);
        
        
        System.err.println(String.format("The fastest train is %s.","\"ER-200\"" ));
        System.err.println(String.format("It's speed is %d km/h, approximately.",fastSpeed ));
    }

}
