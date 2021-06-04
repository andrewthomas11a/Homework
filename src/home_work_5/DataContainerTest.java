package home_work_5;

import java.util.Arrays;

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

        StringComparator comparator = new StringComparator();
        data1.sort(comparator);
        System.out.println(data1.toString());

        System.out.println(data1.delete(5));
        System.out.println(data1.toString());
        System.out.println(data1.delete(15));
        System.out.println(data1.toString());
        System.out.println(data1.delete("Как дела"));
        System.out.println(data1.toString());
        System.out.println(data1.delete(null));
        System.out.println(data1.toString());
    }
}
