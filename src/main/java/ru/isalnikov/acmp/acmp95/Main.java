package ru.isalnikov.acmp.acmp95;

/**
 * Чтобы предсказать судьбу человека, нумеролог берет время жизни человека в
 * секундах, затем складывает все цифры этого числа. Если полученное число
 * состоит более чем из одной цифры, операция повторяется, пока в числе не
 * останется одна цифра. Затем по полученной цифре и числу операций, необходимых
 * для преобразования числа в цифру нумеролог предсказывает судьбу человека.
 * Нумеролог плохо умеет считать, а числа, с которыми он работает, могут быть
 * очень большими. Напишите программу, которая бы делала все расчеты за него.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит число N – время жизни человека в секундах (1
 * ≤ N ≤ 101000).
 *
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            String str = in.nextLine();
            int sum = 0, count = 0;
            int i = 0;
            for (; i < str.length(); i++) {
                sum += Integer.parseInt("" + str.charAt(i));

            }
            if (i > 1) {
                count = 1;
            }

            while (sum > 9) {
                sum = sum % 10 + sum / 10 % 10 + sum / 100 % 10 + sum / 1000;
                count++;
            }

            out.print(sum+" "+ count);
            out.flush();
        }

    }

}
