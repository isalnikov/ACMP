package ru.isalnikov.acmp.acmp66;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Для данной буквы латинского алфавита нужно вывести справа стоящую букву на
 * стандартной клавиатуре. При этом клавиатура замкнута, т.е. справа от буквы
 * «p» стоит буква «a», от буквы «l» стоит буква «z», а от буквы «m» — буква
 * «q».
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит один символ — маленькую букву латинского
 * алфавита.
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT следует вывести букву стоящую справа от заданной
 * буквы, с учетом замкнутости клавиатуры.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
public class Main {
    static String key = "qwertyuiopasdfghjklzxcvbnmq";
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
                 String s = in.nextLine();
                 out.print(key.charAt(key.indexOf(s)+1));
                 out.flush();
        }
    }
}
