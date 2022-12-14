package ma.gp.formation.java.functionalinterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        System.out.println("*******************");
        System.out.println("TestSupplier");
        testSupplier();

        System.out.println("*******************");
        System.out.println("Test Int Supplier");
        testIntSupplier();
    }

    private static void testIntSupplier() {
        IntSupplier randIntSupplier = () -> new Random().nextInt(40);
        System.out.println(randIntSupplier.getAsInt());
        System.out.println(randIntSupplier.getAsInt());
        System.out.println(randIntSupplier.getAsInt());
        System.out.println(randIntSupplier.getAsInt());
    }

    private static void testSupplier() {
        List<String> names= Arrays.asList("Ahmed","Meryem","Mustapha","Hafsa","Amine");

        List<String> upperedList = new ArrayList<>();

        for (String name: names) {
            Supplier<String > upperSupplier = name::toUpperCase;
            System.out.println(upperSupplier.get());
        }
    }
}
