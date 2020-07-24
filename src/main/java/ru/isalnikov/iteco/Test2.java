package ru.isalnikov.iteco;
//Дан следующий код:
//Что напечатает метод main? Почему?

public class Test2 {
    static String str = "Hello";
    public static void change(String s) {
        s = "world";
    }

    public static void main(String[] args) {
        System.out.println(str);
        change(str);  // соиспользование  - нет присовения ( созадется копия ссылки) 
        System.out.println(str);
    }
}
