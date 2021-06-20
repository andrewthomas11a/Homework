package home_work_7.searchUtils;

import home_work_7.api.ISearchEngine;

public class EasySearch implements ISearchEngine {

    /**
     * Метод ищет количество повторов буквенного сочетания в конкретном тексте, учитывая регистр. Например, для текста
     * "Май - любимый месяц Майора" и слова "Май" метод вернет результат 2.
     * @param text текст, в котором производится поиск
     * @param word искомое слово (буквенное сочетание) с учетом регистра
     * @return количество повторений буквенного сочетания в тексте, с учетом регистра
     */
    @Override
    public long search(String text, String word) {
        int position = 0;
        int result = 0;

        while (true) {
            position = text.indexOf(word, position);
            if (position == -1) {
                break;
            } else {
                result++;
                position = position+word.length();
            }
        }

        return result;
    }
}
