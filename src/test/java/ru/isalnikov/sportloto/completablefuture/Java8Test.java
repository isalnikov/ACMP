package ru.isalnikov.sportloto.completablefuture;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

/**
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
@Log4j2
public class Java8Test {
    
    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(Java8Test.class);

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
    public void testMap() throws InterruptedException {

//CompletableFuture[] futures = findPricesStream("myPhone")
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
                = persons.stream()
                        .map(p -> CompletableFuture.supplyAsync(
                        () -> renamePerson((Person) p), es))
                        .map(f -> f.thenAccept(System.out::println))
                        .toArray(size -> new CompletableFuture[size]);

        CompletableFuture.allOf(futures).join();

        persons.stream().forEach(p -> System.out.println(p.fullName));

        es.shutdown();
        
        final boolean done = es.awaitTermination(1, TimeUnit.MINUTES);
       
       log.info("Все ли письма были отправлены? {}", done);

    }

}
