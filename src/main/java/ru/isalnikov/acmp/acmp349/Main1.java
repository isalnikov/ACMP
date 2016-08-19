package ru.isalnikov.acmp.acmp349;

/**
 * Необходимо вывести все простые числа от M до N включительно.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит два натуральных числа M и N, разделенных
 * пробелом (2 ≤ M ≤ N ≤ 10^6)
 *
 *
 *
 *
 */
import java.math.BigInteger;

class Main1 {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        BigInteger bi = BigInteger.valueOf(m);
        int count = 0;
        if (bi.isProbablePrime(5)) {
            count++;
        }
        
        //TODO  проверка на четность ...
        if((m&1)==1 ) m = m+1;

        while (m <= n) {
            bi = BigInteger.valueOf(m);
            if (bi.isProbablePrime(5)) {
                count++;
            }
            m=m+2;
        }
        if (count == 0) {

        }
        System.err.println(count);
    }
}
