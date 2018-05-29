package ru.isalnikov.sportloto;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.Test;
import static ru.isalnikov.sportloto.Coin.NUMBER;
import static ru.isalnikov.sportloto.Coin.sumBitsCounter;

/**
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class CoinTest {

    private static String[] splitByNumber(String s, int chunkSize) {
        int chunkCount = (s.length() / chunkSize) + (s.length() % chunkSize == 0 ? 0 : 1);
        String[] returnVal = new String[chunkCount];
        for (int i = 0; i < chunkCount; i++) {
            returnVal[i] = s.substring(i * chunkSize, Math.min((i + 1) * chunkSize - 1, s.length()));
        }
        return returnVal;
    }

    public static int bitCounter(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * Test of run method, of class Coin.
     */
    @Test
    public void testRun() {
        // 10110101 01110011 10100000 0101100
        int i = 950625720;//ThreadLocalRandom.current().nextInt();
        System.out.println(Arrays.toString(splitByNumber(Integer.toBinaryString(i), 8)));
        System.out.println("bitCount   : " + sumBitsCounter(i));
        System.out.println("BIN        : " + Integer.toBinaryString(i));
        System.out.println("bitCounter : " + bitCounter(i));
        System.out.println("bitCount   : " + Integer.bitCount(i));

        int d = i & 0xff000000;
        int c = i & 0xff0000;
        int b = i & 0xff00;
        int a = i & 0xff;

        System.out.println("Byte 4th Hex Str: " + Integer.toHexString(d));
        System.out.println("Byte 3rd Hex Str: " + Integer.toHexString(c));
        System.out.println("Byte 2nd Hex Str: " + Integer.toHexString(b));
        System.out.println("Byte 1st Hex Str: " + Integer.toHexString(a));

        byte[] bytes = ByteBuffer.allocate(4).putInt(i).array();
        for (byte aByte : bytes) {
            System.out.println(Byte.toString(aByte));
            System.out.format("0x%x ", aByte);
        }
    }

  
    @Test
    public void testTime() {
        System.out.println(1.0 * Coin.runner() /NUMBER);
        System.out.println(1.0 * Coin.runner() /NUMBER);
        long start = System.currentTimeMillis();
        System.out.println(1.0 * Coin.runner() /NUMBER);
        long stop = System.currentTimeMillis();
        System.out.println(String.format(" %s ms", stop - start));
        runner1();
        runner1();
        runner1();
        
    }

    private static void runner1() {
        long startTime = System.currentTimeMillis();

        final int tossCount = 8;
        final int faceCount = 3;

        int total = 0;

        for (int i = 0; i < NUMBER; i++) {
            int faceNum = 0;

            for (int j = 0; j < tossCount; j++) {
                faceNum += ThreadLocalRandom.current().nextInt(2);
             //   if(faceNum>faceCount) break;
            }
            //faceNum += random.nextInt(2);

            total += faceNum == faceCount ? 1 : 0;
        }

        long stopTime = System.currentTimeMillis();

        long execTime = stopTime - startTime;

        System.out.println(String.format("Result %4.8f time : %s  ms", (double) total / (NUMBER * 1.0), execTime));
    }
     
}
