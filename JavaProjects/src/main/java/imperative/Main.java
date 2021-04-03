package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Satheesh",Gender.FEMALE),
                new Person("Kannan", Gender.MALE),
                new Person("Priya", Gender.FEMALE),
                new Person("Durga", Gender.FEMALE),
                new Person("Santhosh", Gender.MALE)
        );

        //Imperative approach
        List<Person>  females = new ArrayList<>();
        for (Person person : persons) {
            if (Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        System.out.println(females);

        //Declarative approach
        List<Person> femalesList = persons.stream().filter(person -> Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList());

        femalesList.forEach(System.out::println);


    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE,FEMALE
    }
}
