/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.invitro;

/**
 *
 * @author Igor Salnikov  <igor.salnikov@stoloto.ru>
 */
import java.util.Iterator;

public class MyIterableImplIterator<E> implements Iterator<E> {

    private MyIterableImpl<E> myIterable;

    public MyIterableImplIterator(MyIterableImpl<E> myIterable) {
        this.myIterable = myIterable;
    }

    @Override
    public boolean hasNext() {
        return myIterable.element() != null;
    }

    @Override
    public E next() {
        final E element = myIterable.element();
        myIterable = myIterable.next();
        return element;
    }
    
    public MyIterableImpl<E> getMyIterable() {
        return myIterable;
    }
}
