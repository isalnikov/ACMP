package ru.isalnikov.acase.task3;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Написать многопоточное приложение которое будет выдавать с задержкой в 1
 * секунду на консоль в одном потоке слово tik в другом tak
 *
 * решение через Exchanger
 */
public class Main {

    public static Exchanger<String> exchanger = new Exchanger<>();
    public static String tak = "tak";
    public static String tik = "tik";

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {

                try {

                    tak = exchanger.exchange(tik);
                    Thread.sleep(2000);
                    System.out.println(tak + ": " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:ss")));

                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {

                try {

                    tik = exchanger.exchange(tak);
                    Thread.sleep(1000);
                    System.out.println(tik + ": " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:ss")));

                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();

    }
}
