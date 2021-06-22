package home_work_7.decorators;

import home_work_7.api.ISearchEngine;
import home_work_7.searchUtils.*;

public class SearchEngineCaseInsensitive implements ISearchEngine {

    private final ISearchEngine searchEngine;

    public SearchEngineCaseInsensitive (ISearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }

    @Override
    public long search(String text, String word) {
        if (this.searchEngine instanceof EasySearch) {
            return searchEngine.search(text.toLowerCase(), word.toLowerCase());
        } else if (this.searchEngine instanceof RegExSearch){
            String newWord = "(?ui)"+word;
            return searchEngine.search(text, newWord);
        } else {
            // на случай, если напишем еще один поисковик
            return searchEngine.search(text, word);
        }
    }
}
