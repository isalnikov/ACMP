package ru.isalnikov.sportloto;

import java.util.function.Consumer;

/**
 *
 * @author Igor Salnikov isalnikov.com
 */
public class ConsumerExample {

    public  static class Person {
        public Integer age = 10;

        public Person(Integer age) {
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }
        
        
        
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Consumer<Integer> printer = x-> System.out.printf("%d долларов \n", x);
        
        printer.accept(600); // 600 долларов
        printer.andThen(printer).accept(600); // 600 долларов
        Person person = new Person(10);
        
        Consumer<Person> consumer = p-> System.out.printf("%d лет \n", (p.age+10) );
        
         consumer.andThen(consumer).accept(person); // 20 лет
         
         
    }
    
}
