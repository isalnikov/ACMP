/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.jcip;

/**
 *
 * @author i.salnikov
 */
public class ImplClass extends AClass{

    @Override
    String name() {
      return this.getClass().getCanonicalName();
    }
    
}
