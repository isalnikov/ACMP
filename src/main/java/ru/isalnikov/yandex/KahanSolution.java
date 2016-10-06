//http://www.codeatcpp.com/2011/04/find-sum-of-elements-in-array.html
//https://habrahabr.ru/post/201066/
//https://habrahabr.ru/post/112953/
//http://www.validlab.com/goldberg/paper.pdf

//https://books.google.ru/books?id=h0d8hVA5HyQC&pg=PA83&lpg=PA83&dq=java+kahan+summation&source=bl&ots=AXQlqCUat3&sig=hqei1tjrC5NcHWa4_ZNPzmCrOeE&hl=ru&sa=X&ved=0ahUKEwjIy8GYu8XPAhUCFiwKHf8gD6IQ6AEIODAD#v=onepage&q=java%20kahan%20summation&f=false

package ru.isalnikov.yandex;

public class KahanSolution {

    private float sum;
    private float correction;
    private float correctionAddend;

    public KahanSolution() {
    }

    public float value() {
        return sum + correction;
    }

    public float getCorrectionAddend() {
        return correctionAddend;
    }

    public void add(float added) {
        correctionAddend = added + correction;
        float tempSum = sum + correctionAddend;
        
        correction = correctionAddend - (tempSum - sum );
        
        sum = tempSum;
    }
    
    
    public void clear() {
        sum = 0;
        correction = 0;
    }

    public static void main(String[] args) {

        KahanSolution ksum = new KahanSolution();
        ksum.add((float) (1.0/3));
        ksum.add((float) (1.0/3));
        
        System.out.println(ksum.value());
        System.out.println(1.0/3+1.0/3);
        System.out.println(2.0/3);
        
    }

}
