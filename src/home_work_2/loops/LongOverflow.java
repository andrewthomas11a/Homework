package home_work_2.loops;

import utils_temp.InputCheck;
import java.math.BigInteger;

public class LongOverflow {
    public static void main(String[] args) {
        InputCheck input = new InputCheck();
        long a = 1;

        // Здесь тестируем метод с числами из условия задачи.
        multiplyToLimit(a, 3);
        multiplyToLimit(a, 188);
        multiplyToLimit(a, -19);

        // Здесь просим пользователя самому ввести число, на котрое нужно умножать 1 до переполнения long.
        System.out.println("Введите целое число, на которое умножать 1.");
        long b = input.checkLongInput();
        input.close();
        multiplyToLimit(a, b);
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
