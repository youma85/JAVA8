package ma.gp.formation.java.collectors;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String region;
    private double salary;

    public Employee(int id, String name, int age, String region, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.region = region;
        this.salary = salary;
    }

    public static List<Employee> populateList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"Ahmed",50,"Casablanca",50000));
        employeeList.add(new Employee(2,"Fatima",18,"Casablanca",10000));
        employeeList.add(new Employee(3,"Mohammed",30,"Rabat",50000));
        employeeList.add(new Employee(4,"Hafssa",50,"Rabat",30000));
        employeeList.add(new Employee(5,"Meryem",28,"Tanger",25000));

        return employeeList;
    }

    public int getId() {
        return id;
    }

    public Employee setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Employee setAge(int age) {
        this.age = age;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public Employee setRegion(String region) {
        this.region = region;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public Employee setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", region='" + region + '\'' +
                ", salary=" + salary +
                '}';
    }
}
