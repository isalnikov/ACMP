package ru.isalnikov.acmp.acmp1038;

/**
 * Портос хочет украсить золотым шитьем свою перевязь. Он знает, что один
 * сантиметр золотого шитья стоит один луидор. Портосу надо вышить N миллиметров
 * перевязи. Причем мастер никогда не возьмется за работу, если ему заплатят
 * меньше, чем стоит работа. И сдачу мастер никогда не отдает.
 *
 * Какое минимальное количество луидоров Портос должен заплатить мастеру за
 * работу?
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит натуральное число N (N ≤ 109) – длина
 * перевязи в миллиметрах.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            long a = in.nextLong();
            out.print((int)Math.ceil(a / 10.0));
            out.flush();
        }
    }

}
