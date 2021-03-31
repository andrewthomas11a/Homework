package home_work_1;

import java.util.Objects;
import java.util.Scanner;

public class Name1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();

        if (Objects.equals(name, "Вася")){
            System.out.println("Привет!");
            System.out.println("Я тебя так долго ждал");
        }

        if (Objects.equals(name, "Анастасия")){
            System.out.println("Я тебя так долго ждал");
        }

        if (!Objects.equals(name, "Анастасия")&&!Objects.equals(name, "Вася")){
            System.out.println("Добрый день, а вы кто?");
        }

        input.close();
    }
}
