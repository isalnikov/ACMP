package ru.isalnikov.bmw;

import java.util.HashSet;
import java.util.Set;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static String twoStrings(String s1, String s2) {
        Set<Character> set1 = new HashSet(s1.chars().mapToObj(c -> (char) c).collect(toList()));

        char[] chars = s2.toCharArray();
        for (char aChar : chars) {
            if (set1.contains(aChar)) {
                return "YES";
            }
        }

        return "NO";

//        Set<Character> set1 = new HashSet(s1.chars().mapToObj(c -> (char) c).collect(toList()));
//        Set<Character> set2 = new HashSet(s2.chars().mapToObj(c -> (char) c).collect(toList()));
//        TODO ???
//        if (set1.retainAll(set2)) {
//            return "YES";
//        }
//
//        return "NO";
//
//    }
    }
}