/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.acmp.acmp384;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "5 10";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("5", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "2 4";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1", outContent.toString());

    }

    /**
     * НОД(F(893854),F(102938)) = 1
     */
    @Test
    public void test2() {
        String data = "893854 102938";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("1", outContent.toString());

    }

//    Те у кого 6 тест не проходит : Не забываите что в условии сказано "выведите ОСТАТОК ОТ ДЕЛЕНИЯ НОД чисел Fi и Fj на 10^9" а именно 
//for i:=2 to n do 
//begin 
//f2:=(f+f1) mod 1000000000; 
//f:=f1; 
//f1:=f2; 
//end;
    @Test
    @Ignore
    public void test3() {
        String data = "1000000 1000000";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);

        assertEquals("242546875", outContent.toString());

    }

}
