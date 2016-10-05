
package ru.isalnikov.yandex;

import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 * https://habrahabr.ru/post/145198/
 * http://stackoverflow.com/questions/31554025/want-to-create-a-stream-of-characters-from-char-array-in-java
 * 
 * 2. Есть два односвязных массива, у которых есть общая часть. Нужно выяснить
 * индексы массивов, с которых начинается общая часть. Примеры массивов:
 *
 * - a b c x y z
 * - d e a d b e e f x y z
 *
  */
public class PrefixArray {

  
    public static void main(String[] args) {
  
        char [] a = {'a' ,'b' ,'c' ,'x', 'y' ,'z'};
        char [] b = {'d' ,'e', 'a', 'd', 'b', 'e' ,'e' ,'f' ,'x' ,'y', 'z'};
        //Character.valueOf(c);
        Stream<Character> streama = CharBuffer.wrap(a).chars().mapToObj((c) -> Character.valueOf((char)c));
        Stream<Character> streamb = CharBuffer.wrap(b).chars().mapToObj(ch -> (char)ch);
        
        List<Character> lista = new LinkedList<>(streama.collect(toList()));
        List<Character> listb = new LinkedList<>(streamb.collect(toList()));
        
        System.out.println(lista);
        System.out.println(listb);
        
         
    }

}
