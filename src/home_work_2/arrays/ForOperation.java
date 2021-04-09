package home_work_2.arrays;

public class ForOperation implements IArraysOperation{
    public static void main(String[] args) {

    }

    @Override
    public void arrayToConsole(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"; ");
        }
        System.out.println("\b\b");
    }

    @Override
    public void everySecondToConsole(int[] array) {
        if (array.length > 1) {
            for (int i = 1; i < array.length; i += 2) {
                System.out.print(array[i] + "; ");
            }
            System.out.println("\b\b");
        } else {
            System.out.println("");
        }
    }

    @Override
    public void arrayToConsoleReverse(int[] array) {
            for (int i = array.length-1; i >= 0; i--) {
                System.out.print(array[i]+"; ");
            }
            System.out.println("\b\b");
    }
}
