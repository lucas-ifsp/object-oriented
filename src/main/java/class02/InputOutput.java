import java.util.Scanner;

void main() {
    Scanner scanner = new Scanner(System.in); //Only one scanner is necessary to read multiple times

    String value = scanner.nextLine(); // Reads a line from the system input - console
    System.out.println("Hello " + value); // Writes a line into the system output - console

    double doubleValue = scanner.nextDouble(); // Reads a double
    // There are similar methods for boolean, byte, short, long e float
    System.out.println("doubleValue = " + doubleValue); //The value is converted to String before printing
}