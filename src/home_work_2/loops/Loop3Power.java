package home_work_2.loops;

import java.util.Scanner;

public class Loop3Power {
    public static void main(String[] args) {
        System.out.println("Введите возводимое число и степень:");
        Scanner input1 = new Scanner(System.in);
        if (input1.hasNextDouble()) {
            String local = input1.nextLine();
            double v = Double.parseDouble(local.replace(',','.'));
            Scanner input2 = new Scanner(System.in);
            if (input2.hasNextInt()) {
                int s = input2.nextInt();
                if (s>0) {
                    System.out.println(v + " ^ " + s + " = " + power(v, s));
                }else{
                    System.out.println("Степень должна быть положительной!");
                }
            }
            else{
                System.out.println("Ошибка данных! Степень должна быть типа int!");
            }
            input2.close();
        } else {
            System.out.println("Ошибка данных! Возводимое число должно быть типа double!");
        }
        input1.close();
    }

    public static double power (double v, int s){
        double result = v;
        for (int i = 1; i < s; i++) {
            result *= v;
        }
        return result;
    }
}