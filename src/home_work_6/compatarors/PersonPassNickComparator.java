package home_work_6.compatarors;

import home_work_6.dto.Person;

public class PersonPassNickComparator extends PersonPassComparator {
    @Override
    public int compareIfEqual(Person person1, Person person2) {
        return person1.getNick().compareTo(person2.getNick());
    }
}