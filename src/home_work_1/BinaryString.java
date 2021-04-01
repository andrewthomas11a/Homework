package home_work_1;

import java.util.Scanner;

public class BinaryString {
    public static void main(String[] args) {
        System.out.println("Введите число от -128 до 127:");
        Scanner inputNumber = new Scanner(System.in);
        if(inputNumber.hasNextByte()) {
            byte number = inputNumber.nextByte();
            System.out.println("Указанное число в двоичной системе: " + toBinaryString(number));
        }else{
            System.out.println("Ввели число за пределами диапазона - не хватает разрядов!");
        }
        inputNumber.close();
    }

    public static String toBinaryString(byte number){
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[array.length-1-i]=(int)(Math.abs(number)/(Math.pow(2, i)))%2;
            // здесь модуль числа перевели в двоичную систему прямым кодом
        }
        if (number >= 0) {
            return ("" + array[0] + array[1] + array[2] + array[3] + array[4] + array[5] + array[6] + array[7]);
        }else {
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i]==1 ? 0 : 1;
                // произвели инверсию (обратный код)
            }
            for (int i = 0; i < array.length; i++) {
                if (array[array.length - 1 - i] == 0) {
                    array[array.length - 1 - i]=1;
                    break;
                }else{
                    array[array.length - 1 - i]=0;
                }
                // дополнительный код: добавляем справа единицу с переносом
            }
            return ("" + array[0] + array[1] + array[2] + array[3] + array[4] + array[5] + array[6] + array[7]);
        }
    }
}
