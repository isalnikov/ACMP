package ru.isalnikov.sportloto.reztsov;


import java.util.function.Function;
import java.util.stream.Stream;

/*
 * Написать метод который будет принимать на вход массив и функцию 
 * Метод должен отсортировать Массим чисел и применит к нему функцию
 * для примера передать функцию 1 - которая берет 1й элемент массива и его возвращает 
   2 - я функция берет послений элемент отсортированного массива и возвращает его
 */

/**
 *
 * @author i.salnikov
 */
public class AlexeyReztsovProblem {

    public static Stream reztsov(Stream stream, Stream<Function> a2) {
        return Stream.empty();
    }
    
    public static Stream reztsov(Stream<Integer> stream, Function<Integer,Integer> a1, Function<Integer,Integer> a2) {

//  /      return stream
//                .map(a1)
//                .collect(
//                        () -> Stream.builder(), 
//                        (Stream.Builder x, Integer y) -> x.add(y), 
//                        ( Stream.Builder values, Stream.Builder values2) -> Stream.concat(values.build(),values2.build()));
//             // .map(a2)
               // .collect(() -> Stream.builder(), (Stream.Builder x, Integer y) -> x.add(y), (values) -> Stream.of(values));
return Stream.empty();
    }
            
    
    public static void main(String[] args) {
//        //    IntStream stream = IntStream.of(1, 3, 2, 5, 4); 
//         int[] intArray = {1, 3, 2, 5, 4};
//        
//        IntStream intStream = Arrays.stream(intArray);
////        IntPredicate predicate ;
////        IntBinaryOperator op;
////        intStream
////                .sorted()
////                .reduce(op);
//        
        Function<Integer,Integer> add1 = x -> x + 1;
        Function<Integer,Integer> concat = x -> x + 1;

        //Function.identity().;
      reztsov(Stream.of(1, 3, 2, 5, 4),add1,concat).forEach(System.out::println);
      //  .filter(predicate);
    }
}