package home_work_2.loops;

import java.util.Locale;
import java.util.Scanner;

// реализован другой способ проверки вводимых данных, метод main выглядит короче.

public class Loop3Power2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        /* была проблема с разделителем double
        Scanner.hasNextDouble искал число с разделителем-запятой, а Double.parseDouble искал с разделителем-точкой
        "вылетала" ошибка NumberFormatException
        */

        System.out.println("Введите возводимое число и степень:");
        Scanner input = new Scanner(System.in);
        String v = input.nextLine();
        String s = input.nextLine();
        if (checkDouble(v) && checkInteger(s)) {
            System.out.println(power(Double.parseDouble(v), Integer.parseInt(s)));
        } else {
            System.out.println("Ошибка данных! Возводимое число должно быть типа double, а степень - положительным int.");
        }
    }

    public static boolean checkDouble(String v){
        Scanner check = new Scanner(v);
        return check.hasNextDouble();
    }

    public static boolean checkInteger(String s){
        Scanner check = new Scanner(s);
        return (check.hasNextInt() && check.nextInt()>=0);
    }

    public static double power (double v, int s){
        double result = v;
        for (int i = 1; i < s; i++) {
            result *= v;
        }
        return result;
    }
}