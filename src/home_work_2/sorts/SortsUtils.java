package home_work_2.sorts;

import home_work_2.utils.ArraysUtils;
import java.util.Arrays;

public class SortsUtils {
    public static void main(String[] args) {
        int[] array = ArraysUtils.arrayFromConsole();
        System.out.println("Изначальный массив: " + Arrays.toString(array));
        bubbleSort(array);
        System.out.println("Массив после сортировки: " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < arr.length-i; j++){
                if (arr[j]>arr[j+1]){
                    int a=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=a;
                }
            }
            System.out.println("Сейчас массив такой: " + Arrays.toString(arr));
        }
    }

    public static void shakerSorts(int[] arr){

    }
}
