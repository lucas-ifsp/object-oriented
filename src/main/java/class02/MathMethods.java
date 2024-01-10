import java.util.Scanner;

void main(){
    Scanner scanner = new Scanner(System.in); //Only one scanner is necessary to read multiple times
    double value = scanner.nextDouble(); // Reads a double
    System.out.println("Absolute value: " + Math.abs(-value));
    System.out.println("Floor value: " + Math.floor(-value));
    System.out.println("Arredondado: " + Math.round(value));
    System.out.println("Min (20,7): " + Math.min(20,7) +  "\t Max (3,9): " + Math.max(3,9));
    System.out.println("Sine (Pi/2): " + Math.sin(Math.PI/2) + "\t Cosine (Pi): " + Math.cos(Math.PI));
}