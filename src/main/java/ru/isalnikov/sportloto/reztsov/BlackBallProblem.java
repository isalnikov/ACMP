package ru.isalnikov.sportloto.reztsov;

/**
 *
 *  @author Igor Salnikov igor.salnikov@stoloto.ru
 * 
 *  В коризне 1 лежит 10 шаров (3 черных) 
 *  В коризне 2 лежит 10 шаров (5 черных) 
 * 
 *  Достали черный шар, какова вероятность того что его достали тз первой корзны 
 * 
 */
public class BlackBallProblem {
    
    public static void main(String[] args) {
        System.out.println("Байеса формула");
        System.out.println("(1/2*3/10) / 1/2 * (3/10+5/10)  = 3/8");
    }
    
}
