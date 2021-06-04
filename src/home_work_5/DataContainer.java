package home_work_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class DataContainer <T> implements Iterable{
    private T[] data;

    DataContainer(T[] data) {
        this.data = data;
    }

    /**
     * Метод добавляет в контейнер переданный элемент на ближайшую с начала пустую ячейку. Если контейнер пустой или
     * переполнен - увеличивает его размер на 1 и добавляет элемент в свободную ячейку. В контейнер запрещено добавлять null
     * @param item передаваемый элемент, который необходимо добавить.
     * @return номер ячейки в контейнере (начиная с 0), в которую был помещен переданный элемент. Возвратит -1, если
     * данный элемент в контейнер поместить нельзя.
     */
    public int add(T item) {
        int index = -1;
        // запрещаем методу добавлять в контейнер null
        if (item != null) {
            // проверяем, не переполнен ли контейнер, т.е. есть ли хоть один null, если есть - запоминаем его номер
            // цикл не запустится, если длина массива - 0 (пустой контейнер)
            for (int i = 0; i < data.length; i++) {
                if (data[i] == null) {
                    index = i;
                    break;
                }
            }

            // если контейнер пустой или переполнен - расширяем его на 1.
            // номер элемента, подлежащего заполнению, будет последним (0 - для увеличенного на 1 пустого массива;
            // последний элемент - для переполненного массива).
            if (index == -1) {
                data = Arrays.copyOf(data, data.length + 1);
                index = data.length - 1;
            }

            data[index] = item;
        }
        return index;
    }

    /**
     * Метод возвращает элемент из контейнера под переданным порядковым номером (начиная с 0).
     * @param index порядковый номер (номер ячейки) нужного элемента (начиная с 0).
     * @return искомый элемент.
     */
    public T get(int index) {
        // добавил проверку, чтобы тупой программист (я) не ввел index меньше нуля или за пределами размера контейнера
        // учитываем, что если массив пустой, то любой индекс (даже 0) выдаст ошибку out of bounds
        if (index < 0 || data.length == 0 || index > data.length - 1) {
            return null;
        } else {
            return data[index];
        }
    }

    /**
     * Возвращает приватное поле data этого класса.
     * @return приватное поле data этого класса.
     */
    public T[] getItems() {
        return this.data;
    }

    /**
     * Метод удаляет из контейнера элемент с заданным порядковым номером. Ячейка, из которой удален элемент, не остается
     * пустой, а удаляется полностью.
     *
     * @param index порядковый номер элемента, который необходимо удалить.
     * @return false - если удаление элемента произвести невозможно; true - если удаление завершено успешно.
     */
    public boolean delete(int index) {
        // добавил проверку, чтобы тупой программист (я) не ввел index меньше нуля или за пределами размера контейнера
        // учитываем, что если массив пустой, то любой индекс (даже 0) выдаст ошибку out of bounds
        if (index < 0 || data.length == 0 || index > data.length - 1) {
            return false;
        } else {
            if (index != data.length - 1) {
                for (int i = index; i < data.length - 1; i++) {
                    data[i] = data[i + 1];
                }
            }
            data = Arrays.copyOf(data, data.length - 1);
            return true;
        }
    }

    /**
     * Метод удаляет из контейнера передаваемый элемент. Ячейка, из которой удален элемент, не остается пустой,
     * а удаляется полностью.
     * @param item искомый элемент.
     * @return false - если удаление элемента произвести невозможно; true - если удаление завершено успешно.
     */
    public boolean delete(T item) {
        boolean isDeleted = false;
        // нужно ли позволять методу удалять null? допустим, что нужно, в задаче не сказано иное
        for (int i = 0; i < data.length; i++) {
            if (Objects.equals(data[i], item)) {
                // здесь одновременно производим удаление с помощью ранее созданного метода и записываем в переменную результат
                isDeleted = delete(i);
                break;
            }
        }
        return isDeleted;
    }

    /**
     * Метод производит сортировку контейнера от меньшего к большему, используя для сравнения метод переданного
     * объекта comparator типа Comparator<T>
     * @param comparator - объект типа Comparator<T>, метод сравнения которого используется
     */
    public void sort(Comparator<? super T> comparator){
        // если правильно понимаю, в дженерик Comparator'а записываем именно эту wildcard, чтобы можно было передать
        // реализацию сравнения не только нужного нам класса, но и его родителя
        if (comparator != null){
            // пузырьковая сортировка ("выталкивание" большего элемента в конец)
            for (int i = 1; i < data.length; i++) {
                for (int j = 0; j < data.length - i; j++) {
                    if (comparator.compare(data[j], data[j + 1]) > 0) {
                        T temp = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = temp;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(data.length*2+1);
        str.append("DataContainer{");
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null){
                str.append(data[i]);
            }
            if ((i != data.length-1) && data[i+1] != null){
                str.append(", ");
            }
        }
        str.append("}");
        return str.toString();
    }

    public static <Z extends Comparable> void sort(DataContainer<Z> container){
            for (int i = 1; i < container.data.length; i++) {
                for (int j = 0; j < container.data.length - i; j++) {
                    if (container.data[j].compareTo(container.data[j + 1]) > 0) {
                        Z temp = container.data[j];
                        container.data[j] = container.data[j + 1];
                        container.data[j + 1] = temp;
                    }
                }
            }
    }

    public static <Z> void sort(DataContainer<Z> container, Comparator<? super Z> comparator){
        if (comparator != null){
            for (int i = 1; i < container.data.length; i++) {
                for (int j = 0; j < container.data.length - i; j++) {
                    if (comparator.compare(container.data[j], container.data[j + 1]) > 0) {
                        Z temp = container.data[j];
                        container.data[j] = container.data[j + 1];
                        container.data[j + 1] = temp;
                    }
                }
            }
        }
    }

    // тут еще не разобрался :(
    public Iterator<T> iterator(){
        return this.iterator();
    }
}
