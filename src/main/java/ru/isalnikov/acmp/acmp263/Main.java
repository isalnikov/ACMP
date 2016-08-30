package ru.isalnikov.acmp.acmp263;

/**
 * Витя работает недалеко от одной из станций кольцевой линии метро, а живет
 * рядом с другой станцией той же линии. Требуется выяснить, мимо какого
 * наименьшего количества промежуточных станций необходимо проехать Вите по
 * кольцу, чтобы добраться с работы домой.
 *
 * Входные данные
 *
 * Во входном файле INPUT.TXT заданы три числа: сначала N – общее количество
 * станций кольцевой линии, а затем i и j – номера станции, на которой Витя
 * садится, и станции, на которой он должен выйти. Станции пронумерованы подряд
 * натуральными числами 1, 2, 3, …, N (1-я станция – соседняя с N-й), N не
 * превосходит 100. Числа i и j не совпадают. Все числа разделены пробелом.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int n = in.nextInt();
            int i = in.nextInt();
            int j = in.nextInt();
            
            int min = Math.min(i,j);
            int max = Math.max(i,j);
            out.print(Math.min(max-min-1,n+min-max-1));
            out.flush();
        }
    }

}
