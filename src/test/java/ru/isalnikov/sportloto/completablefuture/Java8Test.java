package ru.isalnikov.sportloto.completablefuture;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.function.Consumer;
import java.util.stream.Stream;
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
        public String fullName;

        @Override
        public String toString() {
            return firstName + " " + lastName;
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

    // https://habrahabr.ru/post/260953/
    private static Person renamePerson(Person p) {
        p.fullName = p.firstName + " : " + p.lastName;
        return p;

    }

    @Test
    public void testMap() {

//        CompletableFuture[] futures = findPricesStream("myPhone")
//.map(f -> f.thenAccept(System.out::println))
//.toArray(size -> new CompletableFuture[size]);
//CompletableFuture.allOf(futures).join();
        final ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("Поток-%d")
                .setDaemon(true)
                .build();

        final ExecutorService es = Executors.newFixedThreadPool(2, threadFactory);

        List<Person> persons = Arrays.asList(new Person("1", "2"), new Person("3", "4"));

        CompletableFuture[] futures
                = 
                        persons.stream()
                        .map(p -> CompletableFuture.supplyAsync(
                        () -> renamePerson((Person) p), es))
                        .map(f -> f.thenAccept(System.out::println))
                        .toArray(size -> new CompletableFuture[size]);

        CompletableFuture.allOf(futures).join();
        
        
        
        
        persons.stream().forEach(p -> System.out.println(p.fullName));

    }

}
