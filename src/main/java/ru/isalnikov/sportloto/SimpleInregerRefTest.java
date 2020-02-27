package ru.isalnikov.sportloto;

/**
 *
 * @author Igor Salnikov isalnikov.com
 */
public class SimpleInregerRefTest {

    public static class Simple{
        private Integer  a = 0;

        public Simple(Integer in ) {
            a = in;
        }

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }

        @Override
        public String toString() {
            return "" + a;
        }
        
        
        
    }
    
    
    public static void test(Integer a) {
        System.out.println("a = " + a);
        a = a + 1;
        System.out.println("a = " + a);
    }
    
    public static void test(Simple a) {
        System.out.println("a = " + a);
        a.setA(a.getA() + 1);
        System.out.println("a = " + a);
    }
    
    public static void main(String[] args) {
       Integer b = 10000;
        System.out.println("b = " + b );
        test(b);
        System.out.println("b = " + b);
        
        Simple s = new Simple(1);
        System.out.println("s = " +s );
        
        test(s);
        
        System.out.println("s = " +s );
        
    }
    
}
