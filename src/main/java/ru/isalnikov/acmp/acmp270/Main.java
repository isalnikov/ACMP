package ru.isalnikov.acmp.acmp270;

/**
 * Сторонники языков Java и C++ часто спорят о том, какой язык лучше для решения
 * олимпиадных задач. Одни говорят, что в Java есть масса полезных библиотек для
 * работы со строками, хорошо реализованы механизмы чтения и вывода данных, а
 * так же радует встроенные возможности для реализации длинной арифметики. С
 * другой стороны, С++ является классическим языком, скорость выполнения
 * программ благодаря существующим компиляторам (например, Intel Compiler 10.0)
 * гораздо выше, чем у Java.
 *
 * Но сейчас нас интересует лишь небольшие отличия, а именно соглашения,
 * которыми пользуются программисты при описании имен переменных в Java и C++.
 * Известно, что для понимания значений переменных часто используют английские
 * слова или даже целые предложения, описывающие суть переменных, содержащих те
 * или иные значения. Приведем ниже правила описания переменных, которыми
 * руководствуются программисты, реализующие программы на Java и C++.
 *
 * В языке Java принято первое слово, входящее в название переменной записывать
 * с маленькой латинской буквы, следующее слово идет с большой буквы (только
 * первая буква слова большая), слова не имеют разделителей и состоят только из
 * латинских букв. Например, правильные записи переменных в Java могут выглядеть
 * следующим образом: javaIdentifier, longAndMnemonicIdentifier, name, nEERC.
 *
 * В языке C++ для описания переменных используются только маленькие латинские
 * символы и символ «_», который отделяет непустые слова друг от друга. Примеры:
 * java_identifier, long_and_mnemonic_identifier, name, n_e_e_r_c.
 *
 * Вам требуется написать программу, которая преобразует переменную, записанную
 * на одном языке в формат другого языка.
 *
 * Входные данные
 *
 * Во входном файле INPUT.TXT задано наименование переменной длиной не более 100
 * символов.
 *
 * Выходные данные
 *
 * В выходной файл OUTPUT.TXT требуется вывести аналог имени переменной в другом
 * языке. Т.е. если переменная представлена в формате Java, то следует перевести
 * в формат C++ и наоборот. В том случае, когда имя переменной не соответствует
 * ни одному из вышеописанных языков, следует вывести «Error!»
 *
 *
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static String toCamelCaseFromSnakeCase(String str) {
        int length = str.length();
        boolean nextWord = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);

            if (Character.isSpaceChar(c)) {
                continue;
            }

            if (c == '_') {
                nextWord = true;
            } else {
                boolean isUpper = Character.isUpperCase(c);
                if (nextWord) {
                    result.append(Character.toUpperCase(c));
                    nextWord = false;
                } else {
                    if (isUpper) {
                        result.append(Character.toLowerCase(c));
                    } else {
                        result.append(c);
                    }
                }
            }
        }

        return result.toString();
    }

    public static String toSnakeCase(String str, boolean inLowerCaseFashion) {
        boolean wasUpper = false;
        int length = str.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            boolean isUpper = Character.isUpperCase(c);

            if (Character.isSpaceChar(c)) {
                continue;
            }

            if (i > 0 && !wasUpper) {
                if (isUpper) {
                    result.append("_");
                }
            }

            if (inLowerCaseFashion) {
                if (isUpper) {
                    result.append(Character.toLowerCase(c));
                } else {
                    result.append(c);
                }

            } else {
                result.append(Character.toTitleCase(c));
            }

            wasUpper = isUpper;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        String param = in.nextLine();
        String result = null;

        if (param.equals("_")) {
            result = "Error!";
        } else if (param.endsWith("_") || param.startsWith("_")) {
            result = "Error!";
        } else if (param.contains("_") && param.split("(?=[A-Z])").length > 1) {
            result = "Error!";
        } else if (param.contains("_")) {
            try {
                result = toCamelCaseFromSnakeCase(param);
            } catch (Exception e) {

            }
        } else {
            try {
                result = toSnakeCase(param, true);
            } catch (Exception e) {
            }
        }

        out.print(result);
        out.flush();
    }
}
