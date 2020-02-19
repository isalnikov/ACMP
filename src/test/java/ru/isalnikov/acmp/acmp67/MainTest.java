package ru.isalnikov.acmp.acmp67;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.junit.Test;

import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test1() {
        String data = "2\n"
                + "255.255.255.255\n"
                + "255.255.255.0\n"
                + "3\n"
                + "192.168.31.1 192.168.31.2\n"
                + "192.168.31.3 192.168.31.4\n"
                + "192.168.31.1 192.167.31.2";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main1.main(null);

        assertEquals("1\n"
                + "1\n"
                + "0\n", outContent.toString());

    }

    @Test
    public void test2() throws FileNotFoundException {

        Scanner sc = new Scanner(new File("/home/igor/NetBeansProjects/example/ACMP/src/test/resources/test67.txt"));
        int a = sc.nextInt();
        PrintWriter pw = new PrintWriter(new File("/home/igor/NetBeansProjects/example/ACMP/src/test/resources/output67.txt"));
        pw.print(a + 1);
        pw.close();

    }

}
