package ru.isalnikov.sportloto;

import io.netty.util.internal.ThreadLocalRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import java.util.stream.Collectors;

/**
 * http://www.baeldung.com/java-filter-stream-of-optional
 *
 * @author Igor Salnikov isalnikov.com
 */
public class OptionalTest {

    public static void main(String[] args) {
        List<Optional<String>> listOfOptionals = Arrays.asList(
                Optional.empty(), Optional.of("foo"), Optional.empty(), Optional.of("bar"));

//        List<String> filteredList = listOfOptionals.stream()
//                .filter(Optional::isPresent)
//                .map(Optional::get)
//                .collect(Collectors.toList());

        System.out.println(getValue());
        
        
        Arrays.asList(getValue(),getValue(),getValue()).stream().forEach( s->  System.out.print(" " +s)); 
                
                


    }
    
    
    
    private static Optional<Integer> getValue() {

        Integer result = ThreadLocalRandom.current().nextInt(10);
        System.out.println(result);

        if (result > 1) {
            return of(result);
        }

        return empty();

    }
    
}
