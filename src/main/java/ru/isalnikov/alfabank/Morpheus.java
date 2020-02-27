package ru.isalnikov.alfabank;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 
 * https://tjournal.ru/etc/passwd
 
 * https://planetcalc.ru/2463/
 * 
 * чпедк ъюолт пивз кгояшнас ецвлтт чх гшнбш шэфгы, ьь вж пбъбжфшо бьызкб лаш фсзэсэже цоыэже: йуакье,еяц,якто,ььыз,дфо,ьуфн 25,95,36,17,14,49. вэъфщяь чг ьрсеоъш ф вдбнсз в ээс.
 * 
 * ключ : ПЛАТОН
 * 
 * @author Igor Salnikov isalnikov.com
 */
public class Morpheus {
    public static void main(String[] args) {
        //четыре,два,пять,ноль,один,три 19,46,58,58,50,131
        
      args = new String[] {"19,46,58,58,50,131","4,2,5,0,1,3"};
        
        
        int[] arr1 = Arrays.asList(args[0].split(",")).stream().mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.asList(args[1].split(",")).stream().mapToInt(Integer::parseInt).toArray();
        
        
        
        Optional<String> s = Stream.iterate(0,i->arr2[i])
                .map(res -> arr1[res])
                .skip(1)
                .limit(arr2.length)
                .map(Object::toString)
                .reduce((a,b)-> a+ ", " + b);
        
        if(s.isPresent()){
         //   s.map(s -> new StringBuilder(s).reverse().toString());
        }
        System.out.println(String.format("%s-%s-%s-%s-%s-%s", s.get().split(",")));
    }
}
