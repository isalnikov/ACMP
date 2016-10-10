package ru.isalnikov.yandex;

/**
 *https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D0%BE%D0%B1%D0%BB%D0%B5%D0%BC%D0%B0_196
 * https://ru.wikipedia.org/wiki/%D0%9F%D0%BE%D0%B8%D1%81%D0%BA_%D0%B4%D0%BB%D0%B8%D0%BD%D0%BD%D0%B5%D0%B9%D1%88%D0%B5%D0%B9_%D0%BF%D0%BE%D0%B4%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B8-%D0%BF%D0%B0%D0%BB%D0%B8%D0%BD%D0%B4%D1%80%D0%BE%D0%BC%D0%B0
 * @author Igor Salnikov <admin@isalnikov.com>
 */
public class Polindrome {

    public static boolean isPolindrome(final String s) {
        boolean result = false;
        if (s == null || s.isEmpty()) {
            return result;
        }

        String s1 = s.toLowerCase().replaceAll(" ", "");
        String s2 = new StringBuilder(s1).reverse().toString();
        return s1.equals(s2);
        //return s.toLowerCase().replaceAll(" ", "").equals((s.toLowerCase().replaceAll(" ", "")).reverse().toString());

//
//        char[] array = s.toLowerCase().replaceAll(" ", "").toCharArray();
//        int n = array.length;
//        for (int i = 0; i < (n / 2); i++) {
//            if (array[i] != array[n - i - 1]) {
//                return result;
//            }
//
//        }
//        return true;
    }

    public static boolean isFastPolindrome(final String s) {
        boolean result = false;
        if (s == null || s.isEmpty()) {
            return result;
        }

        char[] array = s.toLowerCase().replaceAll(" ", "").toCharArray();
        int n = array.length;
        for (int i = 0; i < (n / 2); i++) {
            if (array[i] != array[n - i - 1]) {
                return result;
            }

        }
        return true;
    }

}
