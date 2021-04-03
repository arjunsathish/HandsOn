package streams;

import imperative.Main;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _Stream {

    public static void main(String[] args) {

        List<Person> persons = List.of(
                new Person("Satheesh", Gender.FEMALE),
                new Person("Kannan", Gender.MALE),
                new Person("Priya", Gender.FEMALE),
                new Person("Durga", Gender.FEMALE),
                new Person("Santhosh", Gender.MALE)
        );


        persons.stream().map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        persons.stream().map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        persons.stream().map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = x -> System.out.println(x);

        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
        boolean containsOnlyFemales = persons.stream().anyMatch(personPredicate);
        System.out.println(containsOnlyFemales);


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
        MALE, FEMALE
    }
}
