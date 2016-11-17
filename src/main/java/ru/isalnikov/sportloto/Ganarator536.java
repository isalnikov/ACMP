package ru.isalnikov.sportloto;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class Ganarator536 {

    public static void main(String[] args) throws IOException {
        int a[] = IntStream.rangeClosed(1, 36).toArray();
        long time = System.currentTimeMillis();
        int count = 0;
        Path path = Paths.get("536.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (int i1 = 0; i1 < a.length; i1++) {
                for (int i2 = i1 + 1; i2 < a.length; i2++) {
                    for (int i3 = i2 + 1; i3 < a.length; i3++) {
                        for (int i4 = i3 + 1; i4 < a.length; i4++) {
                            for (int i5 = i4 + 1; i5 < a.length; i5++) {
                                count++;
                                String s = String.format("%d %d %d %d %d\n", a[i1], a[i2], a[i3], a[i4], a[i5]);
                               // writer.write(s);
                            }
                        }
                    }
                    writer.flush();
                }
            }
            writer.flush();
        }

        System.out.println("time " + (System.currentTimeMillis() - time) + " ms");
        System.out.println(count);
    }
}
