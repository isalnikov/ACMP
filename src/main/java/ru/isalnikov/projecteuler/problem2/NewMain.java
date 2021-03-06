package ru.isalnikov.projecteuler.problem2;

//Even Fibonacci numbers
//http://stackoverflow.com/questions/9053545/finding-the-sum-of-even-valued-terms-in-fibonacci-sequence
//https://ru.wikipedia.org/wiki/%D0%A7%D0%B8%D1%81%D0%BB%D0%B0_%D0%A4%D0%B8%D0%B1%D0%BE%D0%BD%D0%B0%D1%87%D1%87%D0%B8
import java.math.BigInteger;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

//Problem 2
//Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
//
//1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
//
//By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
public class NewMain {

    public static BigInteger fibTail(int x) {
        return fibTailHelper(BigInteger.ONE, BigInteger.ZERO, BigInteger.valueOf(x));
    }

    public static BigInteger fibTailHelper(BigInteger acc1, BigInteger acc2, BigInteger x) {
        if (x.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else if (x.equals(BigInteger.ONE)) {
            return acc1.add(acc2);
        } else {
            return fibTailHelper(acc2, acc1.add(acc2), x.subtract(BigInteger.ONE));
        }
    }

    public static BigInteger fibonacciIterative(int number) {
        if (number == 1 || number == 2) {
            return BigInteger.ONE;
        }
        BigInteger fibo1 = BigInteger.ONE;
        BigInteger fibo2 = BigInteger.ONE;
        BigInteger fibonacci = BigInteger.ZERO;
        for (int i = 3; i <= number; i++) {
            fibonacci = fibo1.add(fibo2);
            fibo1 = fibo2;
            fibo2 = fibonacci;
        }
        return fibonacci;
    }

    public static String fibonacciIterativeSuite(int number) {
        return IntStream.rangeClosed(1, number)
                .boxed()
                .map(i -> fibonacciIterative(i))
                .map(BigInteger::toString)
                .collect(Collectors.joining(", "));
    }

    static class Tuple<T, U> {

        public final T _1;
        public final U _2;

        public Tuple(T t, U u) {
            this._1 = t;
            this._2 = u;
        }
    }

    public static BigInteger fibonacciTuple(int number) {
        Tuple<BigInteger, BigInteger> seed = new Tuple<>(BigInteger.ONE, BigInteger.ONE);
        UnaryOperator<Tuple<BigInteger, BigInteger>> f = x -> new Tuple<>(x._2, x._1.add(x._2));
        Stream<BigInteger> fiboStream = Stream.iterate(seed, f)
                .map(x -> x._1)
                .limit(number);

        Optional<BigInteger> sum = fiboStream
                //    .filter(n -> n.mod(new BigInteger("2")).equals(BigInteger.ZERO))
                .reduce((n1, n2) -> n1.add(n2));

        return sum.get();

    }
    
    
    static <T> Spliterator<T> takeWhile(
            Spliterator<T> splitr, Predicate<? super T> predicate) {
        return new Spliterators.AbstractSpliterator<T>(splitr.estimateSize(), 0) {
            boolean stillGoing = true;

            @Override
            public boolean tryAdvance(Consumer<? super T> consumer) {
                if (stillGoing) {
                    boolean hadNext = splitr.tryAdvance(elem -> {
                        if (predicate.test(elem)) {
                            consumer.accept(elem);
                        } else {
                            stillGoing = false;
                        }
                    });
                    return hadNext && stillGoing;
                }
                return false;
            }

        };
    }

static <T> Stream<T> takeWhile(Stream<T> stream, Predicate<? super T> predicate) {
   return StreamSupport.stream(takeWhile(stream.spliterator(), predicate), false);
}
    
    public static BigInteger fibonacciTupleLimit(int number) {
        Tuple<BigInteger, BigInteger> seed = new Tuple<>(BigInteger.ONE, BigInteger.ONE);
        UnaryOperator<Tuple<BigInteger, BigInteger>> f = x -> new Tuple<>(x._2, x._1.add(x._2));
        return  Stream.iterate(seed, f)
                .map(x -> x._1)
                .peek(x->System.err.println("map "+x))
                .limit(20)
                .filter(n -> n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO))
                .peek(x->System.err.println("filter "+x))
                .filter(x -> x.compareTo(BigInteger.valueOf(number)) < 0 )
                .peek(x->System.err.println("compareTo "+x))
                .reduce((n1, n2) -> n1.add(n2)).get();
    }
    
    public static int iter() {
        int num1 = 1;
        int num2 = 2;
        int evenSum = num2;
        //int count = 1;
        while (num2 < 4000000) {
            //System.out.println(count++);
            num1 += num2;
            num2 += num1;

            if (num1 >= 4000000 || num2 >= 4000000) {
                break;
            } else {
                if (num1 % 2 == 0) {
                    evenSum += num1;
                }

                if (num2 % 2 == 0) {
                    evenSum += num2;
                }

            }

        }

        System.out.println("The sum of even numbers is: " + evenSum);
        return evenSum;
    }
    

    public static void main(String[] args) {
//        System.out.println(fibonacciTupleLimit(4000000));
//        System.out.println(iter());
//        
//    int a = IntStream.range(1, 100).reduce(0, (left, right) -> left + right*2);
//        System.out.println(a);  
        
         IntStream.iterate(1, n->n+3)
                 .peek(n->{System.out.println(n);})
                 .allMatch(n->n < 15)
                 ;//.forEachOrdered(System.out::println);
        
    }

}
