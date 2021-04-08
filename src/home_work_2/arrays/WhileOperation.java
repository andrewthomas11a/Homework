package home_work_2.arrays;

public class WhileOperation implements IArraysOperation{
    public static void main(String[] args) {

    }

    @Override
    public void arrayToConsole(int[] array) {
        int count2 = 0;
        while (count2 < array.length){
            System.out.print(array[count2]+"; ");
            count2++;
        }
        System.out.println("\b\b");
    }

    @Override
    public void everySecondToConsole(int[] array) {
        if(array.length>1){
            int count2 = 1;
            while (count2 < array.length){
                System.out.print(array[count2]+"; ");
                count2+=2;
            }
            System.out.println("\b\b");
        }else{
            System.out.println("");
        }
    }

    @Override
    public void arrayToConssoleReverse(int[] array) {
        int count2 = array.length-1;
        while (count2 >= 0){
            System.out.print(array[count2]+"; ");
            count2--;
        }
        System.out.println("\b\b");
    }
}
