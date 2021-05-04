package home_work_1;

import utils_temp.InputCheck;

public class PhoneNumber {
    public static void main(String[] args) {
        int[] arr = new int[10];
        InputCheck intInput = new InputCheck("Введена не цифра, попробуйте еще раз.");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Введите цифру:");
            while(true){
                int temp = intInput.checkIntInput();
                if (temp / 10 == 0){
                    arr[i] = temp;
                    break;
                }
                System.out.println(intInput.getError());
            }
        }
        intInput.close();
        System.out.println(createPhoneNumber(arr));
    }

    public static String createPhoneNumber(int[] array){
        StringBuilder str = new StringBuilder("(");
        for (int i = 0; i < 3; i++) {
            str.append(array[i]);
        }
        str.append(") ");
        for (int i = 3; i < 6; i++) {
            str.append(array[i]);
        }
        str.append("-");
        for (int i = 6; i < 10; i++) {
            str.append(array[i]);
        }
        return str.toString();
    }
}
