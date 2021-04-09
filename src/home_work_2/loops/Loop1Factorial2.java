package home_work_2.loops;

import java.util.Scanner;

public class Loop1Factorial2 {

    public static void main(String[] args) {

        if (args.length<1){
            System.out.println("Вы не ввели ни одного аргумента!");
        }else if (args.length>1){
            System.out.println("Вы ввели больше одного аргумента, работаем с первым.");
            factorialR(args[0]);
        }else{
            factorialR(args[0]);
        }
    }

    /**
     * Принимает значение типа String, проверяет, является ли оно числом, если да - преобразует в число,
     * считает его факториал и выводит в консоль результат в виде 1 * 2 * 3 * ... * arg1 = факториал.
     * @param arg1 принимаемый аргумент, факториал которого необходимо вывести в консоль
     */
    public static void factorialR(String arg1){
        Scanner check = new Scanner(arg1);
        if (check.hasNextLong()){
            long c = Long.parseLong(arg1);

            if (c>0){
                for (int i = 1; i < c; i++){
                    System.out.print(i + " * ");
                }
                System.out.print(c + " = ");
                System.out.println(fact(c));
                if (c>20){
                    System.out.println("Внимание! Результат не точный, т.к. произошло переполнение long.");
                }
            }else{
                System.out.println("Аргумент не является положительным числом. Попробуйте заново.");
            }
        }else{
            System.out.println("Аргумент не является целым числом. Попробуйте заново.");
        }
        check.close();
    }

    /**
     * Рекурсивный метод, возвращающий факториал числа.
     * @param a принимаемое значение
     * @return факториал числа a
     */
    public static long fact(long a){
        if (a == 1){
            return 1;
        }
        return a * fact(a-1);
    }
}
