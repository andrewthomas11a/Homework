package home_work_6.compatarors;

import home_work_6.dto.Animal;

import java.util.Comparator;

public class AnimalNickComparator implements Comparator <Animal> {
    @Override
    public int compare(Animal animal1, Animal animal2) {
        // считаем, что null - больше, чем хоть какой-то Animal
        if (animal1 == null && animal2 != null) {
            return 1;
        } else if (animal1 != null && animal2 == null) {
            return -1;
        } else if (animal1 == null && animal2 == null){
            return 0;
        }

        return animal1.getNick().compareTo(animal2.getNick());
    }
}
