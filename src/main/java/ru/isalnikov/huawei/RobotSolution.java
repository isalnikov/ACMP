package ru.isalnikov.huawei;

import java.util.Random;

/**
 * 
 * http://thejam.ru/puzzle/roboty.html
 * 
 * Есть дискретная бесконечная прямая. На нее на парашютах высаживают 2-х
 * роботов. После высадки робот сбрасывает парашют и готов к действиям. У робота
 * есть 4 команды. 1. шаг влево L 2. шаг вправо R 3. безусловный переход на
 * номер сторчки в програме (G #, например G3 - переход на третью строку) 4.
 * определение что он стоит на каком то парашюте и если да то безусловный
 * переход (T #, например Т2 значит перейти на вторую строку если стоит на
 * парашюте)
 *
 *
 * Каждая команда выполняется за 1 сек. Нужно написать программу, одинаковую для
 * обоих роботов, которая позволит им когда либо встретиться.
 *
 * Ещё раз напоминаю - 1) прямая бесконечная 2) роботы выбрасываются в
 * произвольные места прямой. 3) программа одинаковая для обоих роботов
 *
 * Вид программы: номер строки - действие, к примеру бесконечное топтание то
 * влево то вправо записывается так :-)
 *
 * 1 L
 *
 * 2 R
 *
 * 3 G1
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
public class RobotSolution implements Runnable{

    /**
     *
     * обоих роботов посылаешь налево, и как только один из них найдет парашют
     * пустить его с удвоенной скоростью. 
     * //1 L 
     * //2 T4 
     * //3 G1 
     * //4 L 
     * //5 G4
     *
     */
   public static int[] line = new int[1000];
   public static Random random = new Random(System.currentTimeMillis()/3);
   private  int start ;

    public RobotSolution(int start) {
        this.start = start;
    }
   
   
   
   public void solution(int[] line) {
        
        System.out.println("LEFT" + start);
        start++;
        if(RobotSolution.line[start] == 1 ){
        System.out.println("LEFT" + start);
        System.out.println("LEFT" + start);
        }
    }

    public static void main(String[] args) {
        
        int r1 = random.nextInt(20);
        int r2 = random.nextInt(20);
        
        line[r1]++; 
        line[r2]++;
        
        
        RobotSolution robot1 = new RobotSolution(r1);
        RobotSolution robot2 = new RobotSolution(r2);
        
        
    }

    @Override
    public void run() {
        solution(line);
    }

}
