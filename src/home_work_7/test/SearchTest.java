package home_work_7.test;

import home_work_7.api.ISearchEngine;
import home_work_7.decorators.*;
import home_work_7.searchUtils.*;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchTest {
    ISearchEngine engine;

    String text1 = "привет, как дела!";         //- тут три слова "привет", "как", "дела";
    String text2 = "привет,какдела!";           //- тут два слова "привет", "какдела";
    String text3 = "привет;какдела!";           //- тут два слова "привет", "какдела";
    String text4 = "как дела!.Что делаешь?";    //- тут четыре слова "как", "дела", "Что", "делаешь";
    String text5 = "Привет-привет";             //- тут одно слово "Привет-привет";
    String text6 = "Привет -привет";            //- тут два слова "Привет", "привет";
    String text7 = "4-х";                       //- тут одно слово "4-х";
    String text8 = "один и 1";                  //- тут три слова "один", "и", "1"
    String text9 = "бабушка бабушке бабушку";   //- тут три слова "бабушка", "бабушке", "бабушку"
    String text10 = "Майор Майя* -любит №майский май! поймай .Май";

    @Order(1)
    @Test
    @DisplayName("Проверяем работу EasySearch")
    public void EasySearchTest() {
        engine = new EasySearch();
        // проблемы с нахождением слов типа "привет-привет"
        assertionsCaseSens(engine);
    }

    @Order(2)
    @Test
    @DisplayName("Проверяем работу RegExSearch")
    public void RegExSearchTest() {
        engine = new RegExSearch();
        // проблемы с нахождением слов типа "привет-привет"
        assertionsCaseSens(engine);
    }

    @Order(3)
    @Test
    @DisplayName("Проверяем работу SearchEngineCaseInsensitive(new RegExSearch)")
    public void SearchEngineCaseInsensitive() {
        engine = new SearchEngineCaseInsensitive(new RegExSearch());
        Assertions.assertEquals(2, engine.search(text10, "май"));
        Assertions.assertEquals(2, engine.search(text10, "Май"));
    }

    @Order(4)
    @Test
    @DisplayName("Проверяем работу SearchEnginePunctuationNormalizer")
    public void SearchEnginePunctuationNormalizer() {
        engine = new SearchEnginePunctuationNormalizer(new SearchEngineCaseInsensitive(new RegExSearch()));
        Assertions.assertEquals(2, engine.search(text10, "май"));
        Assertions.assertEquals(2, engine.search(text10, "Май"));
    }

    public void assertionsCaseSens(ISearchEngine engine) {
        Assertions.assertEquals(1, engine.search(text1, "привет"));
        Assertions.assertEquals(1, engine.search(text2, "привет"));
        Assertions.assertEquals(1, engine.search(text3, "привет"));
        Assertions.assertEquals(0, engine.search(text5, "привет"));
        Assertions.assertEquals(1, engine.search(text6, "привет"));
        Assertions.assertEquals(1, engine.search(text7, "4-x"));
        Assertions.assertEquals(1, engine.search(text7, "май"));
    }
}
