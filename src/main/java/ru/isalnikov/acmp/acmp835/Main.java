package ru.isalnikov.acmp.acmp835;

/**
 * Задача о рюкзаке
 *
 * (Время: 1 сек. Память: 16 Мб Сложность: 51%) Одной из классических NP-полных
 * задач является так называемая «Задача о рюкзаке». Формулируется она следующим
 * образом. Дано n предметов, каждый из которых характеризуется весом wi и
 * полезностью pi. Необходимо выбрать некоторый набор этих предметов так, чтобы
 * суммарный вес этого набора не превышал W, а суммарная полезность была
 * максимальна.
 *
 * Ваша задача состоит в том, чтобы написать программу, решающую задачу о
 * рюкзаке.
 *
 * Входные данные
 *
 * Первая строка входного файла INPUT.TXT содержит натуральные числа n (1 ≤ n ≤
 * 20) и W (1 ≤ W ≤ 109). Каждая из последующих n строк содержит описание одного
 * предмета. Каждое описание состоит из двух чисел: wi – веса предмета и pi –
 * его полезности (1 ≤ wi, pi ≤ 109).
 *
 * Выходные данные
 *
 * В первой строке выходного файла OUTPUT.TXT выведите количество выбранных
 * предметов и их суммарную полезность. Во второй строке выведите через пробел
 * их номера в возрастающем порядке (предметы нумеруются с единицы в порядке, в
 * котором они перечислены во входном файле).
 *
 * Если искомых наборов несколько, выберите тот, в котором наименьшее число
 * предметов. Если же после этого ответ по-прежнему неоднозначен, выберите тот
 * набор, в котором первый предмет имеет наименьший возможный номер, из всех
 * таких выберите тот, в котором второй предмет имеет наименьший возможный
 * номер, и т.д.
 * <admin@isalnikov.com>
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            
            out.print(0);
            out.flush();
        }
    }

}
