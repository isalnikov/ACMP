/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isalnikov.tests.sorts;

import java.util.Stack;

/**
 *
 * @author Igor Salnikov  <igor.salnikov@stoloto.ru>
 */
public class StackSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StackSort stackSort = new StackSort();
        int[] data = {5, 2, 1, 9, 0, 10};
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < data.length; i++) {
            stack.push(data[i]);
        }
        System.out.println(stack);
        stackSort.sort(stack);
    }

    public void sort(Stack s) {
        Stack<Integer> temp = new Stack<>();

        while (!s.isEmpty()) {

            int s1 = (int) s.pop();

            while (!temp.isEmpty() && (temp.peek() > s1)) {
                s.push(temp.pop());
            }
            temp.push(s1);

        }

        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.elementAt(i));
        }

    }
}
