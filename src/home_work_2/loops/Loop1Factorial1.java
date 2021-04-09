package home_work_2.loops;

import java.util.Scanner;

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

    public static void factorial(String arg1){
        long result = 1;
        Scanner check = new Scanner(arg1);
        if (check.hasNextLong()){
            long c = Long.parseLong(arg1);
            if (c>0){
                boolean overflow = false;
                for (long i = 1; i<=c; i++) {
                    if (i != c) {
                        overflow = LongOverflow.multiplyIsOverflow(result, c);
                        result *= i;
                        System.out.print(i + " * ");
                    } else {
                        if (LongOverflow.multiplyIsOverflow(result, c)){
                            overflow=true;
                        }
                        result *= i;
                        System.out.println(i + " = " + result);
                    }
                }
                System.out.println(overflow? "Внимание! Результат не точный, т.к. произошло переполнение long." : "");
            }else{
                System.out.println("Аргумент не является положительным числом. Попробуйте заново.");
            }
        }else{
            System.out.println("Аргумент не является целым числом. Попробуйте заново.");
        }
        check.close();
    }
}
