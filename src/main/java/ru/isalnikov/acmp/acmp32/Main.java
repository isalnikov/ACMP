package ru.isalnikov.acmp.acmp32;

/**
 * В конторе «Рога и Копыта» подходит время подведения годового баланса. В
 * бухгалтерию поступили сведения о том, что, согласно документам, суммарный
 * расход составил а рублей, a суммарный приход – b рублей. Поскольку с реальным
 * положением дел эти цифры все равно не имеют ничего общего, бухгалтер решил
 * реализовать следующую свою идею. Как известно, при наборе чисел на компьютере
 * люди часто вводят цифры в неправильном порядке. Поэтому бухгалтер хочет найти
 * такой способ переставить цифры в числах a и b, чтобы в результате разность
 * a-b (и, соответственно, количество денег, которые он положит к себе в
 * карман), была максимальна, а в случае можно будет сослаться на ошибку
 * секретаря. При этом нельзя забывать о знаке чисел и о том, что ноль не может
 * быть первой цифрой числа. Напишите программу, которая поможет бухгалтеру.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит два целых числа a и b (-109 < a,b < 109).
 */
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    public static String stringSwap(String str, int x, int y) {

        if (x < 0 || x >= str.length() || y < 0 || y >= str.length()) {
            return "Invalid index";
        }

        char arr[] = str.toCharArray();
        char tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;

        return new String(arr);
    }

    private static void solve(Scanner in, PrintWriter out) {

        Long a = in.nextLong();
        Long b = in.nextLong();

        int asign = a >= 0 ? 1 : -1;
        int bsign = b >= 0 ? 1 : -1;

        //TODO  если есть ноль то переставить 
        String as = ((Long) Math.abs(a)).toString().chars()
                .map(Character::getNumericValue)
                .mapToObj(Integer::valueOf)
                .sorted(a > 0 ? Comparator.reverseOrder() : Comparator.naturalOrder())
                .map(s -> s.toString())
                .collect(Collectors.joining());

        if (as.startsWith("0") && as.length() > 1) {
            for (int i = 0; i < as.length(); i++) {
                if (as.charAt(i) != '0') {
                    as = stringSwap(as, 0, i);
                    break;
                }

            }
        }

        String bs = ((Long) Math.abs(b)).toString().chars()
                .map(Character::getNumericValue)
                .mapToObj(Integer::valueOf)
                .sorted(b < 0 ? Comparator.reverseOrder() : Comparator.naturalOrder())
                .map(s -> s.toString())
                .collect(Collectors.joining());

        if (bs.startsWith("0") && bs.length() > 1) {
            for (int i = 0; i < bs.length(); i++) {
                if (bs.charAt(i) != '0') {
                    bs = stringSwap(bs, 0, i);
                    break;
                }

            }
        }

        out.print(asign * Long.parseLong(as) - bsign * Long.parseLong(bs));
        out.flush();
    }
}
