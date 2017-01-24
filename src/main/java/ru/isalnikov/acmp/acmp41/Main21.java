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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main21 {

    public static void main(String[] args) {
        try (BufferedReader sc = new BufferedReader(new FileReader("input.txt"));
                PrintWriter out = new PrintWriter(System.out)) {

            int n = Integer.parseInt(sc.readLine());
                String s = sc.readLine();
                int[] array = new int[201];//-100 ... 100
                int index = 0;

                while (index < s.length()) {
                    String buf = "";
                    while (index < s.length() && s.charAt(index) != ' ') {

                        buf += s.charAt(index);
                        index++;
                    }
                    array[Integer.parseInt(buf) + 100]++;
                    index++;
                }

                //
                for (int i = 0; i < array.length; i++) {
                    int b = array[i];
                    if (array[i] != 0) {
                        for (int j = 0; j < array[i]; j++) {
                            out.print((i - 100) + " ");
                        }
                    }
                }
                out.flush();
            

        } catch (IOException exception) {

        }
    }
}
