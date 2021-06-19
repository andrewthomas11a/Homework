package home_work_6.utils;

import home_work_6.dto.*;
import java.lang.*;
import java.util.*;

public class CollectionOperationsTime {

    // заменил на аналогичный класс с Supplier

    public static void personFillTimeMeasure(Collection<Person> collection, int quantity) {
        long start = System.currentTimeMillis();
        CollectionsRandomFill.fillWithPerson(collection, quantity);
        long finish = System.currentTimeMillis();
        long result = finish - start;
        System.out.println("Операция: Заполнение коллекции класса " + collection.getClass().getSimpleName() +
                " объектами Person. Заняла " + result + " мс.");
    }

    public static void animalFillTimeMeasure(Collection<Animal> collection, int quantity) {
        long start = System.currentTimeMillis();
        CollectionsRandomFill.fillWithAnimal(collection, quantity);
        long finish = System.currentTimeMillis();
        long result = finish - start;
        System.out.println("Операция: Заполнение коллекции класса " + collection.getClass().getSimpleName() +
                " объектами Animal. Заняла " + result + " мс.");
    }

    public static <T> void fillIterationClearTimeMeasure(Collection<T> collection) {
        Iterator<T> it = collection.iterator();
        long start = System.currentTimeMillis();
        while(it.hasNext()) {
            it.next();
        }
        long finish = System.currentTimeMillis();
        System.out.println("Операция: Итерирование коллекции класса " + collection.getClass().getSimpleName() +
                " при помощи Iterator. Заняла " + (finish - start) + " мс.");

        start = System.currentTimeMillis();
        // не уверен, что это правильный способ итерирования с помощью цикла FOR
        List<T> array = new ArrayList<>(collection);
        for (int i = 0; i < array.size(); i++) {
            array.get(i);
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
