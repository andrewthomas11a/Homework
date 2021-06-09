package home_work_6.compatarors;

import home_work_6.dto.Person;
import java.util.Comparator;

public class PersonPassComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        if (person1 == null || person2 == null) {
            return nullCheck(person1, person2);
        }

        int p1Len = person1.getPassword().length();
        int p2Len = person2.getPassword().length();

        if (p1Len > p2Len) {
            return 1;
        } else if (p1Len < p2Len) {
            return -1;
        } else {
            return compareIfEqual(person1, person2);
        }
    }

    public int nullCheck (Person person1, Person person2) {
        boolean nullO1 = person1 == null;
        boolean nullO2 = person2 == null;

        // считаем, что null - меньше, чем хоть какой-то Person
        if (nullO1 && !nullO2) {
            return -1;
        } else if (!nullO1 && nullO2) {
            return 1;
        } else {
            return 0;
        }
    }

    public int compareIfEqual(Person person1, Person person2) {
        return 0;
    }
}
