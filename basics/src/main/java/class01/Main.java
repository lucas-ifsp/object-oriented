package class01;

//Class name
public class Main {

    public static final String HELLO_CONSTANT = "Hello";

    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            System.out.println("j = " + j);
        }
        System.out.println(HELLO_CONSTANT);

        doSomething();
    }

    private static void doSomething() {
        final String world = "World";
        System.out.println(HELLO_CONSTANT);
        System.out.println(world);
    }
}
