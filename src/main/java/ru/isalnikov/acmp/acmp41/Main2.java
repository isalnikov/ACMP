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
import java.util.Arrays;

class Main2 {

    public static void main(String[] args) {
        try ( BufferedReader sc = new BufferedReader(new FileReader("input.txt"));
                  PrintWriter out = new PrintWriter(System.out)) {

            int n = Integer.parseInt(sc.readLine());
            
            String s = sc.readLine();
            int[] c = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] array = new int[202];
            
            for (int i = 0; i < n; i++) {
                array[c[i] + 100]++;
            }
            
            for (int i = 0; i < array.length; i++) {
                int b = array[i];
                if (array[i] != 0) {
                    for (int j = 0; j < array[i]; j++) {
                        out.print((i - 100) + " ");
                    }
                }
            }
            out.flush();
            out.close();
            
        }catch(IOException exception){
            
        }
    }
}
