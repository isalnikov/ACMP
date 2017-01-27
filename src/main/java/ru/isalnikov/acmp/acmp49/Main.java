package ru.isalnikov.acmp.acmp49;

/**
 * Шаблоны
 *
 * (Время: 1 сек. Память: 16 Мб Сложность: 35%) Шаблоном размера n назовем
 * строку длины n, каждый из символов которой входит в множество {0, 1, 2, 3, 4,
 * 5, 6, 7, 8, 9, a, b, c, d, e, f, g, ?}. Шаблоны преобразуются в строки из
 * цифр по следующим правилам:
 *
 * • символы от 0 до 9 могут быть преобразованы только сами в себя; • символ a
 * может преобразован в любой из символов 0,1, 2, 3; • символ b может
 * преобразован в любой из символов 1,2,3,4; • символ c может преобразован в
 * любой из символов 2,3,4,5; • символ d может преобразован в любой из символов
 * 3,4,5,6; • символ e может преобразован в любой из символов 4,5,6,7; • символ
 * f может преобразован в любой из символов 5,6,7,8; • символ g может
 * преобразован в любой из символов 6,7,8,9; • символ ? может преобразован в
 * любой из символов от 0 до 9; Даны два шаблона: p1 и p2. Рассмотрим множество
 * S1 строк, которые могут быть получены из p1 по описанным правилам, и
 * множество S2 строк, которые могут быть получены из p2. Необходимо найти
 * количество строк, входящих в оба этих множества.
 *
 * Входные данные
 *
 * Первая строка входного файла INPUT.TXT содержит шаблон p1, вторая — шаблон
 * p2. Шаблоны имеют одинаковый положительный размер, не больше 9.
 *
 * @author Igor Salnikov
 * <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        String p1 = in.next();
        String p2 = in.next();
        int ans = 1;
        for (int i = 0; i < p1.length(); ++i) {
            ans *= valid(p1.charAt(i), p2.charAt(i));
        }
        out.print(ans);
        out.flush();
    }

    private static int valid(char c1, char c2) {
        TreeSet<Character> valid1 = gen(c1);
        TreeSet<Character> valid2 = gen(c2);
        valid1.retainAll(valid2);
        return valid1.size();
    }

    private static TreeSet<Character> gen(char c) {
        TreeSet<Character> ans = new TreeSet<>();
        if (c == '?') {
            for (char i = '0'; i <= '9'; ++i) {
                ans.add(i);
            }
            return ans;
        }
        if (Character.isDigit(c)) {
            ans.add(c);
            return ans;
        }
        int st = c - 'a';
        for (int i = 0; i < 4; ++i) {
            ans.add((char) (st + i + '0'));
        }
        return ans;
    }

}
