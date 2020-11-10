package ru.isalnikov.iteco;


import java.util.List;

interface PersonService {

    public List<Person> sortByName(List<Person> person);

    public List<Person> sortByCent(List<Person> person);
}
