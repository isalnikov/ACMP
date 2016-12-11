package ru.isalnikov.acmp.acmp81;

/**
 * Иван Васильевич пришел на рынок и решил купить два арбуза: один для себя, а
 * другой для тещи. Понятно, что для себя нужно выбрать арбуз потяжелей, а для
 * тещи полегче. Но вот незадача: арбузов слишком много и он не знает как же
 * выбрать самый легкий и самый тяжелый арбуз? Помогите ему!
 *
 * Входные данные
 *
 * В первой строке входного файла INPUT.TXT задано одно число N – количество
 * арбузов. Вторая строка содержит N чисел, записанных через пробел. Здесь
 * каждое число – это масса соответствующего арбуза. Все числа натуральные и не
 * превышают 30000.
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT нужно вывести два числа через пробел: массу
 * арбуза, который Иван Васильевич купит теще и массу арбуза, который он купит
 * себе.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int N = in.nextInt();
        int next = in.nextInt();
        int max = next, min = next;
        for (int i = 0; i < N - 1; i++) {
            next = in.nextInt();
            if (next > max) {
                max = next;
            }
            if (next < min) {
                min = next;
            }
        }

        out.print(min + " " + max);
        out.flush();

    }

}
