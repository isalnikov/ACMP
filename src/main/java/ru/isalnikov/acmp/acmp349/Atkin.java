package ru.isalnikov.acmp.acmp349;

import java.util.Arrays;

public class Atkin {

    /**
     * Function to calculate all primes less than n *
     */
    private boolean[] calcPrimes(int limit) {
        /**
         * initialize the sieve *
         */
        boolean[] prime = new boolean[limit <3 ? 4: limit + 1];
        prime[2] = true;
        prime[3] = true;
        int root = (int) Math.ceil(Math.sqrt(limit));

        /**
         * put in candidate primes: integers which have an odd number of
         * representations by certain quadratic forms *
         */
        for (int x = 1; x < root; x++) {
            for (int y = 1; y < root; y++) {
                int n = 4 * x * x + y * y;
                if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
                    prime[n] = !prime[n];
                }
                n = 3 * x * x + y * y;
                if (n <= limit && n % 12 == 7) {
                    prime[n] = !prime[n];
                }
                n = 3 * x * x - y * y;
                if ((x > y) && (n <= limit) && (n % 12 == 11)) {
                    prime[n] = !prime[n];
                }
            }
        }
        /**
         * eliminate composites by sieving, omit multiples of its square *
         */
        for (int i = 5; i <= root; i++) {
            if (prime[i]) {
                for (int j = i * i; j < limit; j += i * i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }

    /**
     * Function to get all primes *
     */
    public void getPrimes(int N) {
        boolean[] primes = calcPrimes(N);
        display(primes);
    }

    /**
     * Function to display all primes *
     */
    public void display(boolean[] primes) {
        System.out.print("\nPrimes = ");
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public void display(int min, int max) {
        boolean[] array = Arrays.copyOfRange(calcPrimes(max), min, max+1);
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                System.out.print((i  +  min) + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Atkin soa = new Atkin();
        soa.display(100, 200);

//         Atkin soa = new  Atkin();
//        /** Accept n **/
//        
//        for (int i = 3; i < 102; i++) {
//            System.out.print( i +" : ");
//            soa.getPrimes(i);        
//        }
    }
}
