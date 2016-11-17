package ru.isalnikov.sportloto;

import java.util.Arrays;


public class Perestanovka {
  private final int[] result;
  public Perestanovka(int k) {
    result = new int[k];
  }
  public void iterate(int n, int k) {
    for (int i=n;i>=k;i--) {
      result[k-1]=i;
      if (k==1) {
        System.out.println(Arrays.toString(result));
      } else {
        iterate(i-1,k-1);
      }
    }
  }
  public static void main(String... args) {
    Perestanovka p = new Perestanovka(3);
    p.iterate(5, 3);
  }
}