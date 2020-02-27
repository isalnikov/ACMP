/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acase.task2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Igor Salnikov  <isalnikov.com>
 */
public class FileGanarator {

    public static void main(String[] args) throws IOException {
        for (char c = '!'; c <= 'z'; c++) {
            //   System.out.println("code=" + (int) c + "\tsumbol=" + c);
        }

      //  IntStream.rangeClosed(33, 122).forEach(System.out::println);
        //1 создать массив 
        //2 шафл массива 
        //3 вязть под массив
        //4 взаписать в файл
        List<String> chars = new ArrayList<>();
        for (int i = 33; i <= 122; i++) {
            chars.add("" + (char) i);

        }
        System.out.println(chars);

        Collections.shuffle(chars);
        System.out.println(chars);
        Collections.shuffle(chars);
        System.out.println(chars);
        Collections.shuffle(chars);
        System.out.println(chars);
        Random rand = new Random();
        System.out.println(String.join("", chars.subList(0, rand.nextInt(chars.size()))));
        System.out.println(String.join("", chars.subList(0, rand.nextInt(chars.size()))));
        System.out.println(String.join("", chars.subList(0, rand.nextInt(chars.size()))));
        System.out.println(String.join("", chars.subList(0, rand.nextInt(chars.size()))));
        System.out.println(String.join("", chars.subList(0, rand.nextInt(chars.size()))));
        System.out.println(chars.size());
        System.out.println(String.join("", chars.subList(0, chars.size())));
        System.out.println(String.join("", chars.subList(0, chars.size())).length());

        List<String> lines = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Collections.shuffle(chars);
            lines.add(String.join("", chars.subList(0, rand.nextInt(chars.size()))));

        }

        Path file = Paths.get("raw.txt");
        Files.write(file, lines, Charset.forName("UTF-8"));
        
        System.out.println(file.toAbsolutePath());
//Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);

    }
}
