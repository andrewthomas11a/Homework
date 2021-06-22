package home_work_7;

import home_work_7.api.ISearchEngine;
import home_work_7.searchUtils.EasySearch;
import home_work_7.searchUtils.RegExSearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Words {

    // убрать точку входа, заменить на тестирование
    public static void main(String[] args) {
        Set<String> uniqueWords = new HashSet<>();
        Words w = new Words();
        try {
            String text = Files.readString(Path.of("Homework\\WarAndPeace.txt"));
            w.uniqueWordsToSet(uniqueWords, text);
            w.topNWords(text, 10);
            System.out.println("EasySearch");
            w.numberOfRepeat(text, "война", new EasySearch());
            w.numberOfRepeat(text, "и", new EasySearch());
            w.numberOfRepeat(text, "мир", new EasySearch());
            System.out.println("RegExSearch");
            w.numberOfRepeat(text, "война", new RegExSearch());
            w.numberOfRepeat(text, "и", new RegExSearch());
            w.numberOfRepeat(text, "мир", new RegExSearch());
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла.");
        }
    }

    /**
     * Метод возвращает массив слов, использованных в тексте.
     * @param text текст, в котором производится поиск слов
     * @return массив слов без знаков препинания
     */
    public String[] wordsFromText (String text) {
        text = text.replaceAll("[\\x00-\\x2C\\x2E-\\x2F\\x3A-\\x40\\x5B-\\x60\\x7B-\\x7F]+", " ");
        text = text.replaceAll(" -", " ");
        text = text.replaceAll("- ", " ");
        return text.split("\\s+");
    }

    /**
     * Метод помещает в переданную коллекцию Set<String> слова из текста и выдает сообщение о количестве слов,
     * использованных для написания текста (без учета повторений).
     * @param set передаваемая коллекция Set<String>, в которую будут записаны использованные в тексте слова
     * @param text текст, в котором производится поиск слов
     */
    public void uniqueWordsToSet (Set<String> set, String text) {
        Collections.addAll(set, wordsFromText(text));
        System.out.println("В тексте было найдено " + set.size() + " уникальных слов.");
    }

    /**
     * Метод ищет повторения слов в тексте и выводит нужное количество "лидеров" по повторениям в отсортированном
     * виде - от большего к меньшему.
     * @param text текст, в котором производится поиск слов
     * @param quantityOfWords необходимое для вывода количество максимально повторяющихся слов
     */
    public void topNWords (String text, int quantityOfWords) {
        String[] words = wordsFromText(text);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                Integer repeat = map.get(words[i]);
                // если правильно понимаю, имеющийся "ключ-значение" заменится на новый, если такой ключ уже есть
                map.put(words[i], repeat+1);
            } else {
                map.put(words[i], 1);
            }
        }

        List<Map.Entry<String, Integer>> sortedWordsByRepeat = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<String, Integer>> comparator = (o1, o2) -> {return o2.getValue() - o1.getValue();};
        //в целом можно и так:
        //Comparator<Map.Entry<String, Integer>> comparator = Comparator.comparingInt(Map.Entry::getValue);
        sortedWordsByRepeat.sort(comparator);

        for (int i = 0; i < quantityOfWords; i++) {
            Map.Entry<String, Integer> entry = sortedWordsByRepeat.get(i);
            System.out.println("Слово \"" + entry.getKey() + "\" - " +
                    entry.getValue() + " раз.");
        }
    }

    public void numberOfRepeat (String text, String word, ISearchEngine search) {
        // нужно вне зависимости от регистра, а некоторые наши поисковики учитывают регистр :(
        System.out.println("Слово " + word + " повторяется в текст " + search.search(text, word) + " раз(а).");
    }
}
