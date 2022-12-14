package ma.gp.formation.java.functionalinterfaces;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperatorsExample {
    public static void main(String[] args) {
        System.out.println("*******************");
        System.out.println("Test unaryOperator");
        testUnaryOperator();

        System.out.println("*******************");
        System.out.println("Test binary operator");
        testBinaryOperator();

        System.out.println("*******************");
        System.out.println("Test maxBy binary operator");
        testMaxByBinaryOperator();

        System.out.println("*******************");
        System.out.println("Test minBy binary operator");
        testMinByBinaryOperator();
    }

    private static void testMinByBinaryOperator() {
        BinaryOperator<Person> binaryOperator = BinaryOperator.minBy(Comparator.comparingInt(Person::getAge));

        Person p1=new Person("Ahmed", "M", 20);
        Person p2=new Person("Mourad", "M", 40);

        Person younger= binaryOperator.apply(p1, p2);
        System.out.println(younger);

    }

    private static void testMaxByBinaryOperator() {
        BinaryOperator<Integer> bo1 = BinaryOperator.maxBy((a,b) -> (a>b) ? 1:(a==b)?0:-1);
        System.out.println(bo1.apply(100,90));
    }

    private static void testBinaryOperator() {
        BinaryOperator<Integer> ope= (x1,x2) -> x1+x2;
        Integer res = ope.apply(5,10);
        System.out.println(res);

        BiFunction<Integer,Integer, Integer> function= (x1, x2) -> x1+x2;
        Integer res2 = function.apply(5,10);
        System.out.println(res2);
    }

    private static void testUnaryOperator() {
        UnaryOperator<String> uo1 = name -> name.toUpperCase();
        UnaryOperator<Integer> uo2 = x -> x+10;

        System.out.println(uo1.apply("java8"));
        System.out.println(uo2.apply(20));
    }
}
