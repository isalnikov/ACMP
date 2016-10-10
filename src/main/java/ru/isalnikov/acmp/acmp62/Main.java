package ru.isalnikov.acmp.acmp62;

/**
 * Известно, что шахматная доска имеет размерность 8х8 и состоит из клеток 2х
 * цветов, например, черного и белого (см. рисунок). Каждая клетка имеет
 * координату, состоящую из буквы и цифры. Горизонтальное расположение клетки
 * определяется буквой от A до H, а вертикальное – цифрой от 1 до 8. Заметим,
 * что клетка с координатой А1 имеет черный цвет. Требуется по заданной
 * координате определить цвет клетки.
 *
 * Входные данные
 *
 * В единственной строке входного файла INPUT.TXT записана координата клетки на
 * шахматной доске: всего два символа – буква и цифра (без пробелов).
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT нужно вывести «WHITE», если указанная клетка имеет
 * белый цвет и «BLACK», если она черная.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public enum Result {

        BLACK, WHITE;

        static String letters = "ABCDEFGH";
        static String numbers = "12345678";

        static HashMap<String, String> map = new HashMap<>();

        static {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    String key = "" + letters.charAt(i) + numbers.charAt(j);
                    Result result = ((i + j) & 1) == 0 ? Result.BLACK : Result.WHITE;
                    map.put(key, result.toString());

                }

            }
        }

        public static String getResultColor(String pos) {
            return map.get(pos);

        }

    }

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        String pos = in.nextLine();
        out.print(Result.getResultColor(pos));
        out.flush();
    }

}
