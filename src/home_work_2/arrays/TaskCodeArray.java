package home_work_2.arrays;

import java.util.Scanner;
import java.util.Arrays;

public class TaskCodeArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Укажите размер массива:");
        int arrSize = input.nextInt();
        System.out.println("Укажите, до какого числа генерировать рандомные числа:");
        int maxValExl = input.nextInt();
        if (arrSize>0 && maxValExl > 0){
            int[] array = ArraysUtils.arrayRandom(arrSize, maxValExl);
            System.out.print("Получился массив: ");
            System.out.println(Arrays.toString(array));

            System.out.println("Сумма положительных четных чисел массива равна " + sumEvenPos(array));
            System.out.println("Максимальный элемент массива с положительным индексом равен " + maxEvenIndex(array));
            lessThanAv(array);
            twoMin(array);
            intervalErase(array, 50, 100);
            System.out.println("Сумма цифр всех элементов массива: " + digitSum(array));
        }else{
            System.out.println("Невозможно создать массив, введены неверные данные.");
        }
    }

    /**
     * Метод возвращает сумму положительных четных элементов массива.
     * @param array принимаемый массив
     * @return возвращаемое значение - сумма
     */
    public static int sumEvenPos(int[] array){
        int sum = 0;
        for (int i : array) {
            if (i % 2 == 0 && i >= 0) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * Метод ищет и возвращает максимальный (наивысший) элемент массива, имеющий четный индекс.
     * @param array принимаемый массив
     * @return возвращаемый наивысший элемент
     */
    public static int maxEvenIndex(int[] array){
        int max = array[0];
        for (int i = 0; i < array.length; i+=2) {
            if (array[i]>max){
                max=array[i];
            }
        }
        return max;
    }

    /**
     * Метод ищет элементы массива, которые меньше среднего арифметического всех элементов массива.
     * Печатает результат поиска в виде визаулизации массива чисел.
     * @param array принимаемый массив
     */
    public static void lessThanAv(int[] array){
        int sum = 0;
        for(int i : array){
            sum+=i;
        }
        double av = (double)sum/array.length;
        String result = "[";
        for (int i: array){
            if (i<av){
                result+=i + ", ";
            }
        }
        if (array.length == 1){
            result += "]";
        }else{
            result += "\b\b" + "]";
        }
        System.out.println("Элементы массива, которые меньше среднего арифметического: " + result);
    }

    /**
     * Метод ищет два наименьших числа среди элементов массива.
     * Печатает результат с сообщением о работе метода для пользователя.
     * @param array принимаемый массив
     */
    public static void twoMin(int[] array){
        if (array.length == 1){
            System.out.println("В массиве всего 1 элемент, невозможно найти два наименьших элемента.");
        }else{
            int min1 = array[0];
            int minIndex = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i]<min1){
                    min1=array[i];
                    minIndex=i;
                }
            }
            int min2 = array[minIndex>0 ? (minIndex-1) : (minIndex+1)];
            for (int i = 0; i < array.length; i++) {
                if (i!=minIndex){
                    if (array[i]<min2){
                        min2=array[i];
                    }
                }
            }
            System.out.println("Два наименьших элемента массива: " + min1 + " и " + min2);
        }
    }

    /**
     * Метод удаляет из массива числа, входящие в заданный диапазон.
     * Печатает результат в виде визаулизации массива оставшихся чисел.
     * @param array принимаемый массив
     * @param rangeOpen начало интервала (включительно)
     * @param rangeClose конец интервала (включительно)
     */
    public static void intervalErase(int[] array, int rangeOpen, int rangeClose){
        int i = 0;
        // клонируем массив, чтобы не изменять этим методом исходный масссив;
        int[] arrayTest = Arrays.copyOf(array, array.length);
        int m = arrayTest.length;
        System.out.print("Массив после удаления элементов в диапазоне от "+ rangeOpen + " до " + rangeClose + ": [");
        while(i<m){
            if(arrayTest[i]>=rangeOpen && arrayTest[i]<=rangeClose){
                m--;
                for (int j = i; j < m; j++){
                    arrayTest[j]=arrayTest[j+1];
                }
            }else{
                System.out.print(arrayTest[i]+ ", ");
                i++;
            }
        }
        System.out.println("\b\b" + "]");
    }

    /**
     * Метод считает сумму цифр всех элементов массива.
     * @param array принимаемый массив
     * @return сумма цифр элементов
     */
    public static int digitSum (int[] array){
        int sum = 0;
        for (int i : array){
            int a = i;
            while(a>0){
                sum+=a%10;
                a/=10;
            }
        }
        return sum;
    }
}
