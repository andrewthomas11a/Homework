package home_work_6.compatarors;

import home_work_6.dto.Animal;
import java.util.Comparator;

public class AnimalAgeComparator implements Comparator <Animal> {
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

        int a1Age = animal1.getAge();
        int a2Age = animal2.getAge();

        if (a1Age == a2Age) {
            return compareIfEqual(animal1, animal2);
        }

        return a1Age - a2Age;
    }

    public int compareIfEqual (Animal animal1, Animal animal2) {
        return 0;
    }
}
