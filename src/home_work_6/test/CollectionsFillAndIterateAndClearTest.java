package home_work_6.test;

import home_work_6.dto.*;
import home_work_6.utils.UtilsWithTimeMeasure;
import org.junit.jupiter.api.*;
import java.util.*;

public class CollectionsFillAndIterateAndClearTest {
    int quantity = 1_000_000;
    List<Animal> animalArrayList = new ArrayList<>();
    List<Animal> animalLinkedList = new LinkedList<>();
    List<Person> personArrayList = new ArrayList<>();
    List<Person> personLinkedList = new LinkedList<>();
    Set<Animal> animalHashSet = new HashSet<>();
    Set<Animal> animalTreeSet = new TreeSet<>();
    Set<Person> personHashSet = new HashSet<>();
    Set<Person> personTreeSet = new TreeSet<>();

    @Test
    @DisplayName("Замеряем время заполнения коллекций, время итерации и очистки коллекций")
    public void fillAndIterateAndClear() {
        UtilsWithTimeMeasure.animalCollectionFillAndTimeMeasure(animalArrayList, quantity);
        UtilsWithTimeMeasure.animalCollectionFillAndTimeMeasure(animalLinkedList, quantity);
        UtilsWithTimeMeasure.animalCollectionFillAndTimeMeasure(animalHashSet, quantity);
        UtilsWithTimeMeasure.animalCollectionFillAndTimeMeasure(animalTreeSet, quantity);
        UtilsWithTimeMeasure.personCollectionFillAndWithTimeMeasure(personArrayList, quantity);
        UtilsWithTimeMeasure.personCollectionFillAndWithTimeMeasure(personLinkedList, quantity);
        UtilsWithTimeMeasure.personCollectionFillAndWithTimeMeasure(personHashSet, quantity);
        UtilsWithTimeMeasure.personCollectionFillAndWithTimeMeasure(personTreeSet, quantity);

        System.out.println();

        UtilsWithTimeMeasure.collectionIterationAndClearWithTimeMeasure(animalArrayList);
        UtilsWithTimeMeasure.collectionIterationAndClearWithTimeMeasure(animalLinkedList);
        UtilsWithTimeMeasure.collectionIterationAndClearWithTimeMeasure(personArrayList);
        UtilsWithTimeMeasure.collectionIterationAndClearWithTimeMeasure(personLinkedList);
        UtilsWithTimeMeasure.collectionIterationAndClearWithTimeMeasure(animalHashSet);
        UtilsWithTimeMeasure.collectionIterationAndClearWithTimeMeasure(personHashSet);
        UtilsWithTimeMeasure.collectionIterationAndClearWithTimeMeasure(animalTreeSet);
        UtilsWithTimeMeasure.collectionIterationAndClearWithTimeMeasure(personTreeSet);
        boolean result = (animalArrayList.size() == 0 && animalLinkedList.size() == 0 && personArrayList.size() == 0 &&
                personLinkedList.size() == 0 && animalHashSet.size() == 0 && personHashSet.size() == 0 &&
                animalTreeSet.size() == 0 && personTreeSet.size() == 0);
        Assertions.assertTrue(result, "Операция очистки какой-то коллекции не удалась.");
    }

}
