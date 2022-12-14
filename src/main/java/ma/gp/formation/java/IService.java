package ma.gp.formation.java;

import java.util.function.Consumer;

public interface IService {
    static void display(){
        System.out.println("HEllo World");
    }
}

class StaticTest implements IService{
    static void display(){
        System.out.println("Test");
    }
}

class StaticChild extends StaticTest{
    public static void main(String[] args) {
        StaticTest.display();
        StaticChild.display();
    }
}