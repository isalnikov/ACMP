package ru.isalnikov.acmp.acmp67;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Igor Salnikov 
 *
 * Маска подсетей (Время: 0,4 сек. Память: 16 Мб Сложность: 33%) Рассмотрим
 * компьютерную сеть с настроенной TCP/IP маршрутизацией. Будем рассматривать
 * некоторую ее модификацию. А именно в этой сети находить N подсетей. Каждая
 * подсеть характеризуется своей маской. Маска подсети представляет собой 4
 * однобайтных числа, разделенных точкой. Причем для масок выполнено следующее
 * свойство: если представить маску в двоичном виде, то сначала она будет
 * содержать k единиц, а потом q нулей, причем k + q = 32. Например,
 * 255.255.255.0 — маска подсети, а 192.168.0.1 — нет.
 *
 * Поясним, как получается двоичное представление IP-адреса. Для этого числа,
 * составляющие IP-адрес, представляются в двоичной системе счисления (при этом
 * каждое из них дополняется ведущими нулями до длины в 8 цифр), после чего
 * удаляются точки. Получившееся 32-битное число и есть двоичное представление
 * IP-адреса. Например, для адреса 192.168.0.1 этот процесс выглядит так:
 * 192.168.0.1 → 11000000.10101000.00000000.00000001 →
 * 11000000101010000000000000000001. Таким образом, двоичным представлением
 * IP-адреса 192.168.0.1 является 11000000101010000000000000000001.
 *
 * Будем говорить, что два компьютера с IP1 и IP2 лежат в подсети, если IP1 /\
 * Mask = IP2 /\ Mask, где Mask — маска этой подсети, а /\ — операция побитового
 * логического «и». IP компьютера представляет собой так же 4 однобайтных числа,
 * разделенных точкой.
 *
 * Вам даны M пар IP адресов компьютеров. Для каждой из них Вам надо определить,
 * в скольких подсетях из заданных они лежат.
 *
 * Входные данные В первой строке входного файла INPUT.TXT записано число N —
 * количество подсетей. В следующих N строках перечислены маски этих подсетей. В
 * N + 2 строке находится число M (0 ≤ M ≤ 10000). В следующих M строках
 * записаны пары IP адресов, разделенных пробелом.
 *
 * Выходные данные Для каждой пары IP адресов в отдельной строке выходного файла
 * OUTPUT.TXT выведите количество подсетей, в которых лежат оба компьютера.
 *
 */
public class Main {

    //ip = 3232235778
    public String longToIp(long ip) {

        return ((ip >> 24) & 0xFF) + "."
                + ((ip >> 16) & 0xFF) + "."
                + ((ip >> 8) & 0xFF) + "."
                + (ip & 0xFF);

    }

    public static long ipToLong2(String ipAddress) {

        long result = 0;

        String[] ipAddressInArray = ipAddress.split("\\.");

        for (int i = 3; i >= 0; i--) {

            long ip = Long.parseLong(ipAddressInArray[3 - i]);

            // left shifting 24,16,8,0 and bitwise OR
            // 1. 192 << 24
            // 1. 168 << 16
            // 1. 1 << 8
            // 1. 2 << 0
            result |= ip << (i * 8);

        }

        return result;
    }

    //Ограничение N (0 <= N <= 32) ( от 00000000.00000000.00000000.00000000 до 11111111.11111111.11111111.11111111)
    public static long mask(final String mask) {
        List<Integer> list = Arrays.stream(mask.split("\\.")).map(Integer::parseInt).collect(toList());
        System.out.println(list);
        return 0;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
        int n = Integer.parseInt(in.nextLine());
        String[] arr = new String[n];
        long[] masks = new long[n];
        for (int i = 0; i < n; i++) {
            String ip = in.nextLine();
            masks[i] = ipToLong2(ip);

        }
        int m = Integer.parseInt(in.nextLine());
        for (int i = 0; i < m; i++) {
            String[] ips = in.nextLine().split(" ");
            long ip1 = ipToLong2(ips[0]);
            long ip2 = ipToLong2(ips[1]);
            int cnt = 0;
            for (long mask : masks) {
                if ((ip1 & mask) == (ip2 & mask)) {
                    cnt++;
                }
            }
            System.err.println(cnt);
            out.println(cnt);
        }
        out.flush();
    }
}
