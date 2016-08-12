package ru.isalnikov.acmp.acmp178;

/**
 * Задана последовательность, содержащая n целых чисел. Необходимо найти число,
 * которое встречается в этой последовательности наибольшее количество раз, а
 * если таких чисел несколько, то найти минимальное из них, и после этого
 * переместить все такие числа в конец заданной последовательности. Порядок
 * расположения остальных чисел должен остаться без изменения.
 *
 * Например, последовательность 1, 2, 3, 2, 3, 1, 2 после преобразования должна
 * превратиться в последовательность 1, 3, 3, 1, 2, 2, 2.
 *
 * Требуется написать программу, которая решает данную задачу.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main1 {

    public static class IntHashMap {

    private transient Entry table[];

    private transient int count;

    private int threshold;

    private float loadFactor;

    Entry sortByValue() {
        rehash();
        Arrays.sort(table, (Entry o1, Entry o2) -> {
            
            if( o1 != null && o2 == null) return -1;
            if( o1 == null && o2 == null) return 0;
            if( o1 == null && o2 != null) return 1;
            
            int cmp = Integer.compare(o2.value, o1.value);
            if (cmp == 0) {
                cmp = Integer.compare(o1.key, o2.key);
            }
            return cmp;
        });
        
        return table[0];
    }

    public static class Entry {

        int hash;
        int key;
        int value;
        Entry next;

        protected Entry(int hash, int key, int value, Entry next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
        
    }

    public IntHashMap() {
        this(20, 0.75f);
    }

    public IntHashMap(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    public IntHashMap(int initialCapacity, float loadFactor) {
        super();
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        if (loadFactor <= 0) {
            throw new IllegalArgumentException("Illegal Load: " + loadFactor);
        }
        if (initialCapacity == 0) {
            initialCapacity = 1;
        }

        this.loadFactor = loadFactor;
        table = new Entry[initialCapacity];
        threshold = (int) (initialCapacity * loadFactor);
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean contains(int value) {

        Entry tab[] = table;
        for (int i = tab.length; i-- > 0;) {
            for (Entry e = tab[i]; e != null; e = e.next) {
                if (e.value == value) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(int value) {
        return contains(value);
    }

    public boolean containsKey(int key) {
        Entry tab[] = table;
        int hash = key;
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry e = tab[index]; e != null; e = e.next) {
            if (e.hash == hash) {
                return true;
            }
        }
        return false;
    }

    public int get(int key) {
        Entry tab[] = table;
        int hash = key;
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry e = tab[index]; e != null; e = e.next) {
            if (e.hash == hash) {
                return e.value;
            }
        }
        return Integer.MIN_VALUE;
    }

    protected void vacuum(){
        
    }
    

    
    protected void rehash() {
        int oldCapacity = table.length;
        Entry oldMap[] = table;

        int newCapacity = oldCapacity * 2 + 1;
        Entry newMap[] = new Entry[newCapacity];

        threshold = (int) (newCapacity * loadFactor);
        table = newMap;

        for (int i = oldCapacity; i-- > 0;) {
            for (Entry old = oldMap[i]; old != null;) {
                Entry e = old;
                old = old.next;

                int index = (e.hash & 0x7FFFFFFF) % newCapacity;
                e.next = newMap[index];
                newMap[index] = e;
            }
        }
    }

    public int put(int key, int value) {

        Entry tab[] = table;
        int hash = key;
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry e = tab[index]; e != null; e = e.next) {
            if (e.hash == hash) {
                int old = e.value;
                e.value = value;
                return old;
            }
        }

        if (count >= threshold) {
            // Rehash the table if the threshold is exceeded
            rehash();

            tab = table;
            index = (hash & 0x7FFFFFFF) % tab.length;
        }

        // Creates the new entry.
        Entry e = new Entry(hash, key, value, tab[index]);
        tab[index] = e;
        count++;
        return Integer.MIN_VALUE;
    }

        public  void clear() {
        Entry tab[] = table;
        for (int index = tab.length; --index >= 0;) {
            tab[index] = null;
        }
        count = 0;
    }
}

    
    
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    public static int[] concat(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;
        int[] c = new int[aLen + bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }
    
    private static void solve(Scanner in, PrintWriter out) {
        int N = in.nextInt();
        int array[] = new int[N];

        IntHashMap hashMap = new IntHashMap(N/3);

        int count = 0;
        for (int i = 0; i < N; i++) {
            int next = in.nextInt();
            array[i] = next;
             count = 1;
            if(hashMap.containsKey(next)){
                count = 1+ hashMap.get(next);
            }
            hashMap.put(next, count);
        }
   
        
        IntHashMap.Entry max = hashMap.sortByValue();
        int maxKey = max.key;
        int maxValue = max.value;
        hashMap.clear();
        hashMap = null;
        int [] fill  = new int[maxValue];
        Arrays.fill(fill, maxKey);

        
         //IntStream maxIntStream = IntStream.generate(()->max.key).limit(max.value);

        IntStream intStream = Arrays.stream(array);
        int[] result = concat(intStream.filter(i -> i != maxKey).toArray() , fill);
        // IntStream result = IntStream.concat(intStream.filter(i -> i != max.key), maxIntStream);
    
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(result[i]);
        }
       
        out.print(sb);
        out.flush();
    }

}
