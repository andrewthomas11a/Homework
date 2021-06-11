package home_work_6.dto;

import home_work_6.compatarors.AnimalAgeNickComparator;

public class Animal implements Comparable<Animal>{
    // предполагаем, что данные в последующем не будут меняться
    private final int age;
    private final String nick;

    // эти данные сможет поменять только разработчик
    private final int ageMin = 1;
    private final int ageMax = 15;

    public Animal (int age, String nick) {
        if (age > ageMax) {
            this.age = ageMax;
        } else if (age < ageMin) {
            this.age = ageMin;
        } else {
            this.age = age;
        }
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "{age: " + this.age + ", nick: \"" + this.nick + "\"}";
    }

    // сделал для того, чтобы при заполнении TreeSet можно было не передавать в конструктор Comparator
    @Override
    public int compareTo(Animal other) {
        AnimalAgeNickComparator c = new AnimalAgeNickComparator();
        return c.compare(this, other);
    }
}
