package ru.isalnikov.acmp.acmp6;

/**
 * Совсем недавно Вася занялся программированием и решил реализовать собственную
 * программу для игры в шахматы. Но у него возникла проблема определения
 * правильности хода конем, который делает пользователь. Т.е. если пользователь
 * вводит значение «C7-D5», то программа должна определить это как правильный
 * ход, если же введено «E2-E4», то ход неверный. Так же нужно проверить
 * корректность записи ввода: если например, введено «D9-N5», то программа
 * должна определить данную запись как ошибочную. Помогите ему осуществить эту
 * проверку!
 *
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String ins = "C7-D5";
        String ins1 = "E2-E4";
        String ins3 = "BSN";

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static enum Result {

        YES, NO, ERROR;
    }

    private static Pattern desk = Pattern.compile("^[A-H][1-8]-[A-H][1-8]$");

    private static void solve(Scanner in, PrintWriter out) {
        String n = in.nextLine();
        Matcher m = desk.matcher(n);
        //a[i,j] -> a[i+2,j+1] || a[i+1,j+2]
        if (m.matches()) {
            if ((Math.abs(Character.getNumericValue(n.charAt(0)) - Character.getNumericValue(n.charAt(3))) == 2
                    && Math.abs(Character.getNumericValue(n.charAt(1)) - Character.getNumericValue(n.charAt(4))) == 1)

                    || (Math.abs(Character.getNumericValue(n.charAt(0)) - Character.getNumericValue(n.charAt(3))) == 1
                    && Math.abs(Character.getNumericValue(n.charAt(1)) - Character.getNumericValue(n.charAt(4))) == 2)) {
                out.println(Result.YES);
            } else {
                out.println(Result.NO);
            }
        } else {
            out.println(Result.ERROR);
        }

    }

}
