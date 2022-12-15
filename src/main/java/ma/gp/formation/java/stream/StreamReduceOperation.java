package ma.gp.formation.java.stream;

import java.util.Arrays;
import java.util.List;

public class StreamReduceOperation {
    static int[] array=  { 23,25,29,56,88};
    public static void main(String[] args) {
        testReduceWitAccumulator();
        testReduceWitIdentityAndAccumulator();
        testReduceListIntoString();
    }

    private static void testReduceListIntoString() {
        List<String> list = Arrays.asList("Ahmed","Mohamed","Youssef","Hafsa","Taha");
        list.stream().reduce((x,y) -> x+"==>"+y)
                .ifPresent(s-> System.out.println(" List into String: "+s));

        String[] array= {"Ahmed","Mohamed","Youssef","Hafsa","Taha"};
        Arrays.stream(array).reduce((x,y) -> x+"::"+y)
                .ifPresent(s-> System.out.println(" Array into String: "+s));
    }

    private static void testReduceWitIdentityAndAccumulator() {
        int sum= Arrays.stream(array).reduce(100, (x,y)-> x+y);
        System.out.println(sum);

        sum = Arrays.stream(array).reduce(50, Integer::sum);
        System.out.println(sum);
    }

    private static void testReduceWitAccumulator() {
        Arrays.stream(array).reduce((x,y)-> x+y).ifPresent(System.out::println);

    }
}
