package ru.isalnikov.sportloto.util;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


public class UtilException {
    @FunctionalInterface
    public interface Consumer_WithExceptions<T> {
        void accept(T t) throws Exception;
    }

    @FunctionalInterface
    public interface Function_WithExceptions<T, R> {
        R apply(T t) throws Exception;
    }

    @FunctionalInterface
    public interface Supplier_WithExceptions<T> {
        T get() throws Exception;
    }

    @FunctionalInterface
    public interface Runnable_WithExceptions {
        void accept() throws Exception;
    }

    public static <T> Consumer<T> rethrowConsumer(Consumer_WithExceptions<T> consumer) {
        return t -> {
            try { consumer.accept(t); }
            catch (Exception exception) { throwAsUnchecked(exception); }
        };
    }

    public static <T, R> Function<T, R> rethrowFunction(Function_WithExceptions<T, R> function) {
        return t -> {
            try { return function.apply(t); }
            catch (Exception exception) { throwAsUnchecked(exception); return null; }
        };
    }

    public static <T> Supplier<T> rethrowSupplier(Supplier_WithExceptions<T> function) {
        return () -> {
            try { return function.get(); }
            catch (Exception exception) { throwAsUnchecked(exception); return null; }
        };
    }

    public static void uncheck(Runnable_WithExceptions t)
    {
        try { t.accept(); }
        catch (Exception exception) { throwAsUnchecked(exception); }
    }

    public static <R> R uncheck(Supplier_WithExceptions<R> supplier)
    {
        try { return supplier.get(); }
        catch (Exception exception) { throwAsUnchecked(exception); return null; }
    }

    public static <T, R> R uncheck(Function_WithExceptions<T, R> function, T t) {
        try { return function.apply(t); }
        catch (Exception exception) { throwAsUnchecked(exception); return null; }
    }

    @SuppressWarnings ("unchecked")
    private static <E extends Throwable> void throwAsUnchecked(Exception exception) throws E { throw (E)exception; }
}
