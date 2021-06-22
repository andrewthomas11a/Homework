package home_work_7.searchUtils;

import home_work_7.api.ISearchEngine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSearch implements ISearchEngine {

    /**
     * Метод возвращает число, равное количеству повторений в тексте конкретного слова (с учетом регистра). Например, в
     * предложений "Майор Май Майя май" слово "Май" будет найдено 1 раз (учитывая четкое начало и конец слова).
     * @param text текст, в котором производится поиск
     * @param word искомое слово (с учетом регистра)
     * @return количество повторений
     */
    @Override
    public long search(String text, String word) {
        Pattern pattern = Pattern.compile("\\b"+word+"\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        int result = 0;
        while (matcher.find()) {
            result++;
        }
        return result;
    }
}
