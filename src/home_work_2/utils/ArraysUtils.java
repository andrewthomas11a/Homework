package home_work_2.utils;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class ArraysUtils {
    public static void main(String[] args) {
        int[] container = arrayFromConsole();
        System.out.println("Вы сформировали следующий массив: " + Arrays.toString(container));

        int[] container2 = arrayRandom(5, 300);
        System.out.println("Получился следующий рандомный массив: " + Arrays.toString(container2));
    }

    /**
     * Метод создает массив на основе данных, введенных пользователем: размера массива и его элементов.
     * Если в качестве размера массива введен 0 или отрицательное число, возвращает пустой массив.
     * Если в качестве элемента массива введено не число типа int, то выдает ошибку и требует повторить ввод.
     * @return Возвращает полученный массив.
     */
    public static int[] arrayFromConsole(){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива (число типа int):");
        int[] array = new int[0];
        if (input.hasNextInt()) {
            int size = input.nextInt();
            if (size>0){
                array = new int[size];

                int a = 0;
                while (a<array.length){
                    System.out.println("Введите элемент массива (числа типа int):");
                    if (input.hasNextInt()){
                        array[a] = input.nextInt();
                        a++;
                    }else{
                        System.out.println("Ошибка! Введенные данные - не число типа int.");
                        input.next();
                    }
                }
            }
        }
        return array;
    }

    /**
     * Генерирует массив заданного размере с рандомными элементами типа int в пределах от 0 до заданного значения.
     * @param size Размер массива. Если вводится число <=0, то метод создает пустой массив.
     * @param maxValueExclusion Предел рандомайзера. Если вводится число <=0, то элементам массива значения не присваиваются.
     * @return Возвращает получившийся массив.
     */
    public static int[] arrayRandom(int size, int maxValueExclusion){
        int[] array = new int[0];
        if (size>0){
            array = new int[size];
            Random rand = new Random();
            if (maxValueExclusion>0){
                for (int i = 0; i < array.length; i++){
                    array[i]=rand.nextInt(maxValueExclusion);
                }
            }
        }
        return array;
    }
}
