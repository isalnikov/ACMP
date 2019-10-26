
package ru.isalnikov.sportloto.classes;

/**
 *
 * @author i.salnikov
 */
public class NewClass {
    
    int a = 0;    
    public static void main(String[] args) {
       
        
        String s1 = "aaaa";
 
        String s2 = new String("aaaa");
        System.out.println(s1 == s2);
        s2 = s2.intern();
        s2 = "sdsd"+"sdssd"+"sdsd";
        
        StringBuilder sb = new StringBuilder();
        sb.append("sds");
        sb.append("sdsds");
        sb.toString();
        System.out.println(s1 == s2);
       
        
        
    }
    
    class $A {
        
    }
}
