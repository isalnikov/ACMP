package ru.isalnikov.iteco;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    Comparator<Person> name = Comparator.comparing(person -> person.name);
    Comparator<Person> cent = Comparator.comparingLong(person -> person.cent);

    @Override
    public List<Person> sortByName(final List<Person> person) {
        if (person == null || person.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        Collections.sort(person, name);

        return person;
    }

    @Override
    public List<Person> sortByCent(List<Person> person) {
        if (person == null || person.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        Collections.sort(person, cent);

        return person;
    }

}
