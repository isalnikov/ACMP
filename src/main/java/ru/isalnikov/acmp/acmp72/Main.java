package ru.isalnikov.acmp.acmp72;

import ru.isalnikov.acmp.acmp70.*;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Stream;
//		
//Анаграмма
//(Время: 1 сек. Память: 16 Мб Сложность: 45%)
//Пусть задано некоторое слово, состоящее из букв английского алфавита длиной не более 80 символов (например, “WORD”). Рассмотрим набор возможных перестановок, состоящих из букв данного слова (например, “RDOW”, “WODR” и т.д.). Требуется выбрать из этого множества слово, следующее по алфавиту за исходным.
//
//Входные данные
//В единственной строке входного файла INPUT.TXT записано слово, не последнее по алфавиту среди возможных его перестановок.
//
//Выходные данные
//В единственную строку выходного файла OUTPUT.TXT нужно вывести следующее слово по алфавиту.

//https://ru.wikibooks.org/wiki/%D0%A0%D0%B5%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D0%B8_%D0%B0%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC%D0%BE%D0%B2/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%9D%D0%B0%D1%80%D0%B0%D0%B9%D0%B0%D0%BD%D1%8B#Java

public class Main {
    
    int getDiameter(Stream<Integer> stream) {
    int min = stream.min(Integer::compare).get();
    int max = stream.max(Integer::compare).get();
    return max - min;
}

    // Функция, задающая отношение порядка для значений типа T: < либо >
    @FunctionalInterface
    interface Predicate2<T extends Comparable> {

        boolean compare(final T value_0, final T value_1);
    }

    // Поиск очередной перестановки
    public static final <T extends Comparable> boolean nextPermutation(T[] sequence, Predicate2 comparator) {
        // Этап № 1
        int i = sequence.length;
        do {
            if (i < 2) {
                return false; // Перебор закончен
            }
            --i;
        } while (!comparator.compare(sequence[i - 1], sequence[i]));
        // Этап № 2
        int j = sequence.length;
        while (i < j && !comparator.compare(sequence[i - 1], sequence[--j]));
        _swapItems(sequence, i - 1, j);
        // Этап № 3
        j = sequence.length;
        while (i < --j) {
            _swapItems(sequence, i++, j);
        }
        return true;
    }

    // Обмен значениями двух элементов последовательности
    private static final <T> void _swapItems(T[] sequence, int index_0, int index_1) {
        T temp = sequence[index_0];
        sequence[index_0] = sequence[index_1];
        sequence[index_1] = temp;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        String s = (in.nextLine());
        out.flush();
    }
}
