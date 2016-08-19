/*
 *  Тут линейная сложность возникает из-за малых ограничений на k. Если бы k было, скажем, 10 или больше, единственным выходом были бы хеши. А так можно додуматься, что код на самом деле-это какое-то число(минимум 0, максимум 99999). Заводим массив на 100к элементов, проходимся по входной строке и запоминаем кол-во чисел(полученных из всех подстрок длины k). Дальше всё тривиально, за один проход можем сказать да или нет.
 */
package ru.isalnikov.acmp.acmp34;

import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.isalnikov.acmp.base.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void test() {
        String data = "10 5\n"
                + "0123456789";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("NO", outContent.toString());

    }

    @Test
    public void test1() {
        String data = "13 2\n"
                + "0123400056789";

        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);

        Main.main(null);

        assertEquals("YES", outContent.toString());

    }

}
