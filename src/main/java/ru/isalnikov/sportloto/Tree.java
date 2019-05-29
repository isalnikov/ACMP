package ru.isalnikov.sportloto;

import java.util.TreeSet;

/**
 *
 * @author i.salnikov
 */
public class Tree {

    public static class Person implements Comparable<Person> {

        public Person(String Name) {
            this.Name = Name;
        }

        public String Name;

        @Override
        public int compareTo(Person o) {
            return 1;
        }
    }

    public static void main(String[] args) {
        TreeSet<Person> tree = null;

        tree = new TreeSet<>();

        Person alex = new Person("Alex");
        Person igor = new Person("Igor");

        tree.add(alex);
        tree.add(alex);
        tree.add(igor);

        tree.stream().forEach(System.out::print);

    }

}
