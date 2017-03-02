package ru.isalnikov.acmp.acmp41;

class NewClass1 {

    public static void main(String[] x) throws Exception {
        byte[] a = new byte[201];
        int b, v = 0, n = 1;
        while (System.in.read() != 10);
        for (;;) {
            b = System.in.read();
            if (b == 45) {
                n = -1;
            } else if (b >= 48 & b <= 57) {
                if (v > 0) {
                    v *= 10;
                }
                v += b - 48;
            } else {
                v *= n;
                a[v + 100]++;
                v = 0;
                n = 1;
                if (b < 0) {
                    break;
                }
            }
        }
        for (b = -1; b++ < 200;) {
            for (v = 0; v++ < a[b];) {
                System.out.print(b - 100 + ' ');
            }
        }
    }
}
