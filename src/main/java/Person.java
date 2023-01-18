import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setAge(1)
                .setCity(city)
                .setSurname(surname);
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    public boolean hasAge() {
        return age != 0;
    }

    public OptionalInt getAge() {
        return hasAge() ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public boolean hasCity() {
        return city != null;
    }

    public String getCity() {
        return city;
    }

    public String setCity(String newCity) {
        this.city = newCity;
        return city;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return surname.equals(person.surname)
                && name.equals(person.name)
                && age == person.age
                && city.equals(person.city);
    }

    @Override
    public String toString() {
        return "Имя " + name
                + "\nФамилия " + surname
                + "\nВозраст " + age
                + "\nМесто жительства " + city;
    }
}
