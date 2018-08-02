package ru.isalnikov.sportloto;

import java.time.chrono.ThaiBuddhistChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * Кол-во терминалов - пропускная способность TPS cистемы и кол -во билетов
 *
 * @author Igor Salnikov igor.salnikov@stoloto.ru
 */
public class SMO {

    public static final int TERMINAL_COUNT = 500;
    public static final int TICKETS = 5;
    public static final int TPS = 30;
    
   public static final  List<Long> average = new ArrayList<>();

    static class Terminal {

        public int Id;
        public long startTime;
        public long endTime;
        public int count;

        public Terminal(int Id, int count) {
            this.Id = Id;
            this.count = count;
        }

        public boolean sale() {

            if (this.count == TICKETS) {
                this.startTime = System.currentTimeMillis();
            }
            if (this.count > 0) {
                this.count--;
            }

            if (this.count == 0) {
                this.endTime = System.currentTimeMillis();
                System.out.println(String.format("terminal [%03d]  = %s s", this.Id, getTime()));
                average.add(getTime());
            }
            return (this.count == 0);

        }

        long getTime() {
            return (this.endTime - this.startTime) / 1000;
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        List<Terminal> list = new ArrayList<>();
       

        for (int i = 0; i < TERMINAL_COUNT; i++) {
            list.add(new Terminal(i, TICKETS));
        }

        while (list.size() > 0) {
            Thread.sleep(1000);

            for (int i = 0; i < TPS; i++) {
                if (list.isEmpty()) {
                    continue;
                }
                int id = random.nextInt(list.size());

                if (list.isEmpty() || id > list.size()) {
                    continue;
                }
                Terminal terminal = list.get(id);

                if (terminal.sale()) {
                    list.remove(terminal);
                }
            }

        }

        LongSummaryStatistics s = average.stream().collect(Collectors.summarizingLong(Long::intValue));
        System.out.println(s);

    }
}
