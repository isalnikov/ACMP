package ru.isalnikov.jugru;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author i.salnikov
 */
public class NewClass {
    
    interface Hunam {

        default String sound() {
            return "Hello";
        }
    }

    interface Bull {

        default String sound() {
            return "Mooo";
        }
    }
    
    static class Minotaur implements Hunam, Bull {

        public String sound() {
            return Bull.super.sound().toLowerCase();
        }
    }
    
    static class WiseMan {

        String whoAmI(int i) {
            return "int";
        }

        String whoAmI(Integer i) {
            return "Integer";
        }

        String whoAmI(Object i) {
            return "Object";
        }
    }

    static class Horse {
        
        private int speed;
        private int age;
        private String name;
        
        public Horse(int speed, int age, String name) {
            this.speed = speed;
            this.age = age;
            this.name = name;
        }
        
    }
    
    static class A {
        
        String s = "pi";
        
        A() {
            s += "pu";
        }
    }
    
    static class B extends A {
        
        private B() {
            s += "pa";
        }
    }
    
    public static void main(String[] args) {
        Horse l1 = new Horse(5, 3, "lindy");
        Horse l2 = new Horse(4, 3, "lindddff");
        Horse l3 = new Horse(6, 5, "sl");
        System.out.println(5 / 3);
        System.out.println(4 / 3);
        System.out.println(6 / 5);
        Horse[] hh = {l1, l3, l2};
        Arrays.sort(hh, Comparator.comparingInt(o -> o.speed / o.age));
        System.out.println(hh[0].name);
        
        int l = 0x80000000;
        l = l << 1;
        System.out.println(l);
        
        System.out.println(new B().s);
        Minotaur m = new Minotaur();
        System.out.println(m.sound());
        
        WiseMan w = new WiseMan();
        System.out.println(w.whoAmI(1));
        System.out.println(w.whoAmI(Integer.valueOf(1)));
        long ll = 1;
        System.out.println(w.whoAmI((ll)));
        
        Long L = 1L;
        System.out.println(w.whoAmI((L)));
        byte b = 1;
        System.out.println(w.whoAmI(b));
        Double d = 1D;
        System.out.println(w.whoAmI(d));
    }
    
}
