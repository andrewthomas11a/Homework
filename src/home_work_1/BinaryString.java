package home_work_1;

import java.util.Scanner;

public class BinaryString {
    public static void main(String[] args) {
        System.out.println("Введите число от -128 до 127:");
        Scanner inputNumber = new Scanner(System.in);
        if(!inputNumber.hasNextByte()) {
            System.out.println("Ввели число за пределами диапазона - не хватает разрядов!");
        }else{
            byte number = inputNumber.nextByte();
            System.out.println("Указанное число в двоичной системе: " + toBinaryString(number));
        }
    }

    public static String toBinaryString(byte number){
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[array.length-1-i]=(int)(Math.abs(number)/(Math.pow(2, i)))%2;
        }
        if (number >= 0) {
            return ("" + array[0] + array[1] + array[2] + array[3] + array[4] + array[5] + array[6] + array[7]);
        }else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 1) {
                    array[i] = 0;
                } else {
                    array[i] = 1;
                }
            }
            for (int i = 0; i < array.length; i++) {
                if (array[array.length - 1 - i] == 0) {
                    array[array.length - 1 - i]=1;
                    break;
                }else{
                    array[array.length - 1 - i]=0;
                }
            }
            return ("" + array[0] + array[1] + array[2] + array[3] + array[4] + array[5] + array[6] + array[7]);
        }

    }
}
