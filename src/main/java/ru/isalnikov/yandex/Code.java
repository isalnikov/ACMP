package ru.isalnikov.yandex;

/**
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
public class Code {

    public static void main(String[] args) {

        int x = 3, y = 5, z = 2;

        if (x <= y) {
            x += z; // x = x+z // 3 + 2 = 5 ; x = 5 ;
            if (z != x) { // 2!=5
                y = (x - z) / y; // y = (5-2)/5 = 3/5 = 0 ; y = 0;
            }
            z++; //z=z+1 = 3; z = 3;
        } else if (y == 0) {
            y++;
            z *= y;
        } // (5 0 3)

        System.out.println(String.format("%d %d %d ", x, y, z));
        //5 0 3 
    }

}
