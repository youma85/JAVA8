package ma.gp.formation.java.lambaexpression;

import ma.gp.formation.java.functionalinterfaces.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class Multiplication{
    public Multiplication(int i, int j) {
        System.out.println("Values are:"+i+","+j);
        System.out.println("Multiplication:"+ (i*j));
    }
}

@FunctionalInterface
interface ApplyingInterface{
    void apply(int a, int b);
}

public class MethodReference {
    public static void main(String[] args) {
        testStaticReference();
        System.out.println("***************");
        testInstanceMEthodReference();
        System.out.println("***************");
        testArbitraryObjectReference();
        System.out.println("***************");
        testConstructorReference();
    }

    private static void testConstructorReference() {
        ApplyingInterface refConstruct = Multiplication::new;
        refConstruct.apply(10,60);
    }

    private static void testArbitraryObjectReference() {
        String[] names= {"Ahmed", "Mourad" ,"Fatima"};
        Arrays.sort(names, String::compareTo);
        for (String s: names) {
            System.out.println(s);
        }


    }

    private static void testInstanceMEthodReference() {
        MethodReference methodReference= new MethodReference();
        List<Person> personList = Arrays.asList(
                new Person("Ahmed", "M", 30),
                new Person("Mourad", "M", 40),
                new Person("Fatima", "M", 15)
        );

//        personList.sort((a,b)-> methodReference.compareByAge(a,b));
        personList.sort(methodReference::compareByAge);
        System.out.println(personList);

    }

    private static void testStaticReference() {
        List<Person> personList = Arrays.asList(
                new Person("Ahmed", "M", 15),
                new Person("Mourad", "M", 40)
        );

        personList
                .stream()
//                .filter(p -> Person.isMajor(p))
                .filter(Person::isMajor)
                .forEach(System.out::println);

    }

    public int compareByAge(Person a, Person b) {
        return a.getAge().compareTo(b.getAge());
    }
}
