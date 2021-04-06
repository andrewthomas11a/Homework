package home_work_2.loops;

import java.util.Scanner; // для проверки можно ли перевести первый строковый аргумент в число

public class Loop1Factorial1 {
    public static void main(String[] args) {
        if (args.length<1){
            System.out.println("Вы не ввели ни одного аргумента!");
        }else if (args.length>1){
            System.out.println("Вы ввели больше одного аргумента, работаем с первым.");
            factorial(args[0]);
        }else{
            factorial(args[0]);
        }
    }

    // Есть нюанс с переполнением, можно добавить проверки и сообщения пользователю.

    public static void factorial(String arg1){
        long result = 1;
        Scanner check = new Scanner(arg1);
        if (check.hasNextLong()){
            long c = Long.parseLong(arg1);
            if (c>0){
                for (long i = 1; i<=c; i++) {
                    if (i != c) {
                        result *= i;
                        System.out.print(i + " * ");
                    } else {
                        result *= i;
                        System.out.print(i + " = " + result);
                    }
                }
                // эта проверка не работает!
                //if (result > Long.MAX_VALUE || result < Long.MIN_VALUE){
                //    System.out.println();
                //    System.out.println("Произошло переполнение данных - результат не точен.");
                //}
            }else{
                System.out.println("Введенное целое число не положительное. Попробуйте заново.");
            }
        }else{
            System.out.println("Аргумент не является целым числом. Попробуйте заново.");
        }
        check.close();
    }
}
