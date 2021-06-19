package home_work_6.compatarors;

import home_work_6.dto.Animal;

public class AnimalAgeNickComparator extends AnimalAgeComparator {
    @Override
    public int compareIfEqual(Animal animal1, Animal animal2) {
        return animal1.getNick().compareTo(animal2.getNick());
    }
}
