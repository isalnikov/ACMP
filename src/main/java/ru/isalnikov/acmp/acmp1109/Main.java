package ru.isalnikov.acmp.acmp1109;

/**
 * Напишите программу, которая считывает целое число и выводит текст с
 * упоминанием следующего и предыдущего для него чисел.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит целое число, не превосходящее 1000 по
 * абсолютной величине.
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

            out.print(String.format("The next number for the number %d is %d.\n",n ,n+1));
            out.print(String.format("The previous number for the number %d is %d.",n,n-1));
            out.flush();
        }
    }

}
