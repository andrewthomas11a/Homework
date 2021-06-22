package home_work_7.decorators;

import home_work_7.api.ISearchEngine;

public class SearchEnginePunctuationNormalizer implements ISearchEngine {

    private final ISearchEngine searchEngine;

    public SearchEnginePunctuationNormalizer(ISearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }

    @Override
    public long search(String text, String word) {
        text = text.replaceAll("[\\x00-\\x2C\\x2E-\\x2F\\x3A-\\x40\\x5B-\\x60\\x7B-\\x7F]+", " ");
        text = text.replaceAll("(-){2,}?", "-");
        text = text.replaceAll(" -", " ");
        text = text.replaceAll("- ", " ");
        return searchEngine.search(text, word);
    }
}
