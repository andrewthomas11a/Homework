package home_work_1;

import utils_temp.InputCheck;

public class SleepOrNot {
    public static void main(String[] args) {
        InputCheck intInput = new InputCheck("Вы ввели что-то не то... Попробуйте заново.");
        int day;
        int vac;
        boolean result;

        System.out.println("Сегодня рабочий день? Напишите 1, если рабочий, или 0, если выходной.");
        while(true){
            int temp = intInput.checkIntInput();
            if (temp == 0 || temp == 1){
                day = temp;
                break;
            }
            System.out.println(intInput.getError());
        }

        System.out.println("У вас отпуск? Напишите 1, если да, или 0, если нет.");
        while(true){
            int temp = intInput.checkIntInput();
            if (temp == 0 || temp == 1){
                vac = temp;
                break;
            }
            System.out.println(intInput.getError());
        }

        result = (day != 1 || vac == 1);
        System.out.println(result ? "Можно спать дальше!" : "Пора идти на работу");
    }

    public static boolean sleepIn (boolean weekday, boolean vacation){
        return (vacation || !weekday);
    }
}