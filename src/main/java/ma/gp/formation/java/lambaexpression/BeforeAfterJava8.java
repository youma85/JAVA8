package ma.gp.formation.java.lambaexpression;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BeforeAfterJava8 {
    public static void main(String[] args) {
        testAnonymeFunctionBeforeJava8();
        System.out.println("******************");
        testAnonymeFunctionAfterJava8();
    }

    private static void testAnonymeFunctionAfterJava8() {
        List<String> brands = Arrays.asList("Fiat","Skoda","Ford","Audi");
//        brands.sort((brand1, brand2) -> brand1.compareTo(brand2));
        brands.sort(String::compareTo);
        brands.stream().forEach(System.out::println);
    }

    private static void testAnonymeFunctionBeforeJava8() {
        List<String> brands = Arrays.asList("Fiat","Skoda","Ford","Audi");
        brands.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1 == null)
                    return  -1;
                if(o2 == null)
                    return 1;
                if(o1 == o2)
                    return 0;
                else
                    return o1.compareTo(o2);
            }
        });

        for (String brand: brands) {
            System.out.println(brand);
        }
    }
}
