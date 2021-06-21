package home_work_7.searchUtils;

import home_work_7.api.ISearchEngine;

public class EasySearch implements ISearchEngine {

    private final String symbols = "\"'`!?@№#$%:;^&*-_=+\\|/.,? ~()<>{}[]\\t\\n\\r";

    /**
     * Метод возвращает число, равно количеству повторений в тексте конкретного слова (с учетом регистра). Например, в
     * предложений "Майор Май Майя май" слово "Май" будет найдено 1 раз (учитывая четкое начало и конец слова).
     * @param text текст, в котором производится поиск
     * @param word искомое слово (буквенное сочетание) с учетом регистра
     * @return количество повторений буквенного сочетания в тексте
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
                if (position == 0) {
                     if (checkCharIsNotALetter(text, position+word.length())) {
                         result++;
                     }
                } else if (position == text.length()-word.length()) {
                    if (checkCharIsNotALetter(text, position-1)) {
                        result++;
                    }
                } else {
                    if (checkCharIsNotALetter(text, position+word.length()) & checkCharIsNotALetter(text, position-1)) {
                        result++;
                    }
                }
                position = position+word.length();
            }
        }

        return result;
    }

    /**
     * Метод создан для проверки того, является ли конкретный символ в тексте символом, не являющимся буквой/цифрой -
     * помогает определить, является ли найденное буквенное сочетание словом. Метод приватный, используется только
     * для целей работы основного метода.
     * @param text текст, в котором производится поиск слова.
     * @param position место в тексте, проверка которого производится.
     * @return true - если проверяемый символ - не буква и не цифра, false - если этот символ буква или цифра.
     */
    private boolean checkCharIsNotALetter(String text, int position) {
        char ch = text.charAt(position);
        boolean result = false;
        for (int i = 0; i < this.symbols.length(); i++) {
            char temp = this.symbols.charAt(i);
            if (ch == temp) {
                result = true;
                break;
            }
        }
        return result;
    }
}
