package home_work_6.test;

import home_work_6.compatarors.*;
import home_work_6.dto.*;
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

    // HashSet определяет "уникальность" объекта по хэш-коду, не подлежит сортировке
    Set<Animal> animalHashSet = new HashSet<>();
    // TreeSet сразу создается сортированным, либо путем передачи в конструктор Comparator, либо путем заполнения
    // объектами, которые имплементят Comparable, т.е. содержат метод compareTo
    Set<Animal> animalTreeSet = new TreeSet<>();
    Set<Person> personHashSet = new HashSet<>();
    Set<Person> personTreeSet = new TreeSet<>();

    @Order(1)
    @RepeatedTest(1000)
    @DisplayName("Проверяем, чтобы создаваемый рандомный ник был от 3 до 15 символов.")
    public void nickRandom() {
        String nick = CollectionsRandomFill.nickRandom();
        boolean result = (nick.length() >=3 && nick.length() <=15);
        Assertions.assertTrue(result, "Длина рандомного nick выходит за нужный диапазон.");
    }

    @Order(2)
    @Test
    @DisplayName("Проверяем, работает ли заполнение коллекции ArrayList объектами Animal в нужном количестве.")
    public void fillWithAnimalArrayList() {
        CollectionsRandomFill.fillWithAnimal(animalArrayList, quantity);
        Assertions.assertEquals(animalArrayList.size(), quantity);
    }

    @Order(3)
    @Test
    @DisplayName("Проверяем, работает ли заполнение коллекции LinkedList объектами Animal в нужном количестве.")
    public void fillWithAnimalLinkedList() {
        CollectionsRandomFill.fillWithAnimal(animalLinkedList, quantity);
        Assertions.assertEquals(animalLinkedList.size(), quantity);
    }

    @Order(4)
    @Test
    @DisplayName("Проверяем, работает ли заполнение коллекции ArrayList объектами Person в нужном количестве.")
    public void fillWithPersonArrayList() {
        CollectionsRandomFill.fillWithPerson(personArrayList, quantity);
        Assertions.assertEquals(personArrayList.size(), quantity);
    }

    @Order(5)
    @Test
    @DisplayName("Проверяем, работает ли заполнение коллекции LinkedList объектами Person в нужном количестве.")
    public void fillWithPersonLinkedList() {
        CollectionsRandomFill.fillWithPerson(personLinkedList, quantity);
        Assertions.assertEquals(personLinkedList.size(), quantity);
    }

    @Order(6)
    @Test
    @DisplayName("Проверяем, работает ли заполнение коллекции HashSet объектами Animal (итоговое количество элементов неизвестно).")
    public void fillWithAnimalHashSet() {
        CollectionsRandomFill.fillWithAnimal(animalHashSet, quantity);
        boolean result = (animalHashSet.size() >= quantity/2 && animalHashSet.size() <= quantity);
        Assertions.assertTrue(result, "Заполнилось менее половины коллекции HashSet!");
    }

    @Order(7)
    @Test
    @DisplayName("Проверяем, работает ли заполнение коллекции TreeSet объектами Animal (итоговое количествоо элементов неизвестно).")
    public void fillWithAnimalTreeSet() {
        CollectionsRandomFill.fillWithAnimal(animalTreeSet, quantity);
        boolean result = (animalTreeSet.size() >= quantity/2 && animalTreeSet.size() <= quantity);
        Assertions.assertTrue(result, "Заполнилось менее половины коллекции TreeSet!");
    }

    @Order(8)
    @Test
    @DisplayName("Проверяем, работает ли заполнение коллекции HashSet объектами Person (итоговое количество элементов неизвестно).")
    public void fillWithPersonHashSet() {
        CollectionsRandomFill.fillWithPerson(personHashSet, quantity);
        boolean result = (personHashSet.size() >= quantity/2 && personHashSet.size() <= quantity);
        Assertions.assertTrue(result, "Заполнилось менее половины коллекции HashSet!");
    }

    @Order(9)
    @Test
    @DisplayName("Проверяем, работает ли заполнение коллекции TreeSet объектами Person (итоговое количествоо элементов неизвестно).")
    public void fillWithPersonTreeSet() {
        CollectionsRandomFill.fillWithPerson(personTreeSet, quantity);
        boolean result = (personTreeSet.size() >= quantity/2 && personTreeSet.size() <= quantity);
        Assertions.assertTrue(result, "Заполнилось менее половины коллекции TreeSet!");
    }

    @Order(10)
    @Test
    @DisplayName("Сортируем коллекцию ArrayList c Animal при помощи JDK и AnimalAgeComparator и проверяем правильность работы.")
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

    @Order(11)
    @Test
    @DisplayName("Сортируем коллекцию ArrayList c Animal при помощи JDK и AnimalAgeNickComparator и проверяем правильность работы.")
    public void sortArrayList2() {
        CollectionsRandomFill.fillWithAnimal(animalArrayList, quantity);
        animalArrayList.sort(new AnimalAgeNickComparator());
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

    @Order(12)
    @Test
    @DisplayName("Сортируем коллекцию ArrayList c Person при помощи JDK и PersonPassComparator и проверяем правильность работы.")
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

    @Order(13)
    @Test
    @DisplayName("Сортируем коллекцию ArrayList c Person при помощи JDK и PersonPassNickComparator и проверяем правильность работы.")
    public void sortArrayList4() {
        CollectionsRandomFill.fillWithPerson(personArrayList, quantity);
        personArrayList.sort(new PersonPassNickComparator());
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

    @Order(14)
    @Test
    @DisplayName("Сортируем коллекцию LinkedList c Person при помощи JDK и PersonPassComparator и проверяем правильность работы.")
    public void sortLinkedList1() {
        CollectionsRandomFill.fillWithPerson(personLinkedList, quantity);
        personLinkedList.sort(new PersonPassNickComparator());
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

    @Order(15)
    @Test
    @DisplayName("Сортируем коллекцию ArrayList c Person при помощи PersonPassComparator и своего метода сортировки.")
    public void sortNotJDKArrayList() {
        CollectionsRandomFill.fillWithPerson(personArrayList, quantity);
        CollectionsMySortMethod.sort(personArrayList, new PersonPassNickComparator());
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
