public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setAge(30)
                .setSurname("Вольф")
                .setCity("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println(mom);
        System.out.println();
        System.out.println("У " + mom.getName() + " есть сын, " + son.getName());
        System.out.println();
        mom.happyBirthday();
        System.out.println(mom);
        mom.setCity("Новосибирск");
        System.out.println("---------------");
        System.out.println(mom.getAge());

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}