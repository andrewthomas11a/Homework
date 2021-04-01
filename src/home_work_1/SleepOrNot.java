package home_work_1;

import java.util.Scanner;

public class SleepOrNot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean weekday;
        boolean vacation;
        int day;
        int vac;

        System.out.println("Сегодня рабочий день?");
        System.out.println("Напишите 1, если рабочий, или 0, если выходной.");
        if (input.hasNextInt()){
            day = input.nextInt();
            System.out.println("У вас отпуск?");
            System.out.println("Напишите 1, если да, или 0, если нет.");
            if (input.hasNextInt()){
                vac = input.nextInt();
                weekday = day == 1;
                vacation = vac == 1;

                if ((day == 1 || day == 0) && (vac == 1 || vac == 0)){
                    boolean result = sleepIn(weekday, vacation);
                    System.out.println(result ? "Можно спать дальше!" : "Пора идти на работу");
                }else{
                    System.out.println("Ошибка данных: вы где-то ввели что-то не то, попробуйте заново.");
                }
            }else{
                System.out.println("Вы ввели что-то не то... Попробуйте заново.");
            }
        }else{
            System.out.println("Вы ввели что-то не то... Попробуйте заново.");
        }
        input.close();
    }

    public static boolean sleepIn (boolean weekday, boolean vacation){
        return (vacation || !weekday);
    }
}