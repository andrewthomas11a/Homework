package home_work_7;

import home_work_7.api.ISearchEngine;
import home_work_7.searchUtils.RegExSearch;
import utils_temp.InputCheck;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;

public class MainApp {
    public static void main(String[] args) throws IOException {
        /*
        список txt файлов!!!
        накопление!!!
         */

        String userPath = "Homework\\books";
        System.out.println("Вот список книг в папке:");
        // File вроде бы не выдает exception, если путь неверный
        File booksPath = new File(userPath);
        String[] list = booksPath.list();
        for (int i = 0; i < list.length; i++) {
            System.out.println(i+1 + ". " + list[i]);
        }

        System.out.println("Выберите нужную книгу. Для выбора напишите номер и нажмите Enter.");
        InputCheck input = new InputCheck("Нужно ввести номер книги, попробуйте еще раз.");
        int numberOfBook = input.checkIntInput();
        while (numberOfBook < 0 || numberOfBook > list.length) {
            System.out.println("Книги с таким номером нет в списке! Попрообуйте еще раз.");
            numberOfBook = input.checkIntInput();
        }

        System.out.println("Вы выбрали книгу \"" + list[numberOfBook-1] + "\".");
        String text = Files.readString(Path.of("Homework\\books\\" + list[numberOfBook-1]));
        BufferedWriter writer = new BufferedWriter(new FileWriter("Homework\\result.txt"));
        BufferedReader searchInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вводите искомое слово. Напишите \"stop\" чтобы закончить");

        ISearchEngine findWord = new RegExSearch();
        long result;
        while (true) {
            String word = searchInput.readLine();
            if (word.equals("stop")) {
                break;
            }
            result = findWord.search(text, word);
            writer.write("\"" + list[numberOfBook-1] + "\" - " + word + " - " + result);
            writer.write("\n");
        }
        writer.flush();

        System.out.println("Результаты поиска были записаны в файл result.txt в директории Homework");
    }
}
