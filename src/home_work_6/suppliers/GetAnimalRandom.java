package home_work_6.suppliers;

import home_work_6.dto.Animal;

import java.util.Random;
import java.util.function.Supplier;

public class GetAnimalRandom implements Supplier <Animal> {
    private static final String nickCharsRusUpper = "АБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ";
    private static final String nickCharsRusLower = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    static Random random = new Random();

    @Override
    public Animal get() {
        int age = random.nextInt(15) + 1;

        StringBuilder nick = new StringBuilder();
        // пусть nick будет от 3 до 15 символов
        nick.append(nickCharsRusUpper.charAt(random.nextInt(nickCharsRusUpper.length())));
        for (int j = 1; j < (random.nextInt(13)+3); j++) {
            nick.append(nickCharsRusLower.charAt(random.nextInt(nickCharsRusLower.length())));
        }

        return new Animal(age, nick.toString());
    }
}
