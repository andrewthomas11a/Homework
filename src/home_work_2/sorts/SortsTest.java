package home_work_2.sorts;

import java.util.Arrays;
import home_work_2.utils.ArraysUtils;
import home_work_2.utils.SortsUtils;


public class SortsTest {
    public static void main(String[] args) {
        int[] testArray1b = {1,2,3,4,5,6};
        System.out.print("4.3.1. пузырьковая:\t" + Arrays.toString(testArray1b) + " -> ");
        SortsUtils.bubbleSort(testArray1b);
        System.out.println(Arrays.toString(testArray1b));
        int[] testArray1sh = {1,2,3,4,5,6};
        System.out.print("4.3.1. шейкерная:\t" + Arrays.toString(testArray1sh) + " -> ");
        SortsUtils.shakerSort(testArray1sh);
        System.out.println(Arrays.toString(testArray1sh));

        int[] testArray2b = {1,1,1,1};
        System.out.print("4.3.2. пузырьковая:\t" + Arrays.toString(testArray2b) + " -> ");
        SortsUtils.bubbleSort(testArray2b);
        System.out.println(Arrays.toString(testArray2b));
        int[] testArray2sh = {1,1,1,1};
        System.out.print("4.3.2. шейкерная:\t" + Arrays.toString(testArray2sh) + " -> ");
        SortsUtils.shakerSort(testArray2sh);
        System.out.println(Arrays.toString(testArray2sh));

        int[] testArray3b = {9,1,5,99,9,9};
        System.out.print("4.3.3. пузырьковая:\t" + Arrays.toString(testArray3b) + " -> ");
        SortsUtils.bubbleSort(testArray3b);
        System.out.println(Arrays.toString(testArray3b));
        int[] testArray3sh = {9,1,5,99,9,9};
        System.out.print("4.3.3. шейкерная:\t" + Arrays.toString(testArray3sh) + " -> ");
        SortsUtils.shakerSort(testArray3sh);
        System.out.println(Arrays.toString(testArray3sh));

        int[] testArray4b = {};
        System.out.print("4.3.4. пузырьковая:\t" + Arrays.toString(testArray4b) + " -> ");
        SortsUtils.bubbleSort(testArray4b);
        System.out.println(Arrays.toString(testArray4b));
        int[] testArray4sh = {};
        System.out.print("4.3.4. шейкерная:\t" + Arrays.toString(testArray4sh) + " -> ");
        SortsUtils.shakerSort(testArray4sh);
        System.out.println(Arrays.toString(testArray4sh));

        int[] arrayRandom = ArraysUtils.arrayRandom(7, 300);
        int[] arrayRandom2 = Arrays.copyOf(arrayRandom, arrayRandom.length);
        System.out.print("4.4. пузырьковая:\t" + Arrays.toString(arrayRandom) + " -> ");
        SortsUtils.bubbleSort(arrayRandom);
        System.out.println(Arrays.toString(arrayRandom));
        System.out.print("4.4. шейкерная:\t\t" + Arrays.toString(arrayRandom2) + " -> ");
        SortsUtils.shakerSort(arrayRandom2);
        System.out.println(Arrays.toString(arrayRandom2));

        int[] arrayFromC = ArraysUtils.arrayFromConsole();
        int[] arrayFromC2 = Arrays.copyOf(arrayFromC, arrayFromC.length);
        System.out.print("4.5. пузырьковая:\t" + Arrays.toString(arrayFromC) + " -> ");
        SortsUtils.bubbleSort(arrayFromC);
        System.out.println(Arrays.toString(arrayFromC));
        System.out.print("4.5. шейкерная:\t\t" + Arrays.toString(arrayFromC2) + " -> ");
        SortsUtils.shakerSort(arrayFromC2);
        System.out.println(Arrays.toString(arrayFromC2));
    }
}
