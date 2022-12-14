package ma.gp.formation.java;

public interface ICrud {
    default void add(){

    }
    default void delete(Integer id){

    };
    default void update(Integer id){

    }
    default void display() {
        System.out.println("Test");
    }
}
