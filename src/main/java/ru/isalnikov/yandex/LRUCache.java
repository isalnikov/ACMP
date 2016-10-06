package ru.isalnikov.yandex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

//http://www.javaspecialist.ru/2012/02/java-lru-cache.html

public class LRUCache<K,V> {

  private final int MAX_CAPACITY = 10;
    
     Map<K, V> lruCache = new LinkedHashMap<K, V>(MAX_CAPACITY, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            System.err.println(lruCache);
            return size() > MAX_CAPACITY;
        }
    };
    
    
    

    public static void main(String[] args) {
        Random random = new Random();
       LRUCache<Integer,Integer>  cache = new LRUCache<>();
        for (int i = 0; i < 100_000; i++) {
               int next = random.nextInt(10);  
               cache.lruCache.put(next,next); 
        }
        
        System.out.println(cache.lruCache);
    }

}
