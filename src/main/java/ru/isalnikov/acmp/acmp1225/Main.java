package ru.isalnikov.acmp.acmp1225;

/**
 * Дано три символа. Требуется определить, сколько из них являются цифрами.
 *
 * При решении данной задачи необходимо реализовать функцию IsDigit(C), которая
 * возвращает 1, если символ C – цифра, и 0 – иначе.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит три символа, разделенные пробелом.
 * Гарантируется, что ASCII-коды символов превышают 32.
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
            
            String[] s = in.nextLine().split(" ");
            
            int count = 0;
            for (String s1 : s) {
                if (Character.isDigit(s1.charAt(0))) {
                    count++;
                }
            }
            
            out.print(count);
            
            out.flush();
        }
    }
    
}
