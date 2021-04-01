package home_work_1;

public class PhoneNumber {
    public static void main(String[] args) {
        int[] arr = {3,7,5,2,9,3,0,2,2,0};
        if (arr.length<10){
            System.out.println("Нужно больше цифр!");
        }else{
        String number = createPhoneNumber(arr);
        /*
        нужно разобраться, есть ли смысл создавать переменную и сохранять в ней результат,
        либо можно сразу печатать результат работы метода (понять как хранится значение переменной типа String в памяти)
        */
        System.out.println(number);
        }
    }

    public static String createPhoneNumber(int[] array){
        return "("+array[0]+array[1]+array[2]+") " + array[3]+array[4]+array[5]+ "-" + array[6]+array[7]+array[8]+array[9];
    }
}
