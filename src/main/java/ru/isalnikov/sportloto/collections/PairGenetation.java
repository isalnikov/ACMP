package ru.isalnikov.sportloto.collections;

/**
 * "жадный" алгоритм случайного размещения, который я набросал за час. Он
 * использует при размещении простую эвристику и смотрит на один шаг вперед. В
 * принципе, в 100 билетов легко утолакивает все 990 пар. Если повезет, то и в
 * 80 может утолкать (просто надо несколько раз запустить и выбрать лучший
 * вариант). Это уже не так далеко от абсолютного теоретического минимума в 66
 * билетов.
 *
 */
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static java.util.stream.Collectors.toList;

public class PairGenetation {

    private static final int cores = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {

        int pair = 990;
        int count = 85;
        
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5,6);
        
        System.out.println(pair(list));
        System.exit(0);



        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService executor = Executors.newFixedThreadPool(cores);

        for (int i = 0; i < cores; i++) {
            executor.submit(() -> {
                List<List<Integer>> bets = betGenerator(count, pair);
                bets.forEach(System.out::println);
                latch.countDown();

            });

        }

        try {
            latch.await();
            executor.shutdown();
            final boolean done = executor.awaitTermination(1, TimeUnit.SECONDS);
            System.out.printf("все закончили ? {%s}\n", done);
            executor.shutdownNow();
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Done");

    }

    public static List<List<Integer>> pair(List<Integer> list) {

        List<List<Integer>> pairs = new ArrayList<>();
        int[] a = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        int size = a.length;
        for (int i1 = 0; i1 < size; i1++) {
            for (int i2 = i1 + 1; i2 < size; i2++) {
                String s = String.format("%d %d\n", a[i1], a[i2]);
                System.out.println(s);

                pairs.add(Arrays.asList(a[i1], a[i2]));
            }

        }
        return pairs;
    }

    public static List<List<Integer>> betGenerator(int count, int pairCount) {
        List<List<Integer>> bets = new ArrayList<>();

        String name = Thread.currentThread().getName();
        boolean isGood = false;
        int tr = 0;
        while (!isGood) {
            tr++;
            // System.out.printf("Попытка : %d  ; Поток %s \n",tr , name);

            bets = new ArrayList<>();

            // write your code here
            int nNumbers = 45;
            int nVariantsInTicket = 6;
            int nTickets = 100;

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
                //  System.out.print("Ticket " + j + ": ");

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
                //  System.out.println("; New Pairs : "+np+"; Total pairs : "+snp);

                if (j <= count && snp == pairCount) {
                    isGood = true;
                }

            }

        }
        return bets;
    }
}
