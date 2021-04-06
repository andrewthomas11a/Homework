package home_work_2.arrays;

import java.util.Scanner;
import java.util.Random;

public class ArraysUtils {
    public static void main(String[] args) {
        int[] container = arrayFromConsole();
        if (container.length==0){
            System.out.println("Неверно введены данные: получился пустой массив размером 0");
        }else{
            System.out.print("Получился следующий массив: {");
            for (int i : container) {
                System.out.print(i + "; ");
            }
            System.out.print("\b\b" + "}");
        }
        System.out.println("");

        int[] container2 = arrayRandom(5, 20);
        System.out.print("Получился следующий массив: {");
        for (int i : container2) {
            System.out.print(i + "; ");
        }
        System.out.print("\b\b" + "}");
    }

    public static int[] arrayFromConsole(){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива (число типа int):");
        int[] array = new int[0];
        if (input.hasNextInt()) {
            int size = input.nextInt();
            array = new int[size];
            System.out.println("Вводите элементы массива (числа типа int):");
            // не придумал как здесь сделать проверку на вводимые данные, надо разобраться с java.util.Scanner :(
            for (int i = 0; i < array.length; i++) {
                array[i] = input.nextInt();
            }
        }
        input.close();
        return array;
    }

    public static int[] arrayRandom(int size, int maxValueExclusion){
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i]=rand.nextInt(maxValueExclusion);
        }
        return array;
    }


}
