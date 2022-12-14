package ma.gp.formation.java;

import java.util.Arrays;
import java.util.List;

public class CustomerCrud implements ICrud{

    List<Customer> customers = Arrays.asList(
                new Customer(1,"Ahmed", "Benani"),
                new Customer(2,"Hafsa", "Jilali")
            );

    @Override
    public void add() {
        Customer customer= new Customer(3,"Mohamed", "Filali");
        customers.add(customer);
    }

    @Override
    public void delete(Integer id) {
        customers.remove(id);
    }

    @Override
    public void update(Integer id) {
        customers.set(id, new Customer(4, "Mohamed", "Filali") );
    }

    public void display() {
        System.out.println("Test from Customer");
    }
}
