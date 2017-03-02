/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp41;

import java.io.IOException;
import static java.lang.System.*;

class NewClass {

    public static void main(String[] x) throws IOException {
        byte[] a = new byte[201];
        int b;
        int v = 0;
        boolean n = false;
        while (in.read() != '\n');
        while (true) {
            b = in.read();
            if (b == '-') {
                n = true;
            } else if (b >= '0' && b <= '9') {
                if (v > 0) {
                    v *= 10;
                }
                v += b - '0';
            } else {
                if (n) {
                    v = 0 - v;
                }
                a[v + 100]++;
                v = 0;
                n = false;
                if (b == -1) {
                    break;
                }
            }
        }
        for (int i = -1; i++ < 200;) {
            for (int j = 0; j++ < a[i];) {
                out.print(i - 100);
                out.print(' ');
            }
        }
    }
}
