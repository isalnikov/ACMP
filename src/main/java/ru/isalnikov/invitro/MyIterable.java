package ru.isalnikov.invitro;

/**
 *
 * @author Igor Salnikov  <isalnikov.com>
 */
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;

public interface MyIterable<E> extends Iterable<E> {

    MyIterable<E> filter(@Nonnull Predicate<E> predicate);

    <T> MyIterable<T> transform(@Nonnull Function<E, T> transformer);

    <T> T aggregate(@Nullable T initValue, @Nonnull Aggregator<E, T> aggregator);

    SortedSet<E> toSet(@Nonnull Comparator<E> comarator);

    List<E> toList();

    @Nullable
    E findFirst(@Nonnull Predicate<E> predicate);

    public static interface Predicate<T> {

        boolean apply(@Nullable T element);
    }

    public static interface Function<F, T> {

        @Nullable
        T apply(@Nullable F element);
    }

    public static interface Aggregator<F, T> {

        @Nullable
        T apply(@Nullable T aggregator, @Nullable F element);
    }

}
