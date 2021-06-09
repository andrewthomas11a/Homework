package home_work_6.dto;

public class Animal {
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
}
