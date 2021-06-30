package home_work_7;

import home_work_7.api.ISearchEngine;
import home_work_7.searchUtils.RegExSearch;

import java.io.*;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainAppMultiThread {
    public static void main(String[] args) throws IOException {

        String userPath = "books";
        System.out.println("Перед вами список книг (романов) Джеймса Хэдли Чейза:");
        // File вроде бы не выдает exception, если путь неверный
        File booksPath = new File(userPath);
        String[] list = booksPath.list();

        try (BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))){
            for (int i = 0; i < list.length; i++) {
                System.out.println(i + 1 + ". " + list[i]);
            }

            System.out.println("\n" + "Поиск будет осуществляться во всех книгах.");
            System.out.println("Очистить историю поиска и начать заново? Напишите \"yes\" для очистки или \"no\" для продолжения и нажмите Enter:");
            String userWantToClear = userInput.readLine();
            while (!userWantToClear.equals("yes") && !userWantToClear.equals("no")) {
                System.out.println("Вы указали что-то не то, попробуйте еще раз (yes/no):");
                userWantToClear = userInput.readLine();
            }
            boolean clearOrNot = false;
            if (userWantToClear.equals("yes")) {
                clearOrNot = true;
            }

            // вложенный try-catch.
            // не знаю как по-другому в конструктор передать полученное в ходе выполнения программы значение
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("result2.txt", !clearOrNot));) {
                System.out.println("Вводите искомое слово. Напишите \"stop\" чтобы закончить");
                ExecutorService exe;
                while (true) {
                    exe = Executors.newFixedThreadPool(list.length);
                    // получаем от пользователя слово для поиска
                    String word = userInput.readLine();
                    // прерываем цикл если введено stop-слово
                    if (word.equals("stop")) {
                        break;
                    }
                    List<Future<Long>> tasksList = new ArrayList<>();
                    for (int i = 0; i < list.length; i++) {
                        Future<Long> submit = exe.submit(new SearchInFile(list[i], word, writer));
                        tasksList.add(submit);
                    }

                    long result = 0;
                    try {
                        for (Future<Long> futureTast : tasksList) {
                            long tempResult = futureTast.get();
                            result += tempResult;
                        }
                        writer.write("* * * * * Слово \""+word+"\" найдено во всех файлах "+result+" раз(а). * * * * *"
                                + "\n\n");
                    } catch (InterruptedException | ExecutionException e) {
                        exe.shutdown();
                        System.out.println("Во время обработки запроса произошла ошибка, попробуйте еще раз.");
                    }
                    exe.shutdown();
                }
                writer.flush();
                exe.shutdown();
            }
            System.out.println("Результаты поиска были записаны в файл result2.txt в директории Homework");
        } catch (NullPointerException e) {
            System.out.println("Что-то не то со ссылкой, в указанной директории ничего нет.");
        } catch (MalformedInputException e) {
            System.out.println("Невозмно прочитать книгу - она имеет неверный формат кодировки");
        } catch (IOException e) {
            System.out.println("Во время работы с файлом что-то пошло не так. Запустите программу заново");
        }
    }
}

class SearchInFile implements Callable<Long> {
    String fileName;
    String word;
    BufferedWriter writer;

    SearchInFile (String fileName, String word, BufferedWriter writer) {
        this.fileName = fileName;
        this.word = word;
        this.writer = writer;
    }

    @Override
    public Long call() throws IOException {
        long result;
        String bookText = Files.readString(Path.of("books\\" + fileName));
        ISearchEngine findWord = new RegExSearch();
        result = findWord.search(bookText, word);
        writer.write("\"" + fileName + "\" - " + word + " - " + result+"\n");
        return result;
    }
}