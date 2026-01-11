import java.util.Scanner;

void main() {
    Scanner s = new Scanner(System.in);
//    String input = s.nextLine();
//    System.out.println("The input number is " + (isEven(input) ? "even!" : "odd!"));
    try {
        String input = s.nextLine();
        System.out.println("The input number is " + (isEven(input) ? "even!" : "odd!"));
    }catch (Exception e){
        System.err.println(e.getMessage());
    }
    s.close();
}

public static boolean isEven(String val) {
    if(val == null) throw new NullPointerException("Input value must not be null!");
    if(!val.matches("[0-9]+")) throw new NumberFormatException("Input must be a number!"); // Regular Expression - Regex
    int num = Integer.parseInt(val);
    return num % 2 == 0;
}

