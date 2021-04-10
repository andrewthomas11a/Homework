package home_work_2.arrays;

public class ForEachOperation implements IArraysOperation{

    @Override
    public void arrayToConsole(int[] array) {
        for (int i : array) {
            System.out.print(i +"; ");
        }
        System.out.println("\b\b");
    }

    @Override
    public void everySecondToConsole(int[] array) {
        int count3 = 0;
        for (int i : array) {
            if (count3%2!=0){
                System.out.print(i +"; ");
            }
            count3++;
        }
        System.out.println("\b\b");
    }

    @Override
    public void arrayToConsoleReverse(int[] array) {
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
