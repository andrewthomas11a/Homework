package home_work_6.dto;

import home_work_6.compatarors.PersonPassNickComparator;

public class Person implements Comparable<Person>{
    // предполагаем, что данные в последующем не будут меняться
    private final String nick;
    private final String password;

    // эти данные сможет поменять только разработчик
    private final int passMinLen = 5;
    private final int passMaxLen = 10;
    // не очень красиво :(
    private final String passDefault = "00000";

    public Person (String nick, String password) {
        this.nick = nick;
        if (password.length() > passMaxLen) {
            this.password = password.substring(0, passMaxLen);
        } else if (password.length() < passMinLen) {
            this.password = passDefault;
        } else {
            this.password = password;
        }
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return "{nick: \"" + this.nick + "\", password: \"" + this.password + "\"}";
    }

    // сделал для того, чтобы при заполнении TreeSet можно было не передавать в конструктор Comparator
    @Override
    public int compareTo(Person other) {
        PersonPassNickComparator c = new PersonPassNickComparator();
        return c.compare(this, other);
    }
}
