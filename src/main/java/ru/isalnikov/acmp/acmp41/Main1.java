package ru.isalnikov.acmp.acmp41;

/**
 * (Время: 2 сек. Память: 16 Мб Сложность: 29%) На планете «Аурон» атмосфера
 * практически отсутствует, поэтому она известна своими перепадами температур в
 * различных точках. Известно, что эти перепады колеблются от -100 до 100
 * градусов. Нашим специалистам удалось выяснить значения температур в N точках
 * этой планеты. К сожалению, эти значения вычислены с большими погрешностями,
 * поэтому их решили округлить до целых чисел. Хотелось бы наглядно видеть
 * участки с повышенной и пониженной температурой. Вам требуется помочь. Вы
 * должны упорядочить температуры участков по неубыванию.
 *
 * Входные данные
 *
 * В первой строке входного файла INPUT.TXT задано натуральное число N -
 * количество участков (N ≤ 106). Во второй строке через пробел записаны целые
 * значения температур этих участков, не превосходящие 100 по абсолютной
 * величине.
 *
 *
 */
import java.io.*;
import java.util.*;

class Main1 {

    public static void main(String[] args) {
        try (BufferedReader sc = new BufferedReader(new FileReader("input.txt"));
                PrintWriter out = new PrintWriter(System.out)) {

            int n = Integer.parseInt(sc.readLine());
            String s = sc.readLine();
            Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).parallel().sorted().forEachOrdered(x->out.print(x + " "));
            out.flush();
        }catch(IOException exception){
            
        }
    }
}
