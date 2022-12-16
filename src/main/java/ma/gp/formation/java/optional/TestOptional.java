package ma.gp.formation.java.optional;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestOptional {

    public static void main(String[] args) {
        testEmptyAndOfMethods();
        System.out.println("**************");
        testIsPresent();
        System.out.println("**************");
        testCreationOptional();
        System.out.println("**************");
        testIfPresent();
        System.out.println("**************");
        testOrElse();
        System.out.println("**************");
        testOrElseGet();
        System.out.println("**************");
        comparingElseAndElseGet();

        System.out.println("**************");
        testOrElseThrow();
        System.out.println("**************");
        testFilter();
        System.out.println("**************");
        testMap();
    }

    private static void testMap() {
        Optional<String> op = Optional.ofNullable("Hello World").map(value -> {
            if(value.contains("Hello")) {
                return "New Developer";
            } else {
                return "Senior";
            }
        });

        op.ifPresent(System.out::println);
    }

    private static void testFilter() {
        Optional<Integer> optional = Optional.ofNullable(123456).filter(number -> number % 2 ==0);

        if(optional.isEmpty()){
            System.out.println("Odd number");
        } else {
            System.out.println("Even number");
        }
    }

    private static void testOrElseThrow() {
        String test = Optional.ofNullable("").orElseThrow();
        System.out.println(test);

        String val=null;
        //String test2 = Optional.ofNullable(val).orElseThrow();
       // System.out.println(test2);
    }

    private static void comparingElseAndElseGet() {
        Optional<String> optional1 = Optional.ofNullable(null);
        String val1 = optional1.orElse(getDefaultValue());
        System.out.println("orElse without value:"+ val1);

        Optional<String> optional2 = Optional.ofNullable(null);
        String val2 = optional2.orElseGet(()->getDefaultValue());
        System.out.println("orElseGet without value:"+ val2);

        System.out.println("*************************************");
        Optional<String> optional3 = Optional.ofNullable("value");
        String val3 = optional3.orElse(getDefaultValue());
        System.out.println("orElse with value:"+ val3);

        Optional<String> optional4 = Optional.ofNullable("value");
        String val4 = optional4.orElseGet(()->getDefaultValue());
        System.out.println("orElseGet with value:"+ val4);
    }

    static String getDefaultValue(){
        System.out.println("getDefaultValue executed");
        return "Default value using method";
    }

    private static void testOrElseGet() {
        Optional<String> o1 = Optional.ofNullable(null);
        String value = o1.orElseGet(() -> "Default Value");

        System.out.println(value);

        Optional<Integer> o2 = Optional.empty();
        int valueInt = o2.orElseGet(()->100);

        System.out.println(valueInt);
    }

    private static void testOrElse() {
        Optional<String> o1 = Optional.ofNullable(null);
        String value = o1.orElse("Default Value");

        System.out.println(value);

        Optional<Integer> o2 = Optional.empty();
        int valueInt = o2.orElse(100);

        System.out.println(valueInt);
    }

    private static void testIfPresent() {
        Optional<String> optional = Optional.of("hello world");
        optional.ifPresent(value -> {
            System.out.println("The value is present: "+value);
        });

        List<Integer> list = Arrays.asList(10,20,30,40,50);
        Optional<List<Integer>> integerListOptional = Optional.ofNullable(list);

        integerListOptional.ifPresent(integers -> integers.forEach(System.out::println));

    }

    private static void testCreationOptional() {
        Optional<Void> emptyOptional= Optional.empty();
        System.out.println("Is Empty:" + emptyOptional.isEmpty());

        Optional<String> hello = Optional.of("Hello");
        if(hello.isPresent()){
            String value = hello.get();
            System.out.println("Value is :"+ value);
        }

        Optional<Integer> integerOptional = Optional.of(1546);
        if(integerOptional.isPresent()){
            Integer value = integerOptional.get();
            System.out.println("Value is :"+ value);
        }
    }

    private static void testIsPresent() {
        Optional<String> hello = Optional.ofNullable("Hello");
        if(hello.isPresent()){
            String value = hello.get();
            System.out.println("Value is :"+ value);
        } else {
            System.out.println("There is no value");
        }
    }

    private static void testEmptyAndOfMethods() {
        Optional<String> empty = Optional.empty();
        Optional<String> hello = Optional.of("Hello");
        Optional<String> hello2 = Optional.ofNullable(null);
        //System.out.println(empty.get());
        System.out.println(hello.get());
    }
}
