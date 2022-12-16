package ma.gp.formation.java.collectors;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsExample {

    static List<Employee> employeeList = Employee.populateList();

    public static void main(String[] args) {
        testToList();
        System.out.println("************");
        testToSet();
        System.out.println("************");
        testToCollection();
        System.out.println("************");
        testToMap();
        System.out.println("************");
        testSummingInt();
        System.out.println("************");
        testAveraging();
        System.out.println("************");
        testJoining();
        System.out.println("************");
        testGroupingBy();
        System.out.println("************");
        testPartitionBy();
        System.out.println("************");
        testFilteringBy();
        System.out.println("************");
        testMaxByMinBy();
        System.out.println("************");
        testSummarizing();
    }

    private static void testSummarizing() {
        DoubleSummaryStatistics doubleSummaryStatistics=  employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(doubleSummaryStatistics);
    }

    private static void testMaxByMinBy() {
        Comparator<Employee> employeeComparator = Comparator.comparingDouble(Employee::getSalary);

        Optional<Employee> empMaxSalary =  employeeList.stream().collect(Collectors.maxBy(employeeComparator));
        if(empMaxSalary.isPresent()){
            System.out.println("Max Salary:"+empMaxSalary.get());
        }


        Optional<Employee> empMinSalary =  employeeList.stream().collect(Collectors.minBy(employeeComparator));
        if(empMinSalary.isPresent()){
            System.out.println(empMinSalary.get());
        }
    }

    private static void testFilteringBy() {
        List<Employee> filteredList= employeeList.stream()
                .collect(Collectors.filtering(employee -> employee.getAge()>30 , Collectors.toList()));

        System.out.println(filteredList);
    }

    private static void testPartitionBy() {
        Map<Boolean, List<Employee>> partitionByAge= employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge()>25));

        partitionByAge.forEach((k,v)-> {
            String key = k?"more than 25":"Less than 25";
            System.out.println(key+":"+v);
        });
    }

    private static void testGroupingBy() {
        Map<String, List<Employee>> groupByRegion = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getRegion));

        groupByRegion.forEach((k,v)-> System.out.println(k+":"+v));
    }

    private static void testJoining() {
        String names= employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining());
        System.out.println(names);

        String names2= employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(names2);

        String names3= employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",","[","]"));
        System.out.println(names3);
    }

    private static void testAveraging() {
        double averageOfSalary = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("average of Salary:"+ averageOfSalary);
    }

    private static void testSummingInt() {
        int sumOfAges= employeeList.stream().collect(Collectors.summingInt(Employee::getAge));
        System.out.println("Summing int of ages :"+ sumOfAges);

        double sumOfSalaries = employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("Summing of salaries:" + sumOfSalaries);
    }

    private static void testToMap() {
        Map<Integer,Employee> employeeMap = employeeList.stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity()));

        employeeMap.forEach((k,v)-> System.out.println(k+"===>"+v));
    }

    private static void testToCollection() {
        List<String> namesLinkedList = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(namesLinkedList);

        Set<String> regionTreeSet = employeeList.stream()
                .map(Employee::getRegion)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(regionTreeSet);
    }

    private static void testToSet() {
        Set<String> regionSet = employeeList.stream()
                .map(Employee::getRegion)
                .collect(Collectors.toSet());

        System.out.println(regionSet);
    }

    private static void testToList() {
        List<String> names = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println(names);
    }
}
