package ru.isalnikov.acase.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * отсортировать 100 Мб файл строк используя 32Мб памяти
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {

         Path raw = Paths.get("raw.txt");
         Path sorted = Paths.get("sorted.txt");
        
        System.out.println(raw.toAbsolutePath());
        System.out.println(sorted.toFile().createNewFile());
        
        
        //Files.readAllLines(raw).forEach(System.out::println);
        Files.readAllLines(raw).stream().sorted().forEach(System.out::println);
        
    }
}
