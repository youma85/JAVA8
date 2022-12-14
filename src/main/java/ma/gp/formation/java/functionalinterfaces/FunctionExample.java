package ma.gp.formation.java.functionalinterfaces;

import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {

    static Function<String, String> f1 = name -> name.toUpperCase().concat(" Java");
    static Function<String, String> f2 = name -> name.toLowerCase().concat(" Angular");
    public static void main(String[] args) {
        System.out.println("*******************");
        System.out.println("Test Apply Method");
        testApply();

        System.out.println("*******************");
        System.out.println("Test And Then");
        testAndThen();

        System.out.println("*******************");
        System.out.println("Test Compose");
        testCompose();

        System.out.println("*******************");
        System.out.println("Test Identity");
        testIdentity();

        System.out.println("*******************");
        System.out.println("Test BiFunction");
        testBiFunction();
    }

    private static void testBiFunction() {
        BiFunction<Integer, Integer, Integer> function= (x1, x2) -> x1+x2;
        Integer res= function.apply(5,6);
        System.out.println(res);

    }

    private static void testIdentity() {
        Function<String, String> i = Function.identity();
        System.out.println(i.apply("JAVA"));
    }

    private static void testCompose() {

        // test angular
        //
        System.out.println(f1.compose(f2).apply("Test"));
    }

    private static void testAndThen() {
        System.out.println(f1.andThen(f2).apply("Test"));
    }

    private static void testApply() {
        String result = f1.apply("Test ");
        System.out.println(result);
    }
}
