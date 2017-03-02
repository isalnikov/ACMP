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
import java.util.*;
import java.util.stream.StreamSupport;

class Main41 {

 


    
    public static void main(String[] args) {
     
            
            
               
            StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                    new Iterator<String>() {
                        int n = 1;

                        @Override
                        public boolean hasNext() {
                            return n > 0;
                        }

                        @Override
                        public String next() {
                            String s = "";
                            try {
                                for (; (n = System.in.read()) > -1;) {
                                    if (n > 32) {
                                        s += (char) n;
                                    } else if (s != "") {
                                        break;
                                    }
                                }
                            } catch (Exception e) {
                            }
                            return s;
                        }
                    }, 16), false).skip(1).filter(b -> b != "").mapToInt(Integer::parseInt).sorted().forEach(b -> System.out.print(b + " "));
            
        }
    }

