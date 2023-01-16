public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String city;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (this.age == 0) {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным!");
        } else if (age == 0) {
            throw new IllegalStateException("Невозможно создать объект, отсутствует возраст");
        }
        if (name == null) {
            throw new IllegalStateException("Невозможно создать объект, отсутствует имя");
        }
        if (surname == null) {
            throw new IllegalStateException("Невозможно создать объект, отсутствует фамилия");
        }
        if (city == null) {
            throw new IllegalStateException("Невозможно создать объект, отсутствует место жительства");
        }
        return new Person(name, surname, age, city);
    }
}
