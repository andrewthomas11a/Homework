package home_work_5;

import java.util.Arrays;

public class DataContainerTest {
    public static void main(String[] args) {
        DataContainer<String> data1 = new DataContainer<>(new String[0]);
        int index1 = data1.add("Привет");
        int index2 = data1.add("Как дела");
        int index3 = data1.add("Работаю");
        int index4 = data1.add(null);

        System.out.println(data1.toString());
        System.out.println(""+ index1 + " " + index2 + " " + index3 + " " + index4);
        System.out.println(data1.delete(5));
        System.out.println(data1.toString());
        System.out.println(data1.delete(2));
        System.out.println(data1.toString());
        System.out.println(data1.delete(2));
        System.out.println(data1.toString());


    }
}
