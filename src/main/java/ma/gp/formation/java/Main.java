package ma.gp.formation.java;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CustomerCrud crud =new CustomerCrud();
        crud.display();

        ICrud crud2= new ICrud() {};
//        crud2.update();
    }
}
