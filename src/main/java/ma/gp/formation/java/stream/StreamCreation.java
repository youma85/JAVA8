package ma.gp.formation.java.stream;

import ma.gp.formation.java.functionalinterfaces.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamCreation {

    public static void main(String[] args) {
        testCreationStreamUsingCollection();
        System.out.println("******************");
        testCreationStreamUsingSpecificValues();
        System.out.println("******************");
        testCreationStreamUsingArrays();
        System.out.println("******************");
        testCreationStreamUsingStreamBuilder();
        System.out.println("******************");
        testCreationStreamUsingStreamIterate();
        System.out.println("******************");
        testCreationStreamUsingStreamGenerate();
        System.out.println("******************");
        testCreationStreamUsingPatternAsPredicate();
    }

    private static void testCreationStreamUsingPatternAsPredicate() {
        List<String> names= Arrays.asList("Ahmed","Meryem","Mustapha","Hafsa","Amine");

        Pattern pattern = Pattern.compile("^A");
        Pattern pattern2 = Pattern.compile("a$");

        System.out.println("Names staring by A");
        names.stream().filter(pattern.asPredicate()).forEach(System.out::println);

        System.out.println("Names ending by A");
        names.stream().filter(pattern2.asPredicate()).forEach(System.out::println);


    }

    private static void testCreationStreamUsingStreamGenerate() {
        Stream.generate(new Random()::nextInt)
                .limit(5)
                .forEach(System.out::println);

    }

    private static void testCreationStreamUsingStreamIterate() {
        Stream.iterate(5, n -> n+10)
                .limit(10)
                .forEach(System.out::println);
    }

    private static void testCreationStreamUsingStreamBuilder() {
        Stream.Builder<Integer> builder = Stream.builder();

        Stream<Integer> integerStream = builder.add(5)
                .add(7)
                .add(8)
                .build();

        integerStream.forEach(System.out::println);
    }

    private static void testCreationStreamUsingArrays() {
        Person[] arrays = {
                new Person("Ahmed", "M", 30),
                new Person("Mourad", "M", 40),
                new Person("Fatima", "M", 15)
        };

        Stream<Person> personStream = Arrays.stream(arrays);
        Stream<Person> personStream1 = Stream.of(arrays);

        personStream.forEach(System.out::println);
        System.out.println("-----------------");
        personStream1.filter(p-> p.getAge()>35)
                .forEach(System.out::println);

    }

    private static void testCreationStreamUsingSpecificValues() {
        Stream<String> stringStream= Stream.of("Ahmed","Meryem","Mustapha","Hafsa","Amine");
        stringStream.filter(s -> s.startsWith("M"))
                .forEach(System.out::println);
    }

    private static void testCreationStreamUsingCollection() {
        List<String> names= Arrays.asList("Ahmed","Meryem","Mustapha","Hafsa","Amine");
        Stream<String> streamOfNames= names.stream();
        streamOfNames.forEach(System.out::println);
    }
}
