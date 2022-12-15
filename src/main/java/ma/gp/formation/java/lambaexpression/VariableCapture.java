package ma.gp.formation.java.lambaexpression;

public class VariableCapture {
    private String instanceVariable = "Hey";
    static String staticVariable = "Hey static var";
    public static void main(String[] args) {
        testLocalVariable();
        System.out.println("************");
        testInstanceVariable();
        System.out.println("************");
        testStaticVariable();
    }

    private static void testStaticVariable() {
        MyInterface myInterface = (text) ->{
            System.out.println(text);
            System.out.println(staticVariable);
        };

        myInterface.print("Angular");
    }

    private static void testInstanceVariable() {
        VariableCapture object = new VariableCapture();

        object.printIt("Java");
    }

    public void printIt(String value) {
        MyInterface myInterface = (text) ->{
            System.out.println(text);
            System.out.println(instanceVariable);
        };
        myInterface.print(value);
        instanceVariable ="test";
        myInterface.print(value);
    }

    private static void testLocalVariable() {
        String localText=" Hello ";
        MyInterface myInterface = (text) ->{
            System.out.println(text);
            System.out.println(localText);
        };
        myInterface.print("Java");
    }
}

@FunctionalInterface
interface MyInterface {
    void print(String text);
}
