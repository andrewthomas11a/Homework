package home_work_7;

import home_work_7.api.ISearchEngine;
import home_work_7.searchUtils.RegExSearch;
import utils_temp.InputCheck;
import java.io.*;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;

public class MainApp {
    public static void main(String[] args) {

        String userPath = "books";
        System.out.println("Перед вами список книг (романов) Джеймса Хэдли Чейза:");
        // File вроде бы не выдает exception, если путь неверный
        File booksDirectory = new File(userPath);
        File[] booksFiles = booksDirectory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (booksFiles == null || booksFiles.length == 0) {
            System.out.println("В директории нет текстовых файлов.");
            return;
        }

        try (BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < booksFiles.length; i++) {
                System.out.println(i + 1 + ". " + booksFiles[i].getName());
            }

            // используем метод для выбора номера книги в корректном диапазоне (с проверкой)
            int numberOfBook = choseBook(booksFiles.length);
            File chosenBookFile = booksFiles[numberOfBook-1];
            System.out.println("Вы выбрали книгу \"" + numberOfBook + ". " + chosenBookFile.getName() + "\".");

            // используем метод для выбора - продолжить запись с файл или начать заново (с проверкой)
            boolean clearOrNot = outFileClearOrContinue(userInput);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt", !clearOrNot))) {
                searchWordsAndWriteToFile (chosenBookFile, new RegExSearch(), writer, userInput);
            }
            System.out.println("Результаты поиска были записаны в файл result.txt в директории Homework");
        } catch (MalformedInputException e) {
            System.out.println("Невозмно прочитать книгу - она имеет неверный формат кодировки");
        } catch (IOException e) {
            System.out.println("Во время работы с файлом что-то пошло не так. Запустите программу заново");
        }
    }

    public static void searchWordsAndWriteToFile (File book, ISearchEngine searchEngine, BufferedWriter writer, BufferedReader reader) throws IOException{
        System.out.println("Вводите искомое слово. Напишите \"stop\" чтобы закончить");
        long result;
        while (true) {
            // получаем от пользователя слово для поиска
            String word = reader.readLine();
            // прерываем цикл если введено stop-слово
            if (word.equals("stop")) {
                break;
            }
            // если введено что-то еще - ищем слово в тексте
            String bookText = Files.readString(book.toPath());
            result = searchEngine.search(bookText, word);
            // записываем в текстовый файл
            writer.write("\"" + book.getName() + "\" - " + word + " - " + result+"\n");
        }
        writer.flush();
    }

    /**
     * Метод для выбора книги, запрещающий пользователю вводить что-то кроме чисел типа int и числа за пределами
     * заданного количества книг.
     * @param listSize размер списка книг (размер массива)
     * @return Выбранный пользователем порядковым номер. Это не номер элемента в массиве (от 0 до listSize), а
     * именно порядковый номер (от 1 до listSize включительно). Для использования при обращении к массиву необходимо
     * уменьшить на 1.
     */
    public static int choseBook (int listSize) {
        System.out.println("Выберите нужную книгу. Для выбора напишите номер и нажмите Enter.");
        InputCheck inputBookNumber = new InputCheck("Нужно ввести номер книги, попробуйте еще раз.");
        int numberOfBook = inputBookNumber.checkIntInput();
        while (numberOfBook <= 0 || numberOfBook > listSize) {
            System.out.println("Книги с таким номером нет в списке! Попрообуйте еще раз.");
            numberOfBook = inputBookNumber.checkIntInput();
        }
        return numberOfBook;

    }

    /**
     * Метод спрашивает у пользователя - нужно ли очистить файл с результатами поиска и начать запись заново, либо
     * продолжить запить.
     * @param reader Передаваемый в метод BufferedReader (для общего использования в try с ресурсами)
     * @return возвращает true, если файл необходимо очистить
     * @throws IOException (необходимо обработать при выполнении программы)
     */
    public static boolean outFileClearOrContinue (BufferedReader reader) throws IOException {
        System.out.println("Очистить историю поиска и начать заново? Напишите \"yes\" для очистки или \"no\" для продолжения и нажмите Enter:");
        String userWantToClear = reader.readLine();
        while (!userWantToClear.equals("yes") && !userWantToClear.equals("no")) {
            System.out.println("Вы указали что-то не то, попробуйте еще раз (yes/no):");
            userWantToClear = reader.readLine();
        }
        boolean clearOrNot = false;
        if (userWantToClear.equals("yes")) {
            clearOrNot = true;
        }
        return clearOrNot;
    }
}
