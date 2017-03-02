package ru.isalnikov.acmp.acmp1;

import java.io.*;
import java.nio.file.*;

public class Main11 {

    public static void main(String[] args) throws IOException {
        try (PrintWriter o = new PrintWriter(System.out)) {
            o.print(Files.lines(Paths.get("input.txt"))
                    .mapToInt(Integer::parseInt).sum());
        }
    }
}
