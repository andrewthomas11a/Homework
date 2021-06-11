package home_work_6.utils;

import home_work_6.dto.*;

import java.util.*;

public class CollectionsRandomFill {
    private static final String nickCharsRusUpper = "АБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ";
    private static final String nickCharsRusLower = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    static Random random = new Random();

    public static void fillWithAnimal (Collection<Animal> collection, int quantity) {
        for (int i = 0; i < quantity; i++) {
            int age = random.nextInt(15) + 1;
            collection.add(new Animal(age, nickRandom()));
        }
    }

    public static void fillWithPerson (Collection<Person> collection, int quantity) {
        for (int i = 0; i < quantity; i++) {
            StringBuilder pass = new StringBuilder();
            // символы для пароля - [32, 126] по ASCII
            for (int j = 0; j < (random.nextInt(6)+5); j++) {
                pass.append((char)(random.nextInt(91)+36));
            }
            collection.add(new Person(nickRandom(), pass.toString()));
        }
    }

    public static String nickRandom() {
        StringBuilder nick = new StringBuilder();
        // пусть nick будет от 3 до 15 символов
        nick.append(nickCharsRusUpper.charAt(random.nextInt(nickCharsRusUpper.length())));
        for (int j = 1; j < (random.nextInt(13)+3); j++) {
            nick.append(nickCharsRusLower.charAt(random.nextInt(nickCharsRusLower.length())));
        }
        return nick.toString();
    }
}
