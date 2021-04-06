package home_work_2.loops;

import java.util.Scanner;

public class Loop2 {
    public static void main(String[] args) {
        if (args.length<1){
            System.out.println("Вы не ввели ни одного аргумента!");
        }else if (args.length>1){
            System.out.println("Вы ввели больше одного аргумента, работаем с первым.");
            multi(args[0]);
        }else{
            multi(args[0]);
        }
    }

    /**
     * Метод проверяет, является ли введенный аргумент числом, если да - разбивает его на массив символов char.
     * Символы переводятся в цифры по таблице ASCII и перемножаются между собой, выводится результат.
     * @param arg1 аргумент к исполняемой программе
     */
    public static void multi(String arg1){
        long result = 1;
        Scanner check = new Scanner(arg1);
        if (check.hasNextLong()){
            char[] charArr = arg1.toCharArray();
            // создали массив символов
            for (int i = 0; i < charArr.length; i++){
                if (i != charArr.length-1 && 47<charArr[i] && charArr[i]<58) {
                    // если введено отрицательное число - минус не входит в работу цикла
                    result *= (charArr[i] - '0');
                    // перевод char в int с применением кодировки ASCII
                    System.out.print(charArr[i] + " * ");
                } else if (i == charArr.length-1 && 47<charArr[i] && charArr[i]<58){
                    result *= (charArr[i] - '0');
                    System.out.print(charArr[i] + " = " + result);
                }
            }
        }else if (check.hasNextDouble()){
            System.out.println("Введено не целое число");
        }else{
            System.out.println("Введено не число");
        }
        check.close();
    }

    /**
     * Второй вариант метода multi
     * Метод проверяет, является ли введенный аргумент числом, если да - разбивает его циклом на массив цифр int.
     * Каждая цифра перемножается между собой, в консоль выводится результат.
     * @param arg1 аргумент к исполняемой программе
     */
    public static void multi2(String arg1){
        long result = 1;
        Scanner check = new Scanner(arg1);
        if (check.hasNextLong()){
            long a = Long.parseLong(arg1);
            /*
            создаем массив цифр введенного числа делением с отстатком на 10 в степени
            если введенное число было отрицательным - минус не учитываем, не добавляем в массив как символ
             */
            int[] array1 = new int[(a<0 ? arg1.length()-1 : arg1.length())];
            for (int i = 0; i < array1.length; i++) {
                array1[array1.length - 1 - i] = (int)(Math.abs(a)/(Math.pow(10, i))) % 10;
            }
            for (int i = 0; i < array1.length; i++){
                if (i != array1.length-1){
                    result *= array1[i];
                    System.out.print(array1[i] + " * ");
                }else{
                    result *= array1[i];
                    System.out.print(array1[i] + " = " + result);
                }
            }
        }else if (check.hasNextDouble()){
            System.out.println("Введено не целое число");
        }else{
            System.out.println("Введено не число");
        }
        check.close();
    }
}