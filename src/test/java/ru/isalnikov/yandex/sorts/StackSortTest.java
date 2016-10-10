/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.yandex.sorts;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
public class StackSortTest {
    
   
    @Test
    public void testSort() {
        StackSort sort = new StackSort();
        
         int[] data = {5, 2, 1, 9, 0, 10};
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < data.length; i++) {
            stack.push(data[i]);
            
        }
        System.out.println(stack);  
        
        sort.sort(stack);
        
        
        
    }
    @Test
    public void testSort1() {
      
        
         int[] data = {5, 2, 1, 9, 0, 10};
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < data.length; i++) {
            stack.push(data[i]);
            
        }
        System.out.println(stack);  
        
        
        PriorityQueue queue = new PriorityQueue<>(stack);
        
        System.out.println(queue);

        while (!queue.isEmpty()) {            
            System.out.println(queue.poll());
        }
        
        
    }
    
}
