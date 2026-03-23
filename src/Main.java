import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

        // Filter out even numbers and print them
        System.out.println("Even numbers:");
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .forEach(System.out::println);

        // Map the list of numbers to their squares and print the squared values
        System.out.println("Squared values:");
        numbers.stream()
               .map(n -> n * n)
               .forEach(System.out::println);

        // Filter out odd numbers and map them to their cubes
        System.out.println("Odd numbers cubed:");
        numbers.stream()
               .filter(n -> n % 2 != 0)
               .map(n -> n * n * n)
               .forEach(System.out::println);

        // Use reduce to sum all the numbers in the list
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);
        System.out.println("Sum of all numbers: " + sum);

        // Use collect to gather all even numbers into a new list
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());
        System.out.println("Collected even numbers: " + evenNumbers);

        // Flatten a list of lists into a single list
        List<List<Integer>> listOfLists = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(6, 7, 8, 9)
        );
        List<Integer> flattenedList = listOfLists.stream()
                                                 .flatMap(List::stream)
                                                 .collect(Collectors.toList());
        System.out.println("Flattened list: " + flattenedList);

        // Group numbers by even and odd
        Map<String, List<Integer>> groupedByEvenOdd = numbers.stream()
                                                             .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));
        System.out.println("Grouped by even and odd: " + groupedByEvenOdd);

        // Create a list of Person objects
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 20),
            new Person("Charlie", 25),
            new Person("Diana", 35)
        );

        // Filter out people older than 25 and print their names
        System.out.println("People older than 25:");
        people.stream()
              .filter(person -> person.getAge() > 25)
              .map(Person::getName)
              .forEach(System.out::println);

        // Find the oldest person in the list
        Person oldestPerson = people.stream()
                                    .max(Comparator.comparingInt(Person::getAge))
                                    .orElse(null);
        System.out.println("Oldest person: " + (oldestPerson != null ? oldestPerson.getName() : "None"));
    }
}