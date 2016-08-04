package ru.isalnikov.acmp.acmp7;

/**
 * Главный вождь племени Абба не умеет считать. В обмен на одну из его земель
 * вождь другого племени предложил ему выбрать одну из трех куч с золотыми
 * монетами. Но вождю племени Абба хочется получить наибольшее количество
 * золотых монет. Помогите вождю сделать правильный выбор!
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Arrays;
import static java.util.Comparator.reverseOrder;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }



    private static void solve(Scanner in, PrintWriter out) {
        String[] numbers = in.nextLine().split(" ");
        
        int longest = Arrays.stream(numbers)
                  .mapToInt(String::length)
                  .max()
                  .orElse(-1);
        
        Stream<String> stream = Arrays.stream(numbers);
        String str = stream
                .filter(s -> s.length() == longest)
                .sorted(reverseOrder()).findFirst().get();
              
        out.print(str);

    }

}
