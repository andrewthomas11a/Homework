package home_work_6.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

// если честно - какой-то бред получился, не могу алгоритм додумать :(
// подсматривал в ArrayList и другие - надо разбираться, показалось очень сложным

public class CollectionsMySortMethod {
    public static <Z> void sort(Collection<Z> collection, Comparator<? super Z> comparator) {
        if (comparator != null){
            Z[] arr = (Z[]) (collection.toArray());
            Arrays.sort(arr, comparator);
            collection.clear();
            collection.addAll(Arrays.asList(arr));
        }
    }
}
