package home_work_6.test;

import home_work_6.dto.*;
import home_work_6.suppliers.GetAnimalRandom;
import home_work_6.suppliers.GetPersonRandom;
import home_work_6.utils.CollectionOperationsTimeWithSupplier;
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
    @DisplayName("Замер времени заполнения, итерации и очистки коллекций.")
    public void fillAndIterateAndClear() {

        System.out.println("\tЗаполняем коллекции объектами Animal и выполняем другие операции:");
        CollectionOperationsTimeWithSupplier.fillIterationClearTimeMeasure(animalArrayList, new GetAnimalRandom(), quantity);
        CollectionOperationsTimeWithSupplier.fillIterationClearTimeMeasure(animalLinkedList, new GetAnimalRandom(), quantity);
        CollectionOperationsTimeWithSupplier.fillIterationClearTimeMeasure(animalHashSet, new GetAnimalRandom(), quantity);
        CollectionOperationsTimeWithSupplier.fillIterationClearTimeMeasure(animalTreeSet, new GetAnimalRandom(), quantity);
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        System.out.println("\tЗаполняем коллекции объектами Person и выполняем другие операции:");
        CollectionOperationsTimeWithSupplier.fillIterationClearTimeMeasure(personArrayList, new GetPersonRandom(), quantity);
        CollectionOperationsTimeWithSupplier.fillIterationClearTimeMeasure(personLinkedList, new GetPersonRandom(), quantity);
        CollectionOperationsTimeWithSupplier.fillIterationClearTimeMeasure(personHashSet, new GetPersonRandom(), quantity);
        CollectionOperationsTimeWithSupplier.fillIterationClearTimeMeasure(personTreeSet, new GetPersonRandom(), quantity);

        boolean result = (animalArrayList.size() == 0 && animalLinkedList.size() == 0 && personArrayList.size() == 0 &&
                personLinkedList.size() == 0 && animalHashSet.size() == 0 && personHashSet.size() == 0 &&
                animalTreeSet.size() == 0 && personTreeSet.size() == 0);
        Assertions.assertTrue(result, "Операция очистки какой-то коллекции не удалась.");
    }

}
