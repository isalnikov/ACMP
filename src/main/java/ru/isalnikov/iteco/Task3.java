package ru.isalnikov.iteco;

/**
 *
 * Дан следующий код: Что получится в результате компиляции и исполнения?
 * Почему?
 */
public class Task3 {

    class A {

        String str = "ab";

        A() {
            printLength();
        }

        void printLength() {
            System.out.println(str.length());
        }
    }

    class B extends A {

        String str = "abc";

        void printLength() {
            System.out.println(str.length());
        }
    }

    public static void main(String[] args) {
        new Task3().new B();
    }

}
//public class ru.isalnikov.iteco.Task3 {
//  public ru.isalnikov.iteco.Task3();
//    Code:
//       0: aload_0
//       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//       4: return
//
//  public static void main(java.lang.String[]);
//    Code:
//       0: new           #2                  // class ru/isalnikov/iteco/Task3$B
//       3: dup
//       4: new           #3                  // class ru/isalnikov/iteco/Task3
//       7: dup
//       8: invokespecial #4                  // Method "<init>":()V
//      11: invokespecial #5                  // Method ru/isalnikov/iteco/Task3$B."<init>":(Lru/isalnikov/iteco/Task3;)V
//      14: pop
//      15: return
//}