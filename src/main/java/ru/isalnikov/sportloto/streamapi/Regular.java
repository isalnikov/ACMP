package ru.isalnikov.sportloto.streamapi;

/**
 *
 * @author Igor Salnikov isalnikov.com
 */
public class Regular {
    
    public static void main(String[] args) {
        System.out.println("start");
        long start =  System.currentTimeMillis();
        String st = "12345".replaceAll("((((.*)*)*)*)*!","");
        System.out.println(String.format("%s ms",System.currentTimeMillis() - start));
        
    }
    
}
