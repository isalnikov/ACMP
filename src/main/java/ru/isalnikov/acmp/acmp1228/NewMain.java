package ru.isalnikov.acmp.acmp1228;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.IntStream;

public class NewMain {

    public static boolean isPrime(int x) {
        if(x<3) {
            if(x <= 0 ) return false;
            if(x == 1 ) return false;
            if(x == 2 ) return true;
        }
            
        return IntStream.rangeClosed(2, (int) (Math.sqrt(x)))
                .allMatch(n -> x % n != 0);
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int result = 0;
            
            if(isPrime(a)) result+=a;
            if(isPrime(b)) result+=b;
            if(isPrime(c)) result+=c;
            
            out.println(result);
            if (isPrime(result)) {
                out.print("Yes");
            } else {
                out.print("No");
            }
            out.flush();
        }
    }

}
