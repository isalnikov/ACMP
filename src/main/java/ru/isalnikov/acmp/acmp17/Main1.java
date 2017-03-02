package ru.isalnikov.acmp.acmp17;

/**
 * Для игры в «Поле чудес» используется круглый барабан, разделенный на сектора,
 * и стрелка. В каждом секторе записано некоторое число. В различных секторах
 * может быть записано одно и то же число. Однажды ведущий игры решил изменить
 * правила. Он сам стал вращать барабан и называть игроку (который барабана не
 * видел) все числа подряд в том порядке, в котором на них указывала стрелка в
 * процессе вращения барабана. Получилось так, что барабан сделал целое число
 * оборотов, то есть последний сектор совпал с первым. После этого, ведущий
 * задал участнику вопрос: какое наименьшее число секторов может быть на
 * барабане? Требуется написать программу, отвечающую на этот вопрос ведущего.
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out)) {

            solve(in, out);
        }
    }

    private static void solve(Scanner in, PrintWriter out) {
//        int N = in.nextInt();
//        int[] array = IntStream.range(0, N).map(i -> in.nextInt()).toArray();
//      int   k = 0;
//         boolean flag ;
//        for (int i = 0; i < N / 2; i++) {
//            if(N % i == 0){
//            }
//            
//        }
//          for i := 1 to (N div 2) do
//            begin
//              if (N mod i = 0)
//                then
//                  begin
//                    flag := True;
//
//                    for j := 1 to (N - i) do
//                      if (A [j] <> A [j + i])
//                        then
//                          begin
//                            flag := false;
//
//                            Break;
//                          end;
//
//                    if (flag)
//                      then
//                        begin
//                          k := i;
//
//                          Break;
//                        end;
//                  end;
//            end;
//
//          if (k = 0)
//            then
//              k := N;
//
//        out.print(N - p[N - 1]);
//        out.flush();
    }

}
