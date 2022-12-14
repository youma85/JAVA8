package ma.gp.formation.java.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ConsumerExample {

    public static void main(String[] args) {
        System.out.println("*******************");
        System.out.println("Test Accept Method");
        testConsumer();
        System.out.println("*******************");
        System.out.println("Test AndThen Method");
        testAndThen();
        System.out.println("*******************");
        System.out.println("Test consumer with object");
        testConsumerWithObject();
        System.out.println("*******************");
        System.out.println("Test BiConsumer");
        testBiConsumer();
        System.out.println("*******************");
        System.out.println("Test int Consumer");
        testIntConsumer();
        System.out.println("*******************");
        System.out.println("Test BiConsumer with foreach conditional");
        testBiConsumerConditional();
    }

    private static void testBiConsumerConditional() {
        List<Integer> list1 = Arrays.asList(20,40,60);
        List<Integer> list2 = Arrays.asList(20,40,5);

        BiConsumer<List<Integer>,List<Integer>> consumer = (l1, l2) ->{
            if(l1.size() == l2.size()) {
                System.out.println("List size is Equal");
            } else {
                System.out.println("List size is Not Equal");
            }
        };

        consumer.accept(list1,list2);
    }

    private static void testIntConsumer() {
        Consumer<Integer> print = x -> System.out.println(x*100);
        print.accept(9);

        IntConsumer printInt =  x -> System.out.println(x*50);
        printInt.accept(6);
    }

    private static void testBiConsumer() {
        BiConsumer<Integer,Integer> add = (x,y) -> System.out.println(x+y);
        add.accept(5,6);
    }

    public static void testConsumerWithObject() {
        Consumer<Person> consumer1 = p -> System.out.println(p);
        Consumer<Person> consumer2 = p -> System.out.println(p.getName().toUpperCase());
        Consumer<Person> consumer3 = p -> System.out.println(p.getAge());

        Person p =new Person("Ahmed", "M", 20);
//        consumer1.accept(p);
//        consumer2.accept(p);
//        consumer3.accept(p);

        consumer1.andThen(consumer2).andThen(consumer3).accept(p);
        System.out.println("***************************");
        List<Person> personList = Arrays.asList(
                new Person("Ahmed", "M", 20),
                new Person("Mourad", "M", 40)
        );

        personList.forEach(consumer2.andThen(consumer3));
    }

    public static void testConsumer(){
        Consumer<String> showTwoTimes = value -> {
            System.out.println(value);
            System.out.println(value);
        };

        showTwoTimes.accept("JAVA");
        showTwoTimes.accept("Angular");
    }

    public static void testAndThen() {
        List<Integer> values = Arrays.asList(2,4,6);

        Consumer<List<Integer>> addTen = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, 10 + list.get(i));
            }
        };

        Consumer<List<Integer>> showList = list -> {
            list.forEach(val -> System.out.println(val));
        };

        addTen.andThen(showList).accept(values);
    }
}
