package home_work_6.utils;

import home_work_6.dto.*;
import java.lang.*;
import java.util.*;

public class UtilsWithTimeMeasure {

    public static void personCollectionFillAndWithTimeMeasure(Collection<Person> collection, int quantity) {
        long start = System.currentTimeMillis();
        CollectionsRandomFill.fillWithPerson(collection, quantity);
        long finish = System.currentTimeMillis();
        long result = finish - start;
        System.out.println("Операция: Заполнение коллекции класса " + collection.getClass().getSimpleName() +
                " объектами Person. Заняла " + result + " мс.");
    }

    public static void animalCollectionFillAndTimeMeasure(Collection<Animal> collection, int quantity) {
        long start = System.currentTimeMillis();
        CollectionsRandomFill.fillWithAnimal(collection, quantity);
        long finish = System.currentTimeMillis();
        long result = finish - start;
        System.out.println("Операция: Заполнение коллекции класса " + collection.getClass().getSimpleName() +
                " объектами Animal. Заняла " + result + " мс.");
    }

    public static <T> void collectionIterationAndClearWithTimeMeasure(Collection<T> collection) {
        Iterator<T> it = collection.iterator();
        long start = System.currentTimeMillis();
        while(it.hasNext()) {
            it.next();
        }
        long finish = System.currentTimeMillis();
        System.out.println("Операция: Итерирование коллекции класса " + collection.getClass().getSimpleName() +
                " при помощи Iterator. Заняла " + (finish - start) + " мс.");

        start = System.currentTimeMillis();
        List<T> array = new ArrayList<>(collection);
        for (int i = 0; i < array.size(); i++) {
            // итерация
        }
        finish = System.currentTimeMillis();
        System.out.println("Операция: Итерирование коллекции класса " + collection.getClass().getSimpleName() +
                " при помощи цикла FOR. Заняла " + (finish - start) + " мс.");

        start = System.currentTimeMillis();

        it = collection.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        finish = System.currentTimeMillis();
        System.out.println("Операция: Удаление элементов коллекции класса " + collection.getClass().getSimpleName() +
                " при помощи Iterator. Заняла " + (finish - start) + " мс." + "\n");
    }
}
