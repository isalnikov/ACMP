package ru.isalnikov.acmp.acmp315;

/**
 * Известно, что основанием позиционной системы счисления называют количество
 * различных символов, используемых для записи чисел в данной системе счисления.
 * Также известно, что любое число x в b-ичной системе счисления имеет вид
 * x=a0∙b0+a1∙b1+…+an∙bn, где b ≥ 2 и 0 ≤ ai < b.
 *
 * Для записи чисел в b-ичной системе счисления, где b ≤ 36, могут быть
 * использованы первые b символов из следующего списка 0,1,…, 9, A, B, …, Z.
 * Например, для записи чисел в троичной системы используются символы 0, 1, 2, а
 * в двенадцатеричной - 0,1,…, 9, A, B.
 *
 * Требуется написать программу, которая по входной строке S определит, является
 * ли данная строка записью числа в системе счисления, с основанием не большим
 * 36, и, если является, определит минимальное основание этой системы счисления.
 *
 * Входные данные
 *
 * Входной файл INPUT.TXT содержит в единственной строке входную строку. Длина
 * строки не превышает 255. Все символы строки имеют коды от 32 до 127.
 *
 * Выходные данные
 *
 * Выходной файл OUTPUT.TXT должен содержать одно число. Если строка является
 * записью числа в некоторой системе счисления, то нужно вывести минимальное
 * основание такой системы счисления. Иначе вывести -1.
 */
import java.io.*;
import java.util.*;

public class Main1{ 
    
  public static void main(String[] argv) throws IOException,Exception{
    new Main1().run();
  }
 
  public void run() throws IOException,Exception{
    BufferedReader  sc = new BufferedReader(new FileReader("input.txt"));   
    String[] str = sc.readLine().split("(?!^)");
    
    Map<String, Integer> dict = new HashMap();
    for (int i = 0; i < 10; i++) {
        if (i == 0 || i == 1) {
            dict.put(Integer.toString(i), 2);
        }else {
            dict.put(Integer.toString(i), i+1);
        }
    }
    int uppercase = 65;
    int lowercase = 97;
    for (int i = 11; i < 37; i++) {
        dict.put(Character.toString ((char) uppercase++), i);
        dict.put(Character.toString ((char) lowercase++), i);
    }
    
    int result = 0;
    for (String string : str) {
        if (string.matches("[^a-zA-Z0-9]")) {
            result = -1;
            break;
        }
        if (dict.containsKey(string)) {
            if (dict.get(string) > result) {
                result = dict.get(string);
            }
        }
    }
    PrintWriter pw = new PrintWriter(new File("output.txt"));
    pw.print(result);
    pw.close();
  }
}