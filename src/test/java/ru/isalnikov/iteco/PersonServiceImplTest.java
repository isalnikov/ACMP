package ru.isalnikov.iteco;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonServiceImplTest {

    public PersonServiceImplTest() {
    }

    public static List<Person> person = Arrays.asList(new Person("3c",200) ,new Person("1a", 100), new Person("2b", 300));

    @Test
    public void testSortByName() {
        System.out.println("sortByName");
        PersonServiceImpl instance = new PersonServiceImpl();
        List<Person> result = instance.sortByName(person);
        assertEquals( Arrays.asList(new Person("1a", 100) ,new Person("2b", 300),new Person("3c",200)), result);
        
        
    }

    @Test
    public void testSortByCent() {
        System.out.println("sortByCent");
        PersonServiceImpl instance = new PersonServiceImpl();
        List<Person> result = instance.sortByCent(person);
         assertEquals( Arrays.asList(new Person("1a", 100),new Person("3c",200) ,new Person("2b", 300)), result);
    }

}
