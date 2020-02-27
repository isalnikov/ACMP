package ru.isalnikov.sportloto;

/**
 *
 * @author Igor Salnikov isalnikov.com
 */
public class BaseChild {

    static class Base {

        private void print() {
            System.out.println("Base");
        }
    }

    static class Child extends Base {

        private void print() {
            System.out.println("Child");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Base obj = new Child();
        obj.print();
    }

}
