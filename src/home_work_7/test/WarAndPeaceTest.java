package home_work_7.test;

import home_work_7.WordsFromTextUtil;
import home_work_7.searchUtils.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WarAndPeaceTest {

    final String pathToFile = "WarAndPeace.txt";
    Set<String> uniqueWords = new HashSet<>();
    WordsFromTextUtil util = new WordsFromTextUtil();

    @Test
    @DisplayName("Задание 5: Используя реализации интерфейса ISearchEngine вывести информацию" +
            "как часто встречаются слова \"война\", \"и\" (как союз), \"мир\" вне зависимости от регистра.")
    public void wordRepeatCaseInsensitive () {
        boolean pathIsOk = true;
        try {
            String text = Files.readString(Path.of(pathToFile));
            util.wordRepeatCaseInsensitive(text, "война", new EasySearch());
            util.wordRepeatCaseInsensitive(text, "и", new EasySearch());
            util.wordRepeatCaseInsensitive(text, "мир", new EasySearch());

            util.wordRepeatCaseInsensitive(text, "война", new RegExSearch());
            util.wordRepeatCaseInsensitive(text, "и", new RegExSearch());
            util.wordRepeatCaseInsensitive(text, "мир", new RegExSearch());
        } catch (IOException e) {
            pathIsOk = false;
        }
        Assertions.assertTrue(pathIsOk, "Что-то не так со ссылкой");
    }
}
