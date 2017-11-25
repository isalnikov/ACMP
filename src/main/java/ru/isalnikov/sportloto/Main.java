package ru.isalnikov.sportloto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    
    public static void main(String[] args) throws IOException {
        Files.list(Paths.get("."))
                .map(f -> f.getFileName())
                .filter(p -> p.toString().startsWith("-"))
                .filter(p -> p.toString().endsWith(".log"))
                
                .forEach(p->p.toFile().renameTo(new File(p.toString().substring(1, p.toString().length()))));
    }
    
}
