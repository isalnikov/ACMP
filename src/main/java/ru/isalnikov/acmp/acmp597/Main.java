package ru.isalnikov.acmp.acmp597;

/**
 * (Недавно на поле фермера Джона были обнаружены следы приземления летающих
 * тарелок. Об этом даже писала газета Mew Yorc Courier.
 *
 * Поле фермера Джона имеет форму круга радиусом r1. По сообщениям журналистов
 * были обнаружены два следа от летающих тарелок, имевшие форму кругов. Один из
 * них имел радиус r2, второй - радиус r3. Также сообщается, что они находились
 * внутри поля фермера Джона и не пересекались (при этом, они, возможно,
 * касались друг друга и/или границы поля).
 *
 * Поскольку журналисты часто склонны преувеличивать масштабы событий,
 * необходимо написать программу, которая будет проверять, могли ли иметь место
 * события, описанные в газете.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит три целых положительных числа - r1, r2, r3 (1
 * ≤ r1, r2, r3 ≤ 109).
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT выведите слово YES, если информация,
 * опубликованная в газете, может соответствовать правде, и слово NO - иначе.
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

            solve(in, out);
        }
    }
    private enum Answer {
        YES, NO;
    }

    private static void solve(Scanner in, PrintWriter out) {

        int r1 = in.nextInt();
        int r2 = in.nextInt();
        int r3 = in.nextInt();

        if (r2 + r3 <= r1) {
            out.print(Answer.YES);

        } else {
            out.print(Answer.NO);
        }

        out.flush();
    }

}
