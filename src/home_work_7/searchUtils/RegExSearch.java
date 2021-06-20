package home_work_7.searchUtils;

import home_work_7.api.ISearchEngine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSearch implements ISearchEngine {

//    public static void main(String[] args) {
//        String text1 = "Май МайМай Май";
//        ISearchEngine s = new RegExSearch();
//        System.out.println(s.search(text1, "Май"));
//    }

    @Override
    public long search(String text, String word) {
        // нужно придумать regex, что искал слово, а не буквенное сочетание
        Pattern pattern = Pattern.compile(word);
        Matcher matcher = pattern.matcher(text);
        int result = 0;
        while (matcher.find()) {
            result++;
        }
        return result;
    }
}
