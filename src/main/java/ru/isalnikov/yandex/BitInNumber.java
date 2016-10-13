package ru.isalnikov.yandex;

/**
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
public class BitInNumber {

    public static int count(int x){
        int count = 0;
        while (x!=0) {
            x = x&(x-1);  
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
       int i = 101010101;
       
        System.out.println(count(i));
        System.out.println(Integer.toBinaryString(i).replaceAll("0", "").length());
    }
    
}
