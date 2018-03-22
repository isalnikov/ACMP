package ru.isalnikov.sportloto.streamapi;

import java.util.Optional;

/**
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class OptionalTest {

    Optional<Integer> sum(Optional<Integer> x, Optional<Integer> y) {

        Optional<Integer> result = Optional.empty();

        if (x.isPresent() && y.isPresent()) {
            result = Optional.of(x.get() + y.get());
        } else {
            if (x.isPresent()) {
                return x;
            } else if (y.isPresent()) {
                return y;
            }
        }
        return result;
    }
    
    Optional<Integer> sum1(Optional<Integer> x, Optional<Integer> y) {
      return x.flatMap(x0 -> y.map(y0 -> x0 + y0));
    }
    
    
    Optional<Integer> sum2(Optional<Integer> x, Optional<Integer> y) {
     if (x.isPresent() || y.isPresent()) {
            return Optional.of(x.orElse(0) + y.orElse(0));
        } else {
            return Optional.empty();
        }
    }
    
}
