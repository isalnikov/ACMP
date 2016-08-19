package ru.isalnikov.acmp.acmp349;

 //https://habrahabr.ru/post/122538/
import java.util.Arrays;


// Листинг 7
//n = input("n=")
//lst=[2]
//for i in xrange(3, n+1, 2):
//	if (i > 10) and (i%10==5):
//		continue
//	for j in lst:
//		if j*j-1 > i:
//			lst.append(i)
//			break
//		if (i % j == 0):
//			break
//	else:
//		lst.append(i)
//print lst
public class NewMain {

    public static void main(String[] args) {
        int n = 1000;
        int array[] = new int[n + 1];

        array[0] = 2;
        int count = 1;
        for (int i = 3; i < n + 1; i++) {
            if (i > 10 && i % 10 == 5) {
                continue;
            }
            for (int j : array) {
                if (j * j - 1 > 1) {
                    array[count++] = i;
                    break;
                } else {
                    if (i % j == 0) {
                        break;
                    }
                }

            }

        }
        System.out.println(Arrays.toString(array));
    }

}
