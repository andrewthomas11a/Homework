package home_work_2.loops;

public class MultTable {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++){
            for (int start = 2; start <6; start++){
                System.out.print(start + " x " + i + " = " + (start*i) + "\t" + "\t");
            }
            System.out.println("\b" + "\b");
        }
        System.out.println("");
        for (int i = 1; i < 11; i++){
            for (int start = 6; start <10; start++){
                System.out.print(start + " x " + i + " = " + (start*i) + "\t" + "\t");
            }
            System.out.println("\b" + "\b");
        }
    }
}
