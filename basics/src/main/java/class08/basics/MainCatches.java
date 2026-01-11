import java.util.InputMismatchException;
import java.util.Scanner;

void main() {
    Scanner scanner = new Scanner(System.in);
    try {
        System.out.print("Array size: ");
        int size = scanner.nextInt();
        System.out.print("Element index: ");
        int index = scanner.nextInt();
        String [] strings = new String[size];
        strings[index] = "Ops!";
        System.out.println("strings[" + index + "] = " + strings[index]);
    } catch (InputMismatchException e) {
        System.err.println(e);
    } catch (ArrayIndexOutOfBoundsException e){
        System.err.println(e);
    }
    scanner.close();
}