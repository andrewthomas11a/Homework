package home_work_6.compatarors;

import home_work_6.dto.Person;
import java.util.Comparator;

public class PersonPassComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        // считаем, что null - больше, чем хоть какой-то Person
        if (person1 == null && person2 != null) {
            return 1;
        } else if (person1 != null && person2 == null) {
            return -1;
        } else if (person1 == null && person2 == null) {
            return 0;
        }

        int p1Len = person1.getPassword().length();
        int p2Len = person2.getPassword().length();

        if (p1Len == p2Len) {
            return compareIfEqual(person1, person2);
        }

        return p1Len - p2Len;
    }

    public int compareIfEqual(Person person1, Person person2) {
        return 0;
    }
}
