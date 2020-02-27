package ru.isalnikov.yandex.sorts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.spark_project.guava.collect.Lists;

/**
 *
 * @author Igor Salnikov isalnikov.com
 */
public class StringSort {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(); //"1201", "1202", "1198"
        list.add("1201");
        list.add("1202");
        list.add("1198");

        //System.out.println(list);

        //list.stream().sorted().forEachOrdered(System.out::println);
        
        
        
        HashMap<String, String> hm = new HashMap<>();
        hm.put("1198", "1198");
        hm.put("1201", "1201");
        hm.put("1202", "1202");
        
        
        System.out.println(hm);
        
        
        LinkedHashMap<String, String> lhm = new LinkedHashMap<>();
        lhm.put("1198", "1198");
        lhm.put("1202", "1202");
        lhm.put("1201", "1201");
        
        System.out.println(lhm);
        
         lhm.get("1198");
        
        System.out.println(lhm);
        
        
        LinkedHashMap<Integer, String> l = new LinkedHashMap<Integer, String>(15, 0.75f, true) {
            {
                put(1, "obj1");
                put(15, "obj15");
                put(4, "obj4");
                put(38, "obj38");
            }
        };

        System.out.println(l);

// {1=obj1, 15=obj15, 4=obj4, 38=obj38}
        l.get(1);
        //l.get(4);
        System.out.println(l);
        //{15=obj15, 38=obj38, 1=obj1, 4=obj4}



        
        
        
        
    }
}
