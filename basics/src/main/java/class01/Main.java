package class01;

import java.util.Scanner;

//Class name
public class Main {

    public static final int MAX_DE_ID = 1;

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        System.out.println("input = " + input);

    }

    private static void msg1() {
        boolean condition = false;
        if (condition)
            Main.msg2(); // 1.a
        else
            Main.msg3(); // 2.b
    }

    private static void msg3() {
    }

    private static void msg2() {
    }

    private static void criaUmaPamanha(boolean isDeSal, boolean temPimenta, int maria) {
        for (; maria < MAX_DE_ID; maria++) {
            final String pamonha = "Pamonha";
            System.out.println(pamonha);
        }
        System.out.println("Hello");
    }
}
