package ru.isalnikov.acmp.acmp13;

/**
 * Петя и Вася часто играют в различные логические игры. Недавно Петя поведал
 * Васе о новой игре «Быки и коровы» и теперь они играют в эту игру сутками.
 * Суть игры очень проста: Петя загадывает четырехзначное число, состоящее из
 * различных цифр. Вася отгадывает задуманное Петей число, перебирая возможные
 * варианты. Каждый раз Вася предлагает вариант своего числа, а Петя делает Васе
 * подсказку: сообщает количество быков и коров, после чего Вася с учетом
 * подсказки продолжает отгадывание числа до тех пор, пока не отгадает. Быки –
 * это количество цифр в предложенном Васей числе, совпадающих по значению и
 * стоящих в правильной позиции в задуманном Петей числе. Коровы – количество
 * цифр, совпадающих по значению, но находящихся в неверной позиции. Например,
 * если Петя задумал число 5671, а Вася предложил вариант 7251, то число быков
 * равно 1 (только цифра 1 на своем месте), а число коров равно 2 (только цифры
 * 7 и 5 не на своих местах). Петя силен в математике, но даже он может
 * ошибаться. Помогите Пете написать программу, которая бы по загаданному Петей
 * и предложенному Васей числам сообщала количество быков и коров.
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

        int a = in.nextInt();
        int b = in.nextInt();
        int[] ar = new int[10];
        int x, y;
        int bulls = 0;
        int cows = 0;
        for (int i = 1; i <= 9; i++) {
            ar[i] = 0;
        }
        while (a != 0) {
            x = a % 10;
            y = b % 10;
            ar[x]++;
            ar[y]++;
            if (x == y) {
                bulls++;
            }
            a /= 10;
            b /= 10;
        }
        for (int i = 1; i <= 9; i++) {
            if (ar[i] >= 2) {
                cows++;
            }
        }
        cows -= bulls;
        out.print(bulls + " " + cows);
        out.flush();
    }

}
