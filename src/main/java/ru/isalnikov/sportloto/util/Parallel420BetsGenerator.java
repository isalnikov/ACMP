package ru.isalnikov.sportloto.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import static java.util.stream.Collectors.toList;
import lombok.extern.log4j.Log4j2;

/**
 *
 * @author igor
 */
@Log4j2
public class Parallel420BetsGenerator {

    public static final Path path = Paths.get("C:\\Users\\i.salnikov\\Documents\\4_20_35_190");

    public static final int setsCount = 100;

    public static AtomicInteger counter = new AtomicInteger(0);

    public static final int nNumbers = 20;

    public static final int nVariantsInTicket = 4;

    public static final int pair = 190;

    public static final int count = 35;  //190/6 = 32 min 

    private static final int cores = Runtime.getRuntime().availableProcessors();
    public static final CountDownLatch latch = new CountDownLatch(setsCount);
    public static final ExecutorService executor = Executors.newFixedThreadPool(cores);

    public static void main(String[] args) {

        for (int i = 0; i < cores; i++) {

            executor.submit(() -> {
                List<List<Integer>> bets = betGenerator(count, pair);

            });

        }

        try {
            latch.await();
            executor.shutdown();
            final boolean done = executor.awaitTermination(5, TimeUnit.SECONDS);
            executor.shutdownNow();
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

    }

    public static void writingToFile(List<List<Integer>> set) {
        try {

            File file = File.createTempFile("4_20_190_35_", ".log", path.toFile());
            List<String> list = set.stream().map(List::toString).collect(toList());
            Files.write(file.toPath(), list, Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println(set);
            System.err.println(e);
        }

    }

    public static List<List<Integer>> betGenerator(int count, int pairCount) {
        List<List<Integer>> bets = null;
        while (latch.getCount() > 0) {
            bets = new ArrayList<>();

            String name = Thread.currentThread().getName();
            boolean isGood = false;
            int tr = 0;
            while (!isGood) {
                tr++;
                if (tr % 100_000 == 0) {
                    System.out.printf("Попытка : %d  ; Поток %s \n", tr, name);
                }

                bets = new ArrayList<>();

                int nTickets = count;

                // Начальный набор
                List<Integer> nms = new ArrayList<Integer>();
                Map<Integer, List<Integer>> pairs = new HashMap<Integer, List<Integer>>();
                for (int i = 1; i <= nNumbers; i++) {
                    nms.add(i);
                    pairs.put(i, new ArrayList<Integer>());
                }
                // Генерация билетов
                int snp = 0;
                for (int j = 1; j <= nTickets; j++) {
                    // Формирование билета
                    List<Integer> ticket = new ArrayList<Integer>();
                    List<Integer> var = new ArrayList<Integer>();
                    var.addAll(nms);
                    for (int k = 1; k <= nVariantsInTicket; k++) {
                        // Подбираем очерендной номер в билет. Перебираем все варианты
                        List<Integer> cvar = new ArrayList<Integer>();
                        cvar.addAll(var);
                        List<Integer> uvar = new ArrayList<Integer>();
                        List<Integer> fvar = new ArrayList<Integer>();
                        uvar.addAll(nms);
                        for (Integer kt : ticket) {
                            uvar.removeAll(pairs.get(kt));
                            fvar.addAll(pairs.get(kt));
                        }

                        double cmin = 1e5;
                        Integer ci = -1;
                        do {
                            int i = (int) Math.round(Math.random() * cvar.size() - 0.5);
                            int kn = cvar.get(i);
                            cvar.remove(i);
                            Integer kvi = new Integer(kn);

                            // Вычисляем критерий качества
                            List<Integer> gvar = new ArrayList<Integer>();
                            gvar.addAll(uvar);
                            gvar.remove(pairs.get(kvi));
                            double cc = 100 + Collections.frequency(fvar, kvi) * 1000;
                            cc -= gvar.size();

                            if (cc < cmin) {
                                ci = kvi;
                                cmin = cc;
                            }
                        } while (cvar.size() > 0);
                        ticket.add(ci);
                        var.remove(ci);
                    }
                    int np = nVariantsInTicket * (nVariantsInTicket - 1);
                    //    System.out.print("Ticket " + j + ": ");

                    bets.add(ticket.stream().sorted().collect(toList()));

                    for (Integer ki : ticket) {
                        for (Integer kj : ticket) {
                            if (ki != kj) {
                                if (pairs.get(ki).contains(kj)) {
                                    np -= 1;
                                } else {
                                    pairs.get(ki).add(kj);
                                }
                            }
                        }
                        // System.out.print(ki+" ");
                    }
                    np /= 2;
                    snp += np;
                    //       System.out.println("; New Pairs : "+np+"; Total pairs : "+snp);

                    if (j <= count && snp == pairCount) {
                        isGood = true;
                    }

                }

            }

            writingToFile(bets);
            latch.countDown();
        }
        return bets;
    }
}
