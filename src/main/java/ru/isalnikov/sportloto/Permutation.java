package ru.isalnikov.sportloto;

public class Permutation {

    private final int[] result;
    private int n;
    private int k;
    static  int count = 0;

    
    
    public Permutation(int n , int k) {
        result = new int[k];
        this.n = n; 
        this.k = k; 
    }

    public void run(){
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
        long start = System.currentTimeMillis();
        
        for (int i = 0; i < 1; i++) {
            Permutation p = new Permutation(49, 7);
            p.run();

        }
        
        
        System.out.println("time " +(System.currentTimeMillis() - start)/1 + " ms");
        System.out.println(count);
        //exucutorSevice.shutdown();
        //exucutorSevice.awaitTermination(2L, TimeUnit.SECONDS);
        
    }
}
