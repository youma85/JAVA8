package ma.gp.formation.java.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

class BiggerThanFive implements Predicate<Integer> {

    @Override
    public boolean test(Integer value) {
        return value>5;
    }
}

public class PredicateExamples {

    public static void main(String[] args) {
        System.out.println("*******************");
        System.out.println("Test Predicate");
        testPredicate();

        System.out.println("*******************");
        System.out.println("Test IsEqual");
        testIsEqual();

        System.out.println("*******************");
        System.out.println("Test int Predicate");
        testIntPredicate();

        System.out.println("*******************");
        System.out.println("Test Bi Predicate");
        testBiPredicate();

        System.out.println("*******************");
        System.out.println("Test Composing Predicate");
        testComposingPredicate();

        System.out.println("*******************");
        System.out.println("Test List of  Predicate");
        testListOfPredicate();

        System.out.println("*******************");
        System.out.println("Test Negate");
        testNegatePredicate();
    }

    private static void testNegatePredicate() {
        int[] values = {2,6,5,9,10};
        IntPredicate pred= val -> val>5;
        Arrays.stream(values).filter(pred.negate()).forEach(System.out::println);
    }

    private static void testListOfPredicate() {
        List<String> names= Arrays.asList("Ahmed","Meryem","Mustapha","Hafsa","Amine");
        Predicate<String> pred1 = n-> n.startsWith("A") || n.startsWith("M");
        Predicate<String> pred2 = n-> n.endsWith("d");
        Predicate<String> pred3 = n-> n.length() == 5;

        List<Predicate<String>> predicates = List.of(pred1, pred2, pred3);
        Stream<String> result = names.stream().filter(predicates.stream().reduce(x-> true, Predicate::and));
        result.forEach(System.out::println);

    }

    private static void testComposingPredicate() {
        IntPredicate p1 = val -> val > 3;
        IntPredicate p2 = val -> val < 8;

        int[] values = {2,6,5,9,10, 8,7,6,5};

        Arrays.stream(values).filter(p1.and(p2)).forEach(System.out::println);

        System.out.println("------------------");

        IntPredicate p3 = val -> val == 6;
        IntPredicate p4 = val -> val >= 9;

        Arrays.stream(values).filter(p3.or(p4)).forEach(System.out::println);
    }

    private static void testBiPredicate() {
        List<String> names= Arrays.asList("Ahmed","Meryem","Mustapha","Hafsa","Amine");
        BiPredicate<String, Integer> predicate = (word, length) -> word.length() == length;
        names.stream().filter(name -> predicate.test(name, 5)).forEach(System.out::println);
    }

    private static void testIntPredicate() {
        int[] values = {2,6,5,9,10};

        IntPredicate predicate = n -> n<9;
        Arrays.stream(values).filter(predicate).forEach(System.out::println);
    }

    private static void testIsEqual() {
        List<Integer> nums = Arrays.asList(2,6,3,4,8,9,4);

        Predicate<Integer> predicate = Predicate.isEqual(4);
        nums.stream().filter(predicate).forEach(System.out::println);
    }

    private static void testPredicate() {
        List<Integer> nums = Arrays.asList(2,6,3,4,8,9,14);

        BiggerThanFive btf= new BiggerThanFive();
        nums.stream().filter(btf).forEach(val -> System.out.println(val));
        System.out.println("-----------------------");
        Predicate<Integer> btf2= value -> value>5;
        nums.stream().filter(btf2).forEach(System.out::println);
    }

}
