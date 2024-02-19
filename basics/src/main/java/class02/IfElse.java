import java.util.Scanner;

void main() {
    Scanner scanner = new Scanner(System.in);
    boolean input = scanner.nextBoolean();
    if (input) {
        System.out.println("The input value is equal to true.");
    } else {
        System.out.println("The input value is equal to false.");
    }

    int value = scanner.nextInt();
    if (value > 0)
        System.out.println("The value is positive.");
    else if (value < 0)
        System.out.println("The value is negative.");
    else
        System.out.println("The value is zero.");

    System.out.print("How many items do you want? "); // print command does not start a new line
    int items = scanner.nextInt();
    System.out.println("Now you have " + items + (items == 1 ? " item." : " items."));

}