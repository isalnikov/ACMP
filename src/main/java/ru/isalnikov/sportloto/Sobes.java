package ru.isalnikov.sportloto;

/**
 *
 * m1.1 m2.1 m2.2 m1.2
 *
 *
 * @author Igor Salnikov
 */
import static java.lang.System.out;

public class Sobes {

    public synchronized void m1() throws InterruptedException {
        out.println("m1.1");
        wait();
        out.println("m1.2");
    }

    public synchronized void m2() {
        out.println("m2.1");
        notifyAll();
        out.println("m2.2");
    }

    public static void main(String[] args) {
        Sobes s = new Sobes();

        new Thread(() -> {
            try {
                s.m1();
            } catch (InterruptedException e) {
            }
        }).start();

        new Thread(() -> {
            s.m2();
        }).start();
    }
    
}
