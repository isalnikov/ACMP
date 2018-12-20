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
 * Монета , генератор get01 get012
 *
 * Наслаждайтесь:
 *
 * P(00) + P(01) + P(10) + P(11) = 1 - полная группа равновероятных событий
 *
 * P(11) - надо исключить, тогда P(00|^11) + P(01|^11) + P(10|^11) = 1
 *
 * P(00|^11) = P(00) + P(11)*P(00) + P(11)*P(11)*P(00) + ... = 0,25 + 0,25*0,25
 * + 0,25*0,25*0,25 + ...
 *
 * Получаем геометрическую прогрессию. Сумма членов бесконечно убывающей
 * прогрессии равна S = b1/(1-q) => P(00|^11) = 0,25/(1-0,25) = 1/3
 *
 * Аналогично P(01|^11) = P(10|^11) = 1/3
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
          for (int i = 0; i < 6; i++) {
              s+=rand2();
              
          }
  
       return s % 3;
   }
      public  int rand3_1(){
          while (true) {          
              
              int a = rand2();
              int b = rand2();
              
              if(a == 0 && b == 0) return 0;
              if(a == 1 && b == 0) return 1;
              if(a == 0 && b == 1) return 2;
          }
   }
    public int rand3_2() {
        while (true) {
            int r4 = rand2() * 2 + rand2();
            if (r4 != 3) {
                return r4;
            }
        }

    }
   

 

    public int rand3_3() {
        int s = 0;
        for (int i = 0; i < 256; i++) {
            s += rand2();

        }

        return s % 3;
    }

    public int rand3_1_1() {
        while (true) {

            int a = rand2();
            int b = rand2();

            if (a == 0 && b == 0) {
                return 0;
            }
            if (a == 1 && b == 0) {
                return 1;
            }
            if (a == 0 && b == 1) {
                return 2;
            }
        }
    }


    public static void main(String[] args) {

        RandomMain rm = new RandomMain();

        HashMap<Integer, AtomicInteger> map = new HashMap<>();
        for (int i = 0; i < 10_00_000; i++) {

            int next = rm.rand3_2(); //{0=333991, 1=333340, 2=332669} {0=334002, 1=332837, 2=333161}
            
            

          //  int next = rm.rand3();


            map.putIfAbsent(next, new AtomicInteger(0));
            map.get(next).incrementAndGet();

        }

        System.out.println(map);
    }

}
