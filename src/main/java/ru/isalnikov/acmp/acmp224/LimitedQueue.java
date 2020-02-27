/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp224;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Igor Salnikov  <isalnikov.com>
 */
public class LimitedQueue  extends PriorityQueue<Integer>{
   private final int limit;

    public LimitedQueue(int limit , Comparator<Integer> comparator ) {
        super(limit, comparator);
        this.limit = limit;
    }

    @Override
    public boolean add(Integer e) {
        boolean added = super.add(e);
        while (added && size() > limit) {
            super.remove();
        }
        return added;
    }
   
   
}
