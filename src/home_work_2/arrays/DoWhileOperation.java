package home_work_2.arrays;

public class DoWhileOperation implements IArraysOperation{
    public static void main(String[] args) {

    }

    @Override
    public void arrayToConsole(int[] array) {
        int count1 = 0;
        do{
            System.out.print(array[count1]+"; ");
            count1++;
        }while(count1<array.length);
        System.out.println("\b\b");
    }

    @Override
    public void everySecondToConsole(int[] array) {
        if(array.length>1){
            int count1 = 1;
            do{
                System.out.print(array[count1]+"; ");
                count1+=2;
            }while(count1<array.length);
            System.out.println("\b\b");
        }else{
            System.out.println("");
        }
    }

    @Override
    public void arrayToConssoleReverse(int[] array) {
        int count1 = array.length-1;
        do{
            System.out.print(array[count1]+"; ");
            count1--;
        }while(count1>=0);
        System.out.println("\b\b");
    }
}
