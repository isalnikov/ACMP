/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp178;

import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Consumer;
import static java.util.function.Function.identity;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest2 {

    
    Consumer<String> out = System.out::println;
    
    @Test
    public void test5() {

        Comparator<? super Map.Entry<Integer, Long>> maxValueComparator = (
                entry1, entry2) -> entry1.getValue().compareTo(
                        entry2.getValue());

        IntStream intStream = IntStream.of(1, 2, 3, 2, 3, 1, 2, 1);

        Optional<Map.Entry<Integer, Long>> maxValue
                = intStream
                .boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .peek(System.out::println)
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .peek(System.out::println)
                .findFirst();
                //.min(maxValueComparator.reversed());

        assertEquals((long) 1L, (long) maxValue.get().getKey());
    }
    @Test
    public void test() {

        Comparator<? super Map.Entry<Integer, Long>> maxValueComparator = (
                entry1, entry2) -> entry1.getValue().compareTo(
                        entry2.getValue());

        IntStream intStream = IntStream.of(1, 2, 3, 2, 3, 1, 2, 1);

        Optional<Map.Entry<Integer, Long>> maxValue
                = intStream
                .boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .peek(System.out::println)
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .peek(System.out::println)
                .findFirst();
                //.min(maxValueComparator.reversed());

        assertEquals((long) 1L, (long) maxValue.get().getKey());
    }

    @Test
    public void test1() {

        Comparator<? super Map.Entry<Integer, Long>> mixValueComparator = (
                entry1, entry2) -> entry1.getValue().compareTo(
                        entry2.getValue());
        
        Comparator<? super Map.Entry<Integer, Long>> minByKeyAndMaxByValueComparator = (entry1, entry2) -> {
            int cmp = Long.compare(entry1.getValue(), entry2.getValue()); 
            if(cmp == 0 ) {
                cmp = Integer.compare(entry2.getKey(), entry1.getKey());
            }
            return cmp;
            
        };
         //       entry1.getValue().compareTo(entry2.getValue());

        IntStream intStream = IntStream.of(-2, -3, -1, -1, 0, 0);

        //  Optional<Map.Entry<Integer, Long>>
        Optional<Entry<Integer, Long>> maxValue = intStream
                .boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                // .peek(System.out::println)
//                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                //.peek(System.out::println)
                // .forEachOrdered(System.out::println);
                //.peek(System.out::println)
                //.findFirst();
                //.limit(2)
                .max(minByKeyAndMaxByValueComparator);
                //.max(Map.Entry.comparingByValue(Long::compareTo));
        //.forEachOrdered(System.out::println);
        //.min(mixValueComparator);
          System.out.println(maxValue);
        // assertEquals((long)-1L ,(long) maxValue.get().getKey());
    }

    @Test
    public void test2() {

        Comparator<? super Map.Entry<Integer, Long>> mixValueComparator = (entry1, entry2) -> 
                //entry2.getValue().compareTo(entry1.getValue());
                 Integer.compare(entry1.getKey() , entry2.getKey());
        
        
      
        
        IntStream intStream = IntStream.of(-2, -3, -1, -1, 0, 0);
        Comparator<? super Entry<Long, List<Entry<Integer, Long>>>> maxKeyComparator = (e1,e2) ->Long.compare(e1.getKey(), e2.getKey())  ;

        // carator  = Comparator.comparing(mixValueComparator);
        //  Optional<Map.Entry<Integer, Long>>
        //Optional<List<Entry<Integer, Long>>>
        Integer maxValue = intStream
                .boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .collect(groupingBy(key->key.getValue()))
                .entrySet()
                .stream()
                .max(maxKeyComparator)
                .map(e->e.getValue())
                .get()
                .stream()
                .sorted(mixValueComparator)
                .findFirst()
                .get().getKey();
                
        //.collect(
//                        groupingBy(
//                                identity(),
//                                collectingAndThen(
//                                        maxBy(mixValueComparator), t -> t.get()
//                                )
//                        ));
        //.entrySet()
        //.stream() // Entry<Integer, Long>
        //.collect(collectingAndThen(
        //       groupingBy(m->m.getValue()))
        //.sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
        //                .entrySet()
        //                .stream()
        // .peek(System.out::println)
        //                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
        //   .forEach(System.out::println);
        //.peek(System.out::println)
      //  .forEach((k,v) -> System.out.println(k + " = " + v));
        //.peek(System.out::println)
        //.findFirst();
        //.limit(2)
        //.forEach((k,v) -> System.out.println("" + k + "]" + v));
        //.min(mixValueComparator);
          System.out.println(maxValue);
        // assertEquals((long)-1L ,(long) maxValue.get().getKey());
    }

}
//    .collect(
//                        groupingBy(LawInfo::getTextType,
//                                collectingAndThen(
//                                        groupingBy(LawInfo::getGame,
//                                                maxBy(comparing(LawInfo::getMinDate))),
//                                        m -> m.values()
//                                        .stream()
//                                        .map(Optional::get)
//                                        .map(LawInfo::getGame)
//                                        .collect(toList())
//                                )));
