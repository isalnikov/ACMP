package ru.isalnikov.acmp.acmp44;

/**
 * Задана последовательность, состоящая только из символов ‘>’,
 * ‘<’ и ‘-‘. Требуется найти количество стрел, которые спрятаны в этой последовательности. Стрелы – это подстроки вида ‘>>-->’
 * и ‘<--<<’.
 *
 * Входные данные
 *
 * В первой строке входного файла INPUT.TXT записана строка, состоящая из символов ‘>’,
 * ‘<’ и ‘-‘ (без пробелов). Строка состоит не более, чем из 250 символов.
 *
 * @author Igor Salnikov
 * <admin@isalnikov.com>
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
        int count = 0;
        if (in.hasNext()) {
            String line = in.nextLine();

            String s1 = ">>-->";
            String s2 = "<--<<";
            if (line != null && !line.isEmpty()) {
                for (int i = 0; i < line.length() - s1.length() + 1; i++) {
                    String st = line.substring(i, i + 5);

                    if (st.equals(s1) || st.equals(s2)) {
                        count++;
                    }

                }
            }
        }
        out.print(count);
        out.flush();
    }

}
