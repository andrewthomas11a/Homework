package home_work_5;

import java.util.Arrays;

public class DataContainer <T>{
    private T[] data;

    DataContainer(T[] data){
        this.data = data;
    }

    /**
     * Метод добавляет в контейнер переданный элемент на ближайшую с начала пустую ячейку. Если контейнер пустой или
     * переполнен - увеличивает его размер на 1 и добавляет элемент в свободную ячейку.
     * @param item передаваемый элемент, который необходимо добавить.
     * @return номер ячейки в контейнере (начиная с 0), в которую был помещен переданный элемент. Возвратит -1, если
     * данный элемент контейнер поместить нельзя.
     */
    public int add(T item){
        boolean isFull = true;
        int index = -1;

        // проверяем, не переполнен ли контейнер (есть ли хоть один null)
        // если есть null элемент - запоминаем его номер
        // цикл не запустится, если длина массива - 0 (пустой контейнер)
        for (int i = 0; i < data.length; i++){
            if (data[i] == null){
                isFull = false;
                index = i;
                break;
            }
        }

        // если контейнер пустой (длина массива - 0) или переполнен - расширяем его на 1.
        // номер элемента, подлежащего заполнению, будет последним (0 - для увеличенного на 1 пустого массива;
        // последний элемент - для переполненного массива).
        if (data.length == 0 || isFull){
            data = Arrays.copyOf(data, data.length+1);
            index = data.length-1;
        }

        //  из задачи - "-1 будет индикатором того что данный элемент в наш контейнер вставлять нельзя."
        // зачем это? :)
        data[index] = item;
        if (item == null){
            return -1;
        }else{
            return index;
        }
    }

    /**
     * Метод возвращает элемент из контейнера под переданным порядковым номером (начиная с 0).
     * @param index порядковый номер (номер ячейки) нужного элемента (начиная с 0).
     * @return искомый элемент.
     */
    public T get(int index){
        // добавил проверку, чтобы тупой программист (я) не ввел index меньше нуля или за пределами размера контейнера
        if (index < 0 || data.length == 0 || index > data.length-1){
            return null;
        }else{
            return data[index];
        }
    }

    /**
     * Возвращает приватное поле data этого класса.
     * @return приватное поле data этого класса.
     */
    public T[] getItems(){
        return this.data;
    }

    /**
     * Метод удаляет из контейнера элемент с заданным порядковым номером. Ячейка, из которой удален элемент, не остается
     * пустой, а удаляется полностью.
     * @param index порядковый номер элемента, который необходимо удалить.
     * @return false - если удаление элемента произвести невозможно; true - если удаление завершено успешно.
     */
    public boolean delete(int index){
        // добавил проверку, чтобы тупой программист (я) не ввел index меньше нуля или за пределами размера контейнера
        if (index < 0 || data.length == 0 || index > data.length-1){
            return false;
        }else{
            if (index != data.length-1){
                for (int i = index; i < data.length-1; i++) {
                    data[i] = data[i+1];
                }
            }
            data = Arrays.copyOf(data, data.length-1);
            return true;
        }
    }

//    public boolean delete(T item){
//
//    }

    @Override
    public String toString() {
        return "DataContainer{" + Arrays.toString(data) + '}';
    }
}
