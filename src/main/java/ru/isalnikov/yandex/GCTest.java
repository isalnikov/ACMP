package ru.isalnikov.yandex;
//http://ru.stackoverflow.com/questions/451589/%D0%97%D0%B0%D0%B4%D0%B0%D1%87%D0%B8-%D0%AF%D0%BD%D0%B4%D0%B5%D0%BA%D1%81%D0%B0-%D0%BD%D0%B0-%D0%B4%D0%BE%D0%BB%D0%B6%D0%BD%D0%BE%D1%81%D1%82%D1%8C-android-developer-%D0%A1%D0%BF%D0%BE%D1%80%D0%BD%D1%8B%D0%B9-%D0%B2%D0%BE%D0%BF%D1%80%D0%BE%D1%81-%D0%9F%D0%BE%D0%B4%D1%81%D0%BA%D0%B0%D0%B6%D0%B8%D1%82%D0%B5-%D0%B3%D0%B4%D0%B5-%D1%8F
import java.util.ArrayList;

public class GCTest {

    static class A {

        private String myName;

        public A(String myName) {
            this.myName = myName;
        }
    }

    public static void main(String[] args) {
        A a1 = new A("a1");
        A a2 = new A("a2");
        ArrayList list = new ArrayList();
        list.add(a1);
        A[] mas = new A[2];
        mas[0] = a2;
        a2 = a1;
        clear(mas);
        a1 = null;
        a2 = null;
        System.gc();
        // дальше идет какой-то код
//        ...
    }

    private static void clear(A[] mas) {
        mas = null;
    }
}
