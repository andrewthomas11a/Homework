package home_work_6.test;

import home_work_6.compatarors.*;
import home_work_6.dto.*;
import home_work_6.suppliers.GetAnimalRandom;
import home_work_6.suppliers.GetPersonRandom;
import home_work_6.utils.*;
import org.junit.jupiter.api.*;

import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CollectionsRandomFillAndSortTest {
    int quantity = 1_000_000;
    List<Animal> animalArrayList = new ArrayList<>();
    List<Animal> animalLinkedList = new LinkedList<>();
    List<Person> personArrayList = new ArrayList<>();
    List<Person> personLinkedList = new LinkedList<>();

    // HashSet определяет "уникальность" объекта по хэш-коду, не подлежит сортировке, не упорядочен
    Set<Animal> animalHashSet = new HashSet<>();
    // TreeSet сразу создается сортированным, либо путем передачи в конструктор Comparator, либо путем заполнения
    // объектами, которые имплементят Comparable, т.е. содержат метод compareTo
    Set<Animal> animalTreeSet = new TreeSet<>();
    Set<Person> personHashSet = new HashSet<>();
    Set<Person> personTreeSet = new TreeSet<>();

    @Order(1)
    @RepeatedTest(1000)
    @DisplayName("Проверяем, чтобы поля создаваемый рандомно Animal и Person не выходили за нужный диапазон значений (1000 повторений).")
    public void nickRandom() {
        GetAnimalRandom randomAnimal = new GetAnimalRandom();
        GetPersonRandom randomPerson = new GetPersonRandom();
        Person p1 = randomPerson.get();
        Animal a1 = randomAnimal.get();

        String personNick = p1.getNick();
        boolean result1 = (personNick.length() >=3 && personNick.length() <=15);
        Assertions.assertTrue(result1, "Длина рандомного nick у рандомного Person выходит за нужный диапазон.");

        String personPass = p1.getPassword();
        boolean result2 = (personPass.length() >=5 && personPass.length() <=10);
        Assertions.assertTrue(result2, "Длина рандомного password у рандомного Person выходит за нужный диапазон.");

        int animalAge = a1.getAge();
        boolean result3 = (animalAge > 0 && animalAge <= 16);
        Assertions.assertTrue(result3, "Рандомный age у рандомного Animal выходит за нужный диапазон.");

        String animalNick = p1.getNick();
        boolean result4 = (animalNick.length() >=3 && animalNick.length() <=15);
        Assertions.assertTrue(result4, "Длина рандомного nick у рандомного Animal выходит за нужный диапазон.");
    }

    @Order(2)
    @Test
    @DisplayName("Проверяем, работает ли заполнение коллекции ArrayList объектами Animal и Person в нужном количестве.")
    public void fillArrayList() {
        CollectionsRandomFill.fillWithAnimal(animalArrayList, quantity);
        Assertions.assertEquals(animalArrayList.size(), quantity);

        CollectionsRandomFill.fillWithPerson(personArrayList, quantity);
        Assertions.assertEquals(personArrayList.size(), quantity);
    }

    @Order(3)
    @Test
    @DisplayName("Проверяем, работает ли заполнение коллекции LinkedList объектами Animal и Person в нужном количестве.")
    public void fillLinkedList() {
        CollectionsRandomFill.fillWithAnimal(animalLinkedList, quantity);
        Assertions.assertEquals(animalLinkedList.size(), quantity);

        CollectionsRandomFill.fillWithPerson(personLinkedList, quantity);
        Assertions.assertEquals(personLinkedList.size(), quantity);
    }

    @Order(4)
    @Test
    @DisplayName("Проверяем, работает ли заполнение коллекции HashSet объектами Animal и Person (итоговое количество элементов неизвестно).")
    public void fillHashSet() {
        CollectionsRandomFill.fillWithAnimal(animalHashSet, quantity);
        boolean result1 = (animalHashSet.size() >= quantity/2 && animalHashSet.size() <= quantity);
        Assertions.assertTrue(result1, "Заполнилось менее половины коллекции HashSet!");

        CollectionsRandomFill.fillWithPerson(personHashSet, quantity);
        boolean result2 = (personHashSet.size() >= quantity/2 && personHashSet.size() <= quantity);
        Assertions.assertTrue(result2, "Заполнилось менее половины коллекции HashSet!");
    }

    @Order(5)
    @Test
    @DisplayName("Проверяем, работает ли заполнение коллекции TreeSet объектами Animal и Person (итоговое количествоо элементов неизвестно).")
    public void fillWithAnimalTreeSet() {
        CollectionsRandomFill.fillWithAnimal(animalTreeSet, quantity);
        boolean result1 = (animalTreeSet.size() >= quantity/2 && animalTreeSet.size() <= quantity);
        Assertions.assertTrue(result1, "Заполнилось менее половины коллекции TreeSet!");

        CollectionsRandomFill.fillWithPerson(personTreeSet, quantity);
        boolean result2 = (personTreeSet.size() >= quantity/2 && personTreeSet.size() <= quantity);
        Assertions.assertTrue(result2, "Заполнилось менее половины коллекции TreeSet!");
    }

    @Order(6)
    @Test
    @DisplayName("Сортируем коллекцию ArrayList c Animal при помощи JDK (по возрасту) и проверяем правильность работы.")
    public void sortArrayList1() {
        CollectionsRandomFill.fillWithAnimal(animalArrayList, quantity);
        animalArrayList.sort(new AnimalAgeComparator());
        boolean result = true;
        for (int i = 0; i < animalArrayList.size()-1; i++) {
            int a = animalArrayList.get(i).getAge();
            int b = animalArrayList.get(i+1).getAge();
            if (a > b) {
                result = false;
                break;
            }
        }
        Assertions.assertTrue(result, "Сортировка не удалась!");
    }

    @Order(7)
    @Test
    @DisplayName("Сортируем коллекцию ArrayList c Animal при помощи JDK (по возрасту и нику) и проверяем правильность работы.")
    public void sortArrayList2() {
        CollectionsRandomFill.fillWithAnimal(animalArrayList, quantity);
        animalArrayList.sort(new AnimalAgeNickComparator());
        // Comparator можно заменить на:
//        animalArrayList.sort(new AnimalAgeComparator().thenComparing(new AnimalNickComparator()));
        boolean result = true;
        for (int i = 0; i < animalArrayList.size()-1; i++) {
            int a = animalArrayList.get(i).getAge();
            int b = animalArrayList.get(i+1).getAge();
            if (a > b) {
                result = false;
                break;
            }
            if (a == b && (animalArrayList.get(i).getNick().compareTo(animalArrayList.get(i+1).getNick()) > 0)) {
                    result = false;
                    break;
            }
        }
        Assertions.assertTrue(result, "Сортировка не удалась!");
    }

    @Order(8)
    @Test
    @DisplayName("Сортируем коллекцию ArrayList c Person при помощи JDK (по длине пароля) и проверяем правильность работы.")
    public void sortArrayList3() {
        CollectionsRandomFill.fillWithPerson(personArrayList, quantity);
        personArrayList.sort(new PersonPassComparator());
        boolean result = true;
        for (int i = 0; i < personArrayList.size()-1; i++) {
            int a = personArrayList.get(i).getPassword().length();
            int b = personArrayList.get(i+1).getPassword().length();
            if (a > b) {
                result = false;
                break;
            }
        }
        Assertions.assertTrue(result, "Сортировка не удалась!");
    }

    @Order(9)
    @Test
    @DisplayName("Сортируем коллекцию ArrayList c Person при помощи JDK и (по длине пароля и нику) и проверяем правильность работы.")
    public void sortArrayList4() {
        CollectionsRandomFill.fillWithPerson(personArrayList, quantity);
        personArrayList.sort(new PersonPassNickComparator());
        // Можно заменить на:
//        personArrayList.sort(new PersonPassComparator().thenComparing(new PersonNickComparator()));
        boolean result = true;
        for (int i = 0; i < personArrayList.size()-1; i++) {
            int a = personArrayList.get(i).getPassword().length();
            int b = personArrayList.get(i+1).getPassword().length();
            if (a > b) {
                result = false;
                break;
            }
            if (a == b) {
                if (personArrayList.get(i).getNick().compareTo(personArrayList.get(i+1).getNick()) > 0) {
                    result = false;
                    break;
                }
            }
        }
        Assertions.assertTrue(result, "Сортировка не удалась!");
    }

    @Order(10)
    @Test
    @DisplayName("Сортируем коллекцию LinkedList c Person при помощи JDK (по длине пароля и нику) и проверяем правильность работы.")
    public void sortLinkedList1() {
        CollectionsRandomFill.fillWithPerson(personLinkedList, quantity);
        personLinkedList.sort(new PersonPassNickComparator());
        // Можно заменить на:
//        personLinkedList.sort(new PersonPassComparator().thenComparing(new PersonNickComparator()));
        boolean result = true;
        Iterator<Person> itr = personLinkedList.iterator();
        for (int i = 0; i < personLinkedList.size()/2; i++) {
            Person a = itr.next();
            Person b = itr.next();
            int p1 = a.getPassword().length();
            int p2 = b.getPassword().length();
            if (p1 > p2) {
                result = false;
                break;
            }
            if (a == b) {
                if (a.getNick().compareTo(b.getNick()) > 0) {
                    result = false;
                    break;
                }
            }
        }
        Assertions.assertTrue(result, "Сортировка не удалась!");
    }

    @Order(11)
    @Test
    @DisplayName("Сортируем коллекцию ArrayList c Person (по длине пароля) и своего метода сортировки.")
    public void sortNotJDKArrayList() {
        CollectionsRandomFill.fillWithPerson(personArrayList, quantity);
        CollectionsMySortMethod.sort(personArrayList, new PersonPassNickComparator());
        // Можно заменить на:
//        CollectionsMySortMethod.sort(personArrayList, new PersonPassComparator().thenComparing(new PersonNickComparator()));
        boolean result = true;
        for (int i = 0; i < personArrayList.size()-1; i++) {
            int a = personArrayList.get(i).getPassword().length();
            int b = personArrayList.get(i+1).getPassword().length();
            if (a > b) {
                result = false;
                break;
            }
            if (a == b) {
                if (personArrayList.get(i).getNick().compareTo(personArrayList.get(i+1).getNick()) > 0) {
                    result = false;
                    break;
                }
            }
        }
        Assertions.assertTrue(result, "Сортировка не удалась!");
    }
}
