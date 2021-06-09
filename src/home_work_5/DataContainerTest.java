package home_work_5;

import java.util.Arrays;
import java.util.Iterator;

public class DataContainerTest {

    public static void main(String[] args) {
        DataContainer<String> data1 = new DataContainer<>(new String[3]);
        int index1 = data1.add("Привет");
        int index2 = data1.add("Как дела");
        int index3 = data1.add("Где Вася?");
        int index4 = data1.add(null);

        System.out.println(data1.toString());
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
        System.out.println(index4);

        data1.sort(new StringComparator());
        System.out.println(data1.toString());

        // работа со статическими методами
        DataContainer.sort(data1);
        DataContainer.sort(data1, new StringComparator());

        Iterator<String> it = data1.iterator();
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());

//        Iterator<String> it2 = data1.iterator();
//        while(it2.hasNext()){
//            System.out.print(it2.next() + " ");
//        }
//        System.out.println();

//        System.out.println(data1.delete(5));
//        System.out.println(data1.toString());
//        System.out.println(data1.delete(15));
//        System.out.println(data1.toString());
//        System.out.println(data1.delete("Как дела"));
//        System.out.println(data1.toString());
//        System.out.println(data1.delete(null));
//        System.out.println(data1.toString());

    }
}
