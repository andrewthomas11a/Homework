package home_work_2.utils;

import home_work_2.utils.ArraysUtils;
import java.util.Arrays;

public class SortsUtils {
    public static void main(String[] args) {

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
        }
    }

    public static void shakerSort(int[] arr){
        int leftBorder = 0;
        int rightBorder = arr.length-1;
        while(leftBorder < rightBorder){
            for (int i = leftBorder; i < rightBorder; i++){
                if (arr[i]>arr[i+1]){
                    int a=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=a;
                }
            }
            rightBorder--;
            for (int j = rightBorder; j > leftBorder; j--){
                if (arr[j] < arr[j-1]){
                    int a=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=a;
                }
            }
            leftBorder++;
        }
    }
}
