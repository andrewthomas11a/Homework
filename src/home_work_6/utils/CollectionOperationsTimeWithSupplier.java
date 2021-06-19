package home_work_6.utils;

import java.util.*;
import java.util.function.Supplier;

public class CollectionOperationsTimeWithSupplier {

    // это такой же класс, только вместо отдельного метода для заполнения конкретным объектом использован Supplier

    public static <T> void fillIterationClearTimeMeasure(Collection<T> collection, Supplier<T> supplier, int quantity) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < quantity; i++) {
            collection.add(supplier.get());
        }
        long finish = System.currentTimeMillis();
        long result = finish - start;
        System.out.println("Операция: Заполнение коллекции класса " + collection.getClass().getSimpleName() +
                ". Заняла " + result + " мс.");

        Iterator<T> it = collection.iterator();
        start = System.currentTimeMillis();
        while(it.hasNext()) {
            it.next();
            // итерация
        }
        finish = System.currentTimeMillis();
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
