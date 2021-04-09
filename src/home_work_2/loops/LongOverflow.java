package home_work_2.loops;

import java.math.BigInteger;
import java.util.Scanner;

public class LongOverflow {
    public static void main(String[] args) {
        long a = 1;
        Scanner inputNubmer = new Scanner(System.in);

        multiply(a, 3);
        multiply(a, 188);
        multiply(a, -19);

        long b = 0;
        int scanStop = 0;
        while (scanStop<1){
            System.out.println("Введите целое число, на которое умножать 1.");
            if (inputNubmer.hasNextLong()){
                b = inputNubmer.nextLong();
                scanStop++;
            }else{
                System.out.println("Введено не целое число, либо не число, попробуйте еще раз.");
                inputNubmer.next();
            }
        }

        multiply(a, b);
    }

    public static boolean isOverflow (long a, long b){
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigB = BigInteger.valueOf(b);
        long limitPos = Long.MAX_VALUE;
        long limitNeg = Long.MIN_VALUE;
        int comparePos = bigA.multiply(bigB).compareTo(BigInteger.valueOf(limitPos));
        int compareNeg = bigA.multiply(bigB).compareTo(BigInteger.valueOf(limitNeg));
        return (comparePos > 0 || compareNeg < 0);
    }

    public static void multiply(long a, long b){
        while(!isOverflow(a,b)){
            a *= b;
        }
        System.out.println("Результат умножения 1 на " + b + " до переполнения: " + a);
        a*=b;
        System.out.println("Результат умножения 1 на " + b + " после переполнения: " + a);
    }
}
