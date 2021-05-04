package home_work_1;

import java.util.Objects;
import java.util.Scanner;

public class Name2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        final String name1 = "Вася";
        final String name2 = "Анастасия";
        boolean isName1 = Objects.equals(name, name1);
        boolean isName2 = Objects.equals(name, name2);

        if(isName1){
            System.out.println("Привет!");
            System.out.println("Я тебя так долго ждал");
        }else if(isName2){
            System.out.println("Я тебя так долго ждал");
        }else{
            System.out.println("Добрый день, а вы кто?");
        }

        input.close();
    }
}
