package ru.isalnikov.sportloto;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 *
 * @author Igor Salnikov 
 */
@SuppressWarnings("unchecked")
public class LambdaVisitor<A> implements Function<Object, A> {

    private final Map<Class<?>, Function<Object, A>> functions = new HashMap<>();

    public static <A> LambdaVisitor<A> switcher() {
        return new LambdaVisitor();
    }

    public <B> Acceptor<A, B> on(Class<B> clazz) {
        return new Acceptor<>(this, clazz);
    }

    @Override
    public A apply(Object o) {
        if (!functions.containsKey(o.getClass())) {
            return functions.get(o.getClass().getSuperclass()).apply(o);
        }

        return functions.get(o.getClass()).apply(o);
    }

    public static class Acceptor<A, B> {

        private final LambdaVisitor visitor;
        private final Class<B> clazz;

        public Acceptor(LambdaVisitor<A> visitor, Class<B> clazz) {
            this.visitor = visitor;
            this.clazz = clazz;
        }

        public LambdaVisitor<A> then(Function<B, A> f) {
            visitor.functions.put(clazz, f);
            return visitor;
        }
    }
    
    public static void main(String[] args) {
      
    }
}

