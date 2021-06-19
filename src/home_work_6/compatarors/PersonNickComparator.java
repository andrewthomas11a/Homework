package home_work_6.compatarors;

import home_work_6.dto.Person;

import java.util.Comparator;

public class PersonNickComparator implements Comparator<Person> {

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

        return person1.getNick().compareTo(person2.getNick());
    }
}
