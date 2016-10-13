/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.yandex;

/**
 * 
 * 
 * 2. Есть два односвязных массива, у которых есть общая часть. Нужно выяснить индексы массивов, с которых начинается общая часть.
Примеры массивов:

- a b c x y z
- d e a d b e e f x y z
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 * 
 * https://ru.wikipedia.org/wiki/%D0%9D%D0%B0%D0%B8%D0%B1%D0%BE%D0%BB%D1%8C%D1%88%D0%B0%D1%8F_%D0%BE%D0%B1%D1%89%D0%B0%D1%8F_%D0%BF%D0%BE%D0%B4%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B0
 */
public class SubArray {

    
    private static String longestCS(String a, String b) {
	if (a == null || b == null || a.length() == 0 || b.length() == 0) {
		return "";
	}

	if (a.equals(b)) {
		return a;
	}

	int[][] matrix = new int[a.length()][];

	int maxLength = 0;
	int maxI = 0;

	for (int i = 0; i < matrix.length; i++) {
		matrix[i] = new int[b.length()];
		for (int j = 0; j < matrix[i].length; j++) {
			if (a.charAt(i) == b.charAt(j)) {
				if (i != 0 && j != 0) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				} else {
					matrix[i][j] = 1;
				}
				if (matrix[i][j] > maxLength) {
					maxLength = matrix[i][j];
					maxI = i;
				}
			}
		}
	}
	return a.substring(maxI - maxLength + 1, maxI + 1);
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
String a ="a b c x y z";
String b ="d e a d b e e f x y z";        
        System.out.println(longestCS(a, b));
    }
    
}
