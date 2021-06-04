package home_work_5;

import java.util.Comparator;

// сделан чисто для понимания способа создания и использования

public class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        // проверка на null
        boolean nullO1 = o1 == null;
        boolean nullO2 = o2 == null;

        // выбираем такой "порядок" сортировки, если хотим, чтобы null был в конце массива
        if (nullO1 && !nullO2){
            return 1;
        }

        if (!nullO1 && nullO2){
            return -1;
        }

        if (nullO1 && nullO2){
            return 0;
        }

        // писать свой compareTo не нужно, т.к. в классе String он уже есть - класс String имплементит Comparable
        return o1.compareTo(o2);
    }


}
