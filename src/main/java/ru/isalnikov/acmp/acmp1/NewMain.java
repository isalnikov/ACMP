
package ru.isalnikov.acmp.acmp1;

import java.io.IOException;


class NewMain {

    public static void main(String[] x) throws IOException {
        int b, n = 0, s = 0;
        while ((b = System.in.read()) > -1) n = b > 45 || (s += n) < 0 ? n * 10 + b - 48 : 0;
        System.out.print(s);
    }
    
}
