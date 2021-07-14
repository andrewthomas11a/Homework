package home_work_7.test;

import home_work_7.WordsFromTextUtil;
import home_work_7.searchUtils.*;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WordsFromTextUtilTest {
    final String pathToFile = "WarAndPeace.txt";
    Set<String> uniqueWords = new HashSet<>();
    WordsFromTextUtil util = new WordsFromTextUtil();

    @Order(3)
    @Test
    @DisplayName("Задание 5: Используя реализации интерфейса ISearchEngine вывести информацию" +
            "как часто встречаются слова \"война\", \"и\" (как союз), \"мир\" вне зависимости от регистра.")
    public void wordRepeatCaseInsensitive () {
        boolean pathIsOk = true;
        try {
            String text = Files.readString(Path.of(pathToFile));
            System.out.println("***** результаты EasySearch *****");
            util.wordRepeatCaseInsensitive(text, "война", new EasySearch());
            util.wordRepeatCaseInsensitive(text, "и", new EasySearch());
            util.wordRepeatCaseInsensitive(text, "мир", new EasySearch());
            System.out.println("***** результаты RegExSearch *****");
            util.wordRepeatCaseInsensitive(text, "война", new RegExSearch());
            util.wordRepeatCaseInsensitive(text, "и", new RegExSearch());
            util.wordRepeatCaseInsensitive(text, "мир", new RegExSearch());
        } catch (IOException e) {
            pathIsOk = false;
        }
        Assertions.assertTrue(pathIsOk, "Что-то не так со ссылкой либо ошибка во время чтения");
    }

    @Order(1)
    @Test
    @DisplayName("Выделить слова из текста, поместить уникальные слова в Set")
    public void wordsFromTextAndUniqueWordsToSet() {
        boolean pathIsOk = true;
        boolean result1IsOk = false;
        try {
            String text = Files.readString(Path.of(pathToFile));
            String[] arr = util.wordsFromText(text);
            result1IsOk = arr.length > 1;

            util.uniqueWordsToSet(uniqueWords, arr);

        } catch (IOException e) {
            pathIsOk = false;
        }
        Assertions.assertTrue(pathIsOk, "Что-то не так со ссылкой либо ошибка во время чтения");
        Assertions.assertTrue(result1IsOk, "В массиве слов оказалось меньше 2 слов");
    }

    @Order(2)
    @Test
    @DisplayName("Вывести количество слов с максимальным повторением в тексте в отсортированном порядке")
    public void topNWords() {
        boolean pathIsOk = true;
        try {
            String text = Files.readString(Path.of(pathToFile));
            util.topNWords(text, 15);
        } catch (IOException e) {
            pathIsOk = false;
        }
        Assertions.assertTrue(pathIsOk, "Что-то не так со ссылкой либо ошибка во время чтения");
    }

    @Order(3)
    @Test
    @DisplayName("Проверяем работу утилиты wordsFromText")
    public void numberOfWords () {
        String text1 = "привет, как дела!";         //- тут 3 слова "привет", "как", "дела";
        String text2 = "привет,какдела!";           //- тут 2 слова "привет", "какдела";
        String text3 = "привет;какдела!";           //- тут 2 слова "привет", "какдела";
        String text4 = "как дела!.Что делаешь?";    //- тут 4 слова "как", "дела", "Что", "делаешь";
        String text5 = "Привет-привет";             //- тут 1 слово "Привет-привет";
        String text6 = "Привет -привет";            //- тут 2 слова "Привет", "привет";
        String text7 = "4-х";                       //- тут 1 слово "4-х";
        String text8 = "один и 1";                  //- тут 3 слова "один", "и", "1"
        String text9 = "бабушка бабушке бабушку";   //- тут 3 слова "бабушка", "бабушке", "бабушку"
        String text10 = "Майор Майя* -любит №майский май! поймай .Май";

        WordsFromTextUtil util = new WordsFromTextUtil();
        Assertions.assertEquals(3 ,util.wordsFromText(text1).length);
        Assertions.assertEquals(2 ,util.wordsFromText(text2).length);
        Assertions.assertEquals(2 ,util.wordsFromText(text3).length);
        Assertions.assertEquals(4 ,util.wordsFromText(text4).length);
        Assertions.assertEquals(1 ,util.wordsFromText(text5).length);
        Assertions.assertEquals(2 ,util.wordsFromText(text6).length);
        Assertions.assertEquals(1 ,util.wordsFromText(text7).length);
        Assertions.assertEquals(3 ,util.wordsFromText(text8).length);
        Assertions.assertEquals(3 ,util.wordsFromText(text9).length);
        Assertions.assertEquals(7 ,util.wordsFromText(text10).length);
    }
}
