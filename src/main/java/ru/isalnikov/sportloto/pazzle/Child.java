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
 class Child extends Base {
    //@Override
    private void print() {
        System.out.println("2");
    }
    public static void main(String[] args) {
        Base obj = new Child ();
       // obj.print();
    }
}
