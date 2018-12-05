/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.sportloto.pazzle;

/**
 *
 * @author i.salnikov
 */
public class NewClass {
    
  public int myFunc() {
    try{
        return 1;
    }finally{
        return 2;
    }
}
  
  public int myFunc1() {
    try{
        System.exit(0);
        return 1;
    }finally{
        return 2;
    }
}
  
    public int myFunc3() {
    throw  new IllegalArgumentException();
    //return 1;
}


    public static void main(String[] args) {
        NewClass obj = new NewClass ();
        System.out.println( obj.myFunc()) ;
        System.out.println( obj.myFunc1()) ;
    }
}

