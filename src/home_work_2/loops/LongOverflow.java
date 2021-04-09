package home_work_2.loops;

import java.math.BigInteger;
import java.util.Scanner;

public class LongOverflow {
    public static void main(String[] args) {
        long a = 1;
        Scanner inputNubmer = new Scanner(System.in);

        multiplyToLimit(a, 3);
        multiplyToLimit(a, 188);
        multiplyToLimit(a, -19);

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

        multiplyToLimit(a, b);
    }

    public static boolean multiplyIsOverflow (long a, long b){
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigB = BigInteger.valueOf(b);
        int comparePos = bigA.multiply(bigB).compareTo(BigInteger.valueOf(Long.MAX_VALUE));
        int compareNeg = bigA.multiply(bigB).compareTo(BigInteger.valueOf(Long.MIN_VALUE));
        return (comparePos > 0 || compareNeg < 0);
    }

    public static void multiplyToLimit(long a, long b){
        while(!multiplyIsOverflow(a,b)){
            a *= b;
        }
        System.out.println("Результат умножения 1 на " + b + " до переполнения: " + a);
        a*=b;
        System.out.println("Результат умножения 1 на " + b + " после переполнения: " + a);
    }
}
