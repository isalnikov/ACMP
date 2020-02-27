/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.invitro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.stream.Stream;

/**
 *
 * @author Igor Salnikov  <isalnikov.com>
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MyIterableImpl<E> implements MyIterable<E> {
    
    private volatile E element;
    private final Supplier<E> elementSupplier;
    private final Supplier<MyIterableImpl<E>> nextSupplier;
    private volatile MyIterableImpl<E> next;

    private static final MyIterableImpl<?> empty = new MyIterableImpl<>();

    public MyIterableImpl() {
        this.element = null;
        this.elementSupplier = null;
        this.nextSupplier = null;
    }

    public MyIterableImpl(Supplier<E> elementSupplier, Supplier<MyIterableImpl<E>> nextSupplier) {
        this.element = null;
        this.elementSupplier = Objects.requireNonNull(elementSupplier);
        this.nextSupplier = Objects.requireNonNull(nextSupplier);
    }

    public static <E> MyIterableImpl<E> of(E... elements) {
        return of(Arrays.asList(elements).iterator());
    }
    
    public static <E> MyIterableImpl<E> of(Iterator<E> iterator) {
        if (iterator.hasNext()) {
            return new MyIterableImpl<>(
                () -> iterator.next(), 
                () -> of(iterator));
        } else {
            return (MyIterableImpl<E>)empty;
        }
    }

    @Override
    public MyIterableImplIterator<E> iterator() {
        return new MyIterableImplIterator<>(this);
    }

    protected E element() {
        if (element == null && elementSupplier != null) {
            element = elementSupplier.get();
        }
        return element;
    }

    protected MyIterableImpl<E> next() {
        if (next == null) {
            next = nextSupplier.get();
        }
        return next;
    }

    @Override
    public MyIterableImpl<E> filter(@Nonnull Predicate<E> predicate) {
        MyIterableImplIterator<E> iterator = iterator();

        return new MyIterableImpl<>(
            () -> {
                while (iterator.hasNext()) {
                    E element = iterator.next();
                    if (predicate.apply(element)) {
                        return element;
                    }
                }
                return null;
            },
            () -> iterator.getMyIterable().filter(predicate));
    }

    @Override
    public <T> MyIterableImpl<T> transform(@Nonnull Function<E, T> transformer) {
        return new MyIterableImpl<>(
            () -> {
                if (element() != null) {
                    return transformer.apply(element());
                } else {
                    return null;
                }
            }, 
            () -> next().transform(transformer));
    }

    @Override
    public <T> T aggregate(@Nullable T initValue, @Nonnull Aggregator<E, T> aggregator) {
        for (E element : this) {
            initValue = aggregator.apply(initValue, element);
        }
        
        return initValue;
    }

    @Override
    public SortedSet<E> toSet(@Nonnull Comparator<E> comarator) {
          Stream<E> targetStream = StreamSupport.stream(this.spliterator(), false);
          return targetStream.sorted(comarator).collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
         
    }

    @Override
    public List<E> toList() {
       Stream<E> targetStream = StreamSupport.stream(this.spliterator(), false);
       return targetStream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    
    }

    @Override
    public @Nullable E findFirst(@Nonnull Predicate<E> predicate) {
        for (E element : this) {
            if (predicate.apply(element)) {
                return element;
            }
        }

        return null;
    }
}