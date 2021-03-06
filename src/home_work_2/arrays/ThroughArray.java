package home_work_2.arrays;

import home_work_2.utils.ArraysUtils;

public class ThroughArray {
    public static void main(String[] args) {
        int[] array = ArraysUtils.arrayFromConsole();
        if (array.length>0){
            arrayToConsole(array);
            everySecondToConsole(array);
            arrayToConsoleReverse(array);
        }else{
            System.out.println("Невозможно выполнить методы, т.к. создан пустой массив");
        }
    }

    public static void arrayToConsole(int[] array){
        int count1 = 0;
        do{
            System.out.print(array[count1]+"; ");
            count1++;
        }while(count1<array.length);
        System.out.println("\b\b");

        int count2 = 0;
        while (count2 < array.length){
            System.out.print(array[count2]+"; ");
            count2++;
        }
        System.out.println("\b\b");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"; ");
        }
        System.out.println("\b\b");

        for (int i : array) {
            System.out.print(i +"; ");
        }
        System.out.println("\b\b");
    }

    public static void everySecondToConsole(int[] array){
        if(array.length>1){
            int count1 = 1;
            do{
                System.out.print(array[count1]+"; ");
                count1+=2;
            }while(count1<array.length);
            System.out.println("\b\b");

            int count2 = 1;
            while (count2 < array.length){
                System.out.print(array[count2]+"; ");
                count2+=2;
            }
            System.out.println("\b\b");

            for (int i = 1; i < array.length; i+=2) {
                System.out.print(array[i]+"; ");
            }
            System.out.println("\b\b");
        }else {
            System.out.println("");
        }

        int count3 = 0;
        for (int i : array) {
            if (count3%2!=0){
                System.out.print(i +"; ");
            }
            count3++;
        }
        System.out.println("\b\b");
    }

    public static void arrayToConsoleReverse(int[] array){
        int count1 = array.length-1;
        do{
            System.out.print(array[count1]+"; ");
            count1--;
        }while(count1>=0);
        System.out.println("\b\b");

        int count2 = array.length-1;
        while (count2 >= 0){
            System.out.print(array[count2]+"; ");
            count2--;
        }
        System.out.println("\b\b");

        for (int i = array.length-1; i >= 0; i--) {
            System.out.print(array[i]+"; ");
        }
        System.out.println("\b\b");

        /*
        вроде foreach нельзя заставить работать в обратном порядке, поэтому придется для начала изменить массив
        но при использовании foreach нельзя менять сам элемент массива, можно менять только итерационную переменную,
        поэтому нужно создать новый массив, длина которого равна длине нашего массива, и с конца присваивать ему элементы нашего массива
        */
        int[] array1 = new int[array.length];
        int element = array.length-1;
        for (int i : array){
            array1[element] = i;
            element--;
        }
        for (int i : array1) {
            System.out.print(i +"; ");
        }
        System.out.println("\b\b");
    }
}
