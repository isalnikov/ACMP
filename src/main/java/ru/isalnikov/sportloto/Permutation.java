package ru.isalnikov.sportloto;

public class Permutation {

    private int[] result;
    private int n;
    private int k;
    private int count = 0;

    
    
    public Permutation(int n , int k) {
        this.n = n; 
        this.k = k; 
    }

    public static Permutation getInstance(int n, int k) {
        Permutation p = new Permutation(n, k);
        p.run();
        return p;
    }

    public int getCount() {
        return count;
    }
    
    public void run(){
        count = 0;
        result = new int[k];
        iterate(n, k);
    }
    
    public void iterate(int n, int k) {
        for (int i = n; i >= k; i--) {
            result[k - 1] = i;
            if (k == 1) {
                count++;
               // System.out.println(Arrays.toString(result));
            } else {
              
                final int m = i - 1;
                final int p = k - 1;
                iterate(m, p);
                //exucutorSevice.submit(()->  iterate(m, p));
                
               
            }
        }
    }

    public static void main(String... args) throws InterruptedException {
        int n = 1;
        long start = System.currentTimeMillis();
        
        Permutation p = null;
        for (int i = 0; i < n; i++) {
         p = getInstance(49, 7);

        }
        System.out.println("time " +(System.currentTimeMillis() - start)/n + " ms");
        System.out.println(p.getCount());
        
    }
}
