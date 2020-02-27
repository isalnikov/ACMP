package ru.isalnikov.sportloto;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Igor Salnikov isalnikov.com
 */
public class TaskScheduleServiceTest {
    
   


    @Test
    public void testAdd() throws InterruptedException {
        
      
        final String name = "name";
         Runnable task = () -> System.out.println(name +" : " + Thread.currentThread().getName() + " " + LocalTime.now());
         
        System.out.println(task.toString());
         
        long initialDelay = 0L;
        long delay = 100L;
        TimeUnit unit = TimeUnit.MILLISECONDS;
        TaskScheduleService instance = new TaskScheduleService();
        ScheduledFuture result = instance.add(name, task, initialDelay, delay, unit);
        
        Thread.sleep(1000);
     
    }
    
}
