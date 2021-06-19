package home_work_6.utils;

import home_work_6.dto.*;
import home_work_6.suppliers.GetAnimalRandom;
import home_work_6.suppliers.GetPersonRandom;

import java.util.*;

public class CollectionsRandomFill {
    // по сути этот класс уже и не особо нужен, если создавать Supplier и в методе выполнения всех действий
    // пользоваться именно Supplier'ом для заполнения коллекции.

    static GetAnimalRandom animalRandom = new GetAnimalRandom();
    static GetPersonRandom personRandom = new GetPersonRandom();

    public static void fillWithAnimal (Collection<Animal> collection, int quantity) {
        for (int i = 0; i < quantity; i++) {
            collection.add(animalRandom.get());
        }
    }

    public static void fillWithPerson (Collection<Person> collection, int quantity) {
        for (int i = 0; i < quantity; i++) {
            collection.add(personRandom.get());
        }
    }
}
