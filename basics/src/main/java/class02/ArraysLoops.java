import java.util.Scanner;

void main() {
    String[] names = {"Hopper", "Ada", "Turing"}; // instantiation with a priori assignment

    System.out.println("Conventional for loop:");
    for (int i = 0; i < names.length; i++) {
        System.out.printf("Name [%d]: %s\t \t", i, names[i]);
    }
    System.out.println("\n\nEnhanced for loop:");
    for (String name : names) {
        System.out.print("Name: " + name + "\t\t");
    }

    int[] birthYear = new int[3]; // instantiate for a posteriori assignment
    birthYear[0] = 1906;
    birthYear[1] = 1815;
    birthYear[2] = 1912;
    System.out.println(birthYear.length);

    int count = 1;
    while (count < 11) {
        System.out.println("Count is: " + count);
        count++;
    }

    count = 1;
    do {
        System.out.println("Count is: " + count);
        count++;
    } while (count < 11);


    // Array of 1.000.000 unsorted values
    int[] values = {20, 1, 3, 5, 2938390};
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    for (int i = 0; i < values.length; i++) {
        if (values[i] == num) {
            System.out.println("Value found at index " + i);
            break; // no need to iterate until i = 999.999, so break
        }
    }

    while (true) {
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        if (number < 0) continue;

        if (number % 2 == 0) System.out.println(number + " is even.");
        else System.out.println(number + " is odd.");
    }


}