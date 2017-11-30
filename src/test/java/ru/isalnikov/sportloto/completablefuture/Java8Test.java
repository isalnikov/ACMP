package ru.isalnikov.sportloto.completablefuture;

import java.util.function.Consumer;
import org.junit.Test;

/**
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class Java8Test {

    @FunctionalInterface
    interface Converter<F, T> {

        T to(F from);
    }

    interface PersonFactory<P extends Person> {

        P create(String firstName, String lastName);
    }

    class Person {

        public String firstName;
        public String lastName;

        @Override
        public String toString() {
            return  firstName + " " + lastName;
        }

        
        
        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            
            
        }

    }

    @Test
    public void testConsumer() {
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));
    }
    
    @Test
    public void testPersonFactory() {
       PersonFactory<Person> personFactory = Person::new;
       Person person = personFactory.create("Peter", "Parker");
       System.out.println(person);    // 123
    }

    @Test
    public void testTo() {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.to("123");
        System.out.println(converted);    // 123
    }

}
