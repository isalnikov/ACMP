package ru.isalnikov.sportloto;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class CHS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        ConcurrentHashMap<String,String> certificationCosts = new ConcurrentHashMap<>();
        Set concurrentHashSet = ConcurrentHashMap.newKeySet();
        concurrentHashSet.add("OCEJWCD"); //OK

        concurrentHashSet.add("1"); //OK
        concurrentHashSet.add("2"); //OK
        concurrentHashSet.add("3"); //OK
        concurrentHashSet.add("3"); //OK
        concurrentHashSet.contains("OCEJWCD"); //OK
        //concurrentHashSet.remove("OCEJWCD"); //OK
        

         ExecutorService service = Executors.newFixedThreadPool(10);
         Random random = new Random();


        for (int i = 0; i < 1000; i++) {
            service.execute(() -> {
              concurrentHashSet.add(""+random.ints(0, 10).findFirst().getAsInt());
            });

        }

        service.awaitTermination(5, TimeUnit.SECONDS);
        service.shutdown();
        
        
        System.out.println(concurrentHashSet);

    }

}
