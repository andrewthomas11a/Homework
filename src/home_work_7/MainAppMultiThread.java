package home_work_7;

import home_work_7.api.ISearchEngine;
import home_work_7.searchUtils.RegExSearch;

import java.io.*;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.*;

public class MainAppMultiThread {
    public static void main(String[] args) {

        String userPath = "books";
        System.out.println("Перед вами список книг (романов) Джеймса Хэдли Чейза:");
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

            System.out.println("\n" + "Поиск будет осуществляться во всех книгах.");
            boolean clearOrNot = outFileClearOrContinue(userInput);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("result2.txt", !clearOrNot))) {
                searchWordsAndWriteToFile(booksFiles, writer, userInput, new RegExSearch());
            }
            System.out.println("Результаты поиска были записаны в файл result2.txt в директории Homework");
        } catch (MalformedInputException e) {
            System.out.println("Невозмно прочитать книгу - она имеет неверный формат кодировки");
        } catch (IOException e) {
            System.out.println("Во время работы с файлом что-то пошло не так. Запустите программу заново");
        }
    }

    public static void searchWordsAndWriteToFile (File[] books, BufferedWriter writer, BufferedReader reader, ISearchEngine searchEngine) throws IOException {
        System.out.println("Вводите искомое слово. Напишите \"stop\" чтобы закончить");
        while (true) {
            ExecutorService exe = Executors.newFixedThreadPool(books.length);
            String word = reader.readLine();
            // прерываем цикл если введено stop-слово
            if (word.equals("stop")) {
                break;
            }
            List<Future<Long>> tasksList = new ArrayList<>();
            for (File book : books) {
                Future<Long> submit = exe.submit(new SearchInFile(book, book.getName(), word, writer, searchEngine));
                tasksList.add(submit);
            }

            long result = 0;
            try {
                while (tasksList.size() > 0) {
                    Iterator<Future<Long>> it = tasksList.iterator();
                    while (it.hasNext()) {
                        Future<Long> futureTask = it.next();
                        if (futureTask.isDone()) {
                            result += futureTask.get();
                            it.remove();
                        }
                    }
                }
                writer.write("* * * * * Слово \"" + word + "\" найдено во всех файлах " + result + " раз(а). * * * * *"
                        + "\n\n");

            } catch (InterruptedException | ExecutionException e) {
                exe.shutdown();
                System.out.println("Во время обработки запроса произошла ошибка, попробуйте еще раз.");
            }
            exe.shutdown();
        }
        writer.flush();
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

class SearchInFile implements Callable<Long> {
    String fileName;
    String word;
    BufferedWriter writer;
    File book;
    ISearchEngine searchEngine;

    SearchInFile (File book, String fileName, String word, BufferedWriter writer, ISearchEngine searchEngine) {
        this.fileName = fileName;
        this.word = word;
        this.writer = writer;
        this.book = book;
        this.searchEngine = searchEngine;
    }

    @Override
    public Long call() throws IOException {
        long result;
        String bookText = Files.readString(book.toPath());
        result = searchEngine.search(bookText, word);
        writer.write("\"" + fileName + "\" - " + word + " - " + result+"\n");
        return result;
    }
}