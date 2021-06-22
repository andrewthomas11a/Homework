package home_work_7;

import home_work_7.api.ISearchEngine;
import home_work_7.searchUtils.RegExSearch;
import utils_temp.InputCheck;
import java.io.*;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainApp {
    public static void main(String[] args) throws IOException {

        String userPath = "Homework\\books";
        System.out.println("Перед вами список книг (романов) Джеймса Хэдли Чейза:");
        // File вроде бы не выдает exception, если путь неверный
        File booksPath = new File(userPath);
        String[] list = booksPath.list();

        try {
            for (int i = 0; i < list.length; i++) {
                System.out.println(i + 1 + ". " + list[i]);
            }
            System.out.println("Выберите нужную книгу. Для выбора напишите номер и нажмите Enter.");
            InputCheck input = new InputCheck("Нужно ввести номер книги, попробуйте еще раз.");
            int numberOfBook = input.checkIntInput();
            while (numberOfBook < 0 || numberOfBook > list.length) {
                System.out.println("Книги с таким номером нет в списке! Попрообуйте еще раз.");
                numberOfBook = input.checkIntInput();
            }

            System.out.println("Вы выбрали книгу \"" + list[numberOfBook - 1] + "\".");

            // Может читать только UTF-8, судя по документации
            // при попытке чтения файла другой кодировки выдает MalformedInputException
            String text = Files.readString(Path.of("Homework\\books\\" + list[numberOfBook - 1]));
            boolean clearOrNot = false;
            System.out.println("Очистить историю поиска и начать заново? Напишите \"yes\" для очистки или \"no\" для продолжения и нажмите Enter:");

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String userWantToClear = userInput.readLine();
            while (!userWantToClear.equals("yes") && !userWantToClear.equals("no")) {
                System.out.println("Вы указали что-то не то, попробуйте еще раз (yes/no):");
                userWantToClear = userInput.readLine();
            }
            if (userWantToClear.equals("yes")) {
                clearOrNot = true;
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("Homework\\result.txt", !clearOrNot));

            System.out.println("Вводите искомое слово. Напишите \"stop\" чтобы закончить");

            ISearchEngine findWord = new RegExSearch();
            long result;
            while (true) {
                String word = userInput.readLine();
                if (word.equals("stop")) {
                    break;
                }
                result = findWord.search(text, word);
                writer.write("\"" + list[numberOfBook - 1] + "\" - " + word + " - " + result);
                writer.write("\n");
            }
            writer.flush();
            writer.close();

            System.out.println("Результаты поиска были записаны в файл result.txt в директории Homework");

        } catch (NullPointerException e) {
            System.out.println("Что-то не то со ссылкой, в указанной директории ничего нет.");
        } catch (MalformedInputException e) {
            System.out.println("Невозмно прочитать книгу - она имеет неверный формат кодировки");
        } catch (IOException e) {
            System.out.println("Во время работы с файлом что-то пошло не так. Запустите программу заново");
        } finally {
            // тут надо бы закрыть файл и закончить запись если при многопочтоной работе будет IOException
            // или имплементить интерфейс AutoClosable и делать try с ресурсами..?
        }
    }
}
