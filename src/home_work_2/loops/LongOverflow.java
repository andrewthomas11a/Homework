package home_work_2.loops;

import java.math.BigInteger;
import java.util.Scanner;

public class LongOverflow {
    public static void main(String[] args) {
        long a = 1;
        Scanner inputNumber = new Scanner(System.in);

        // Здесь тестируем метод с числами из условия задачи.
        multiplyToLimit(a, 3);
        multiplyToLimit(a, 188);
        multiplyToLimit(a, -19);

        // Здесь просим пользователя самому ввести число, на котрое нужно умножать 1 до переполнения long.
        long b = 0;
        int scanStop = 0;
        while (scanStop<1){
            System.out.println("Введите целое число, на которое умножать 1.");
            if (inputNumber.hasNextLong()){
                b = inputNumber.nextLong();
                scanStop++;
            }else{
                System.out.println("Введено не целое число, либо не число, попробуйте еще раз.");
                inputNumber.next();
            }
        }

        multiplyToLimit(a, b);
        inputNumber.close();
    }

    /**
     * Метод проверяет, выйдет ли результат умножения 'a' на 'b' за пределы типа long.
     * @param a число a
     * @param b число b
     * @return true - если произойдет переполнение, false - если нет.
     */
    public static boolean multiplyIsOverflow (long a, long b){
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigB = BigInteger.valueOf(b);
        int comparePos = bigA.multiply(bigB).compareTo(BigInteger.valueOf(Long.MAX_VALUE));
        int compareNeg = bigA.multiply(bigB).compareTo(BigInteger.valueOf(Long.MIN_VALUE));
        return (comparePos > 0 || compareNeg < 0);
    }

    /**
     * Метод умножает 'a' на 'b' до тех пор, пока не произойдет переполнение 'long a'. Выводит в консоль результат
     * умножения до переполнения и после переполнения.
     * @param a
     * @param b
     */
    public static void multiplyToLimit(long a, long b){
        while(!multiplyIsOverflow(a,b)){
            a *= b;
        }
        System.out.println("Результат умножения 1 на " + b + " до переполнения: " + a);
        a*=b;
        System.out.println("Результат умножения 1 на " + b + " после переполнения: " + a);
    }
}
