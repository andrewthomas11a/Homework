package home_work_1;

import java.util.Scanner;

public class Name3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        final String name1 = "Вася";
        final String name2 = "Анастасия";

        switch (name){
            case name1:
                System.out.println("Привет!");
            case name2:
                System.out.println("Я тебя так долго ждал");
                break;
            default:
                System.out.println("Добрый день, а вы кто?");
                break;
        }

        input.close();
    }
}
