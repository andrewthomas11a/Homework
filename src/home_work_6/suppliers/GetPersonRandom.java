package home_work_6.suppliers;

import home_work_6.dto.Person;

import java.util.Random;
import java.util.function.Supplier;

public class GetPersonRandom implements Supplier <Person> {
    private static final String nickCharsRusUpper = "АБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ";
    private static final String nickCharsRusLower = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    static Random random = new Random();

    @Override
    public Person get() {
        StringBuilder pass = new StringBuilder();
        // символы для пароля - [32, 126] по ASCII
        for (int j = 0; j < (random.nextInt(6)+5); j++) {
            pass.append((char)(random.nextInt(91)+36));
        }

        StringBuilder nick = new StringBuilder();
        // пусть nick будет от 3 до 15 символов
        nick.append(nickCharsRusUpper.charAt(random.nextInt(nickCharsRusUpper.length())));
        for (int j = 1; j < (random.nextInt(13)+3); j++) {
            nick.append(nickCharsRusLower.charAt(random.nextInt(nickCharsRusLower.length())));
        }

        return new Person (pass.toString(), nick.toString());
    }
}
