package home_work_2.arrays;

import home_work_2.utils.ArraysUtils;

import java.util.Scanner;
import java.util.Arrays;

public class TaskCodeArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Укажите размер массива:");
        if (input.hasNextInt()) {
            int arrSize = input.nextInt();
            System.out.println("Укажите, до какого числа генерировать рандомные числа:");
            if (input.hasNextInt()) {
                int maxValExl = input.nextInt();

                int[] array = ArraysUtils.arrayRandom(arrSize, maxValExl);
                System.out.println("Получился массив: " + Arrays.toString(array));
                System.out.println("Сумма положительных четных чисел массива: " + sumEvenPos(array));
                System.out.println("Максимальный элемент массива с положительным индексом: " + maxEvenIndex(array));
                lessThanAv(array);
                twoMin(array);
                intervalErase(array, 50, 100);
                // другой метод, использующий intervalErase, но запрашивающий диапазон удаления у пользователя
                eraseIntervalUserInput(array);
                System.out.println("Сумма цифр всех элементов массива: " + digitSum(array));
            }else{
                System.out.println("Невозможно создать массив - введены неверные данные.");
            }
        }else{
            System.out.println("Невозможно создать массив - введены неверные данные.");
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
     * @param array Принимаемый массив
     * @return Возвращаемый наивысший элемент. Если массив пустой - возвращает 0.
     */
    public static int maxEvenIndex(int[] array){
        // проверяем, не является ли переданный массив пустым
        if (array.length > 0) {
            int max = array[0];
            for (int i = 0; i < array.length; i += 2) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        }else{
            return 0;
        }
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
        String result = "";
        for (int i: array){
            if (i<av){
                result+=i + ", ";
            }
        }
        if (array.length > 1){
            result += "\b\b";
        }
        System.out.println("Элементы массива, которые меньше среднего арифметического: " + result);
    }

    /**
     * Метод ищет два наименьших числа среди элементов массива.
     * Печатает результат с сообщением о работе метода для пользователя.
     * @param array принимаемый массив
     */
    public static void twoMin(int[] array){
        if (array.length <= 1){
            System.out.println("В массиве меньше 2 элементов, невозможно найти два наименьших элемента.");
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
     * Метод удаляет из массива числа, входящие в заданный диапазон, и печатает результат
     * виде визаулизации массива оставшихся чисел. Исходный массив при этом не изменяется.
     * @param array принимаемый массив
     * @param rangeOpen начало интервала (включительно)
     * @param rangeClose конец интервала (включительно)
     */
    public static void intervalErase(int[] array, int rangeOpen, int rangeClose){
        int i = 0;
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
        if (m>0){
            System.out.println("\b\b" + "]");
        }else{
            System.out.println("]");
        }
    }

    /**
     * Метод запрашивает у пользователя начало и конец интервала, затем удаляет из массива элементы,
     * принадлежащие интервалу [включительно], с помощью метода intervalErase, и печатает результат в виде визаулизации
     * массива оставшихся чисел. Передаваемый в метод массив при этом не изменяется.
     * Если введенные данные не являются числом типа int, то печатает сообщение об ошибке.
     * Выводит соответствующее сообщение, если введенная пользователем нижняя граница интервала больше, чем верхняя.
     * @param array принимаемый массив
     */
    public static void eraseIntervalUserInput(int[] array){
        Scanner range = new Scanner(System.in);
        int count = 0;
        while (count < 2){
            System.out.println("Введите начало интервала (число типа int):");
            if (range.hasNextInt()){
                int rangeOpen = range.nextInt();
                count++;
                while (count < 2){
                    System.out.println("Введите конец интервала (число типа int):");
                    if (range.hasNextInt()){
                        int rangeClose = range.nextInt();
                        intervalErase(array, rangeOpen, rangeClose);
                        count++;
                        if(rangeOpen>rangeClose){
                            System.out.println("P.S. С массивом ничего не произошло, т.к. нижняя граница интервала должна быть меньше верхней.");
                        }
                    }else{
                        System.out.println("Ошибка! Введенные данные - не число типа int.");
                        range.next();
                    }
                }
            }else{
                System.out.println("Ошибка! Введенные данные - не число типа int.");
                range.next();
            }
        }
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
