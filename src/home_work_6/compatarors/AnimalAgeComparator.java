package home_work_6.compatarors;

import home_work_6.dto.Animal;
import java.util.Comparator;

public class AnimalAgeComparator implements Comparator <Animal> {
    @Override
    public int compare(Animal animal1, Animal animal2) {
        if (animal1 == null || animal2 == null) {
            return nullCheck(animal1, animal2);
        }

        int a1Age = animal1.getAge();
        int a2Age = animal2.getAge();

        if (a1Age > a2Age) {
            return 1;
        } else if (a1Age < a2Age) {
            return -1;
        } else {
            return compareIfEqual(animal1, animal2);
        }
    }

    public int nullCheck (Animal animal1, Animal animal2) {
        boolean nullO1 = animal1 == null;
        boolean nullO2 = animal2 == null;

        // считаем, что null - меньше, чем хоть какой-то Person
        if (nullO1 && !nullO2) {
            return -1;
        } else if (!nullO1 && nullO2) {
            return 1;
        } else {
            return 0;
        }
    }

    public int compareIfEqual (Animal animal1, Animal animal2) {
        return 0;
    }
}
