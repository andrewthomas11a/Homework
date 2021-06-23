package home_work_7;

import home_work_7.api.ISearchEngine;
import home_work_7.decorators.SearchEngineCaseInsensitive;

import java.util.*;

public class WordsFromTextUtil {

    /**
     * Метод возвращает массив слов, использованных в тексте.
     * @param text текст, в котором производится поиск слов
     * @return массив слов String[] без знаков препинания
     */
    public String[] wordsFromText (String text) {
        // все символы кроме "-" заменяем на пробел
        // любое количество рядом стоящих либо отдельно стоящих "-" заменяем на пробелы
        // используем пробел как delimiter
        text = text.replaceAll("[\\x00-\\x2C\\x2E-\\x2F\\x3A-\\x40\\x5B-\\x60\\x7B-\\x7F]+", " ");
        text = text.replaceAll("(-){2,}?", "-");
        text = text.replaceAll(" -", " ");
        text = text.replaceAll("- ", " ");
        return text.split("\\s+");
    }

    /**
     * Метод помещает в переданную коллекцию Set<String> слова из массива слов без повторений и выдает сообщение
     * о количестве слов, использованных для написания текста (без учета повторений).
     * @param set передаваемая коллекция Set<String>, в которую будут записаны использованные в тексте слова
     * @param words массив слов
     */
    public void uniqueWordsToSet (Set<String> set, String[] words) {
        Collections.addAll(set, words);
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
        Comparator<Map.Entry<String, Integer>> comparator = (o1, o2) -> o2.getValue() - o1.getValue();
        sortedWordsByRepeat.sort(comparator);


        if (quantityOfWords > sortedWordsByRepeat.size()) {
            System.out.println("Количество слов для вывода превышает количество использованных в тексте слов.");
        }

        int quantity = quantityOfWords > sortedWordsByRepeat.size() ? sortedWordsByRepeat.size() : quantityOfWords;
        for (int i = 0; i < quantity; i++) {
            Map.Entry<String, Integer> entry = sortedWordsByRepeat.get(i);
            System.out.println("Слово \"" + entry.getKey() + "\" - " +
                    entry.getValue() + " раз.");
        }
    }

    public void wordRepeatCaseInsensitive (String text, String word, ISearchEngine searchEngine) {
        SearchEngineCaseInsensitive s = new SearchEngineCaseInsensitive(searchEngine);
        System.out.println("Слово \"" + word + "\" повторяется в текст " + s.search(text, word) + " раз(а).");
    }
}
