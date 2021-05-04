package home_work_2.utils;

public class SortsUtils {

    /**
     * Пузырьковая сортировка: за каждый "проход" по массиву "выталкивает" наибольшее число на правую крайнюю позицию,
     * каждый раз уменьшая диапазон "прохода" на 1.
     * @param arr принимаемый для сортировки массив.
     */
    public static void bubbleSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < arr.length-i; j++){
                if (arr[j] > arr[j+1]){
                    toSwapWithNext(arr, j);
                }
            }
        }
    }

    /**
     * Шейкерная сортировка: каждая итерация цикла делает "проход" по массиву в обе стороны, "выталкивая"
     * наибольшее число на правую крайнюю позицию, а наименьшее - на левую, каждый раз уменьшая диапазон "прохода"
     * с каждой стороны.
     * @param arr принимаемый для сортировки массив
     */
    public static void shakerSort(int[] arr){
        int leftBorder = 0;
        int rightBorder = arr.length-1;
        while(leftBorder < rightBorder){
            for (int i = leftBorder; i < rightBorder; i++){
                if (arr[i] > arr[i+1]){
                    toSwapWithNext(arr, i);
                }
            }
            rightBorder--;
            for (int j = rightBorder; j > leftBorder; j--){
                if (arr[j] < arr[j-1]){
                    toSwapWithNext(arr, j-1);
                }
            }
            leftBorder++;
        }
    }

    /**
     * Принимает на вход массив, меняет в нем элемент с заданным индексом со следующим за ним элементом.
     * @param a передаваемый массив
     * @param i индекс элемента
     */
    public static void toSwapWithNext(int[] a, int i){
            int temp = a[i];
            a[i] = a[i+1];
            a[i+1] = temp;
    }
}
