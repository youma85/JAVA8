package ma.gp.formation.java.stream;

import ma.gp.formation.java.functionalinterfaces.Person;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperation {
    public static void main(String[] args) {
        testMapOperation();
        System.out.println("**********************");
        testFlatMapOperation();
        System.out.println("**********************");
        testSortedOperation();
        System.out.println("**********************");
        testPeekOperation();
        System.out.println("**********************");
        testDistinctOperation();
        System.out.println("**********************");
        testMatchingOperation();
        System.out.println("**********************");
        testFindFirstOperation();
        System.out.println("**********************");
        testFindAnyOperation();
        System.out.println("**********************");
        testSkipOperation();
        System.out.println("**********************");
        testLimitOperation();
        System.out.println("**********************");
        testCountOperation();
        System.out.println("**********************");
        testMinMaxOperation();
    }

    private static void testMinMaxOperation() {
        List<String> list = Arrays.asList("Ahmed","Mohamed","Youssef","Hafsa","Taha");
        list.stream().min(Comparator.comparing(String::length)).ifPresent(e -> System.out.println("Min: "+e));
        list.stream().max(Comparator.comparing(String::length)).ifPresent(e -> System.out.println("MAx: "+e));
    }

    private static void testCountOperation() {
        List<Integer> list = Arrays.asList(31,32,33,34,35);
        long c = list.stream().count();
        long d = list.stream().filter(e-> e%2==0).count();

        System.out.println(c);
        System.out.println(d);
    }

    private static void testLimitOperation() {
        Stream.of(10,20,30,40,50,60,70,80)
                .filter(n-> n% 20==0)
                .peek(val -> System.out.println("Peek:"+ val))
                .limit(2)
                .forEach(System.out::println);
    }

    private static void testSkipOperation() {
        Stream.of(10,20,30,40,50,60,70,80)
                .filter(n-> n% 20==0)
                .peek(val -> System.out.println("Peek:"+ val))
                .skip(2)
                .forEach(System.out::println);
    }

    private static void testFindAnyOperation() {
        List<String> names= Arrays.asList("Ahmed","Mohamed","Ahmed","Hafsa","Meryem");
        String name = names.stream().filter(e-> e.startsWith("A"))
                .findAny()
                .orElse("Unknown");
        System.out.println(name);
    }

    private static void testFindFirstOperation() {
        List<String> names= Arrays.asList("Ahmed","Mohamed","Ahmed","Hafsa","Meryem");
        String name = names.stream().filter(e-> e.startsWith("Y"))
                .findFirst()
                .orElse("Unknown");

        System.out.println(name);

        name = names.stream().filter(e-> e.endsWith("m"))
                .findFirst()
                .orElse("Unknown");
        System.out.println(name);
    }

    private static void testMatchingOperation() {
        Predicate<Person> p1 = p-> p.getName().startsWith("A") && p.getAge()<18;
        Predicate<Person> p2 = p-> p.getGender().equals("F");
        List<Person> personList = Arrays.asList(
                new Person("Ahmed", "M", 30),
                new Person("Mourad", "M", 40),
                new Person("Fatima", "F", 15)
        );

        // All Match
        System.out.println("All Match P1:"+personList.stream().allMatch(p1));
        System.out.println("All Match P2:"+personList.stream().allMatch(p2));
        // AnyMAtch
        System.out.println("Any Match P1:"+personList.stream().anyMatch(p1));
        System.out.println("Any Match P2:"+personList.stream().anyMatch(p2));
        // NoneMatch
        System.out.println("None Match P1:"+personList.stream().noneMatch(p1));
        System.out.println("None Match P2:"+personList.stream().noneMatch(p2));

    }

    private static void testDistinctOperation() {
        List<String> names= Arrays.asList("Ahmed","Meryem","Ahmed","Hafsa","Meryem");
        System.out.println(names.stream().distinct().collect(Collectors.joining(",")));
        names.stream().distinct().forEach(System.out::println);
    }

    private static void testPeekOperation() {
        List<Integer> list = Stream.of(50,51,52,53,54)
                .peek(val -> System.out.println("Before Filter:"+ val))
                .filter(n-> n%2 == 0)
                .peek(val -> System.out.println("After Filter:"+ val))
                .map(n -> n*10)
                .peek(val -> System.out.println("After map:"+ val))
                .collect(Collectors.toList());

        list.toString();
    }

    private static void testSortedOperation() {
        List<Person> personList = Arrays.asList(new Person("Ahmed", "M", 30),
                new Person("Mourad", "M", 40),
                new Person("Fatima", "F", 15));

        System.out.println("-- Natural Sorting using comparable---");
        List<Person> personList1 = personList.stream().sorted().collect(Collectors.toList());
        personList1.forEach(System.out::println);

        System.out.println("-- Sorting by Gender in reverse order");
        personList1 = personList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        personList1.forEach(System.out::println);

        System.out.println("-- Sorting by Age");
        personList1 = personList.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        personList1.forEach(System.out::println);

        System.out.println("-- Sorting by Age in reverse order ");
        personList1 = personList.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());
        personList1.forEach(System.out::println);
    }

    private static void testFlatMapOperation() {
        List<List<Integer>> listOfLists = Arrays.asList(
           Arrays.asList(5,9,40),
           Arrays.asList(3,10,2)
        ) ;

        listOfLists.stream().flatMap(Collection::stream)
                .map(n -> n/2)
                .forEach(System.out::println);
    }

    private static void testMapOperation() {
        Stream<Integer> stream= Stream.of(5,9,7,8,6,2);

        stream.map(n -> n*5)
                .forEach(System.out::println);
    }
}
