package ru.isalnikov.bmw;

import java.util.HashSet;
import java.util.Set;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 * if we give two strings ? could yoe determine if they share a common substring? 
 * Don't foget that a substring may be as small as one character. For example  the worlds "a" , "and"  "art" share the common substring "a" 
 * 
 The  words "be" and "cat" do not share a substring/
 * Ready ti work out the answer ?
 * 
 * @author Igor Salnikov isalnikov.com
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        Stream.of("hello".split("")).forEach(System.out::println);
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
