/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.yandex;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
public class RandomMain {

   public static final Random R = new Random(System.currentTimeMillis()/2);
   
   public  int rand2(){
       return R.nextInt(2);
   }
   
      public  int rand3(){
       int s = 0;
          for (int i = 0; i < 10; i++) {
              s = s | (1 << rand2());
              
          }
  
       return s % 3;
   }
      public  int rand3_1(){
          while (true) {          
              
              int a = rand2();
              int b = rand2();
              
              if(a == 0 && b ==0) return 0;
              if(a == 1 && b ==0) return 1;
              if(a == 0 && b ==1) return 2;
          }
   }
   
    public static void main(String[] args) {
        
        RandomMain rm = new RandomMain();
        
        HashMap<Integer,AtomicInteger> map = new HashMap<>();
        for (int i = 0; i < 100_000_000; i++) {
            int next = rm.rand3();
            
            
            map.putIfAbsent(next, new AtomicInteger(0));
            map.get(next).incrementAndGet();
            
        }
        
        System.out.println(map);
    }
    
}
