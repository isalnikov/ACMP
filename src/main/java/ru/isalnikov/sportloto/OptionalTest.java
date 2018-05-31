package ru.isalnikov.sportloto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * http://www.baeldung.com/java-filter-stream-of-optional
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class OptionalTest {

    public static void main(String[] args) {
        List<Optional<String>> listOfOptionals = Arrays.asList(
                Optional.empty(), Optional.of("foo"), Optional.empty(), Optional.of("bar"));

//        List<String> filteredList = listOfOptionals.stream()
//                .filter(Optional::isPresent)
//                .map(Optional::get)
//                .collect(Collectors.toList());
    }
}
