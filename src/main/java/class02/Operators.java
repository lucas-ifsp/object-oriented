void main() {
    int x = 10 + 1; // Sum
    long y = x - 6; // Subtraction
    long z = x * y; // Multiplication
    float r = (float) x / y; // Division. Apply cast to promote to float and keep the decimal part.
    double w = x % r; // Module
    System.out.println("w = " + w);

    int num = 20; // Simple assignment
    num += 20; // The same as 'num = num + 20', thus, num is 40.
    num -= 10; // The same as 'num = num – 10', thus, num is 30
    num *= 2; // The same as 'num = num * 2', thus, num is 60
    num /= 6; // The same as 'num = num / 6', thus, num is 10
    num %= 3; // The same as 'num = num % 3', thus, num is 1

    System.out.println("num = " + num);

    int num1 = 1;
    int num2 = 2;
    if(num1 == num2){ System.out.println("num1 and num2 are equal"); } // True if num1 is equal to num2
    if(num1 != num2){System.out.println("num1 and num2 are not equal");} // True if num1 is not equal to num2
    if(num1 < num2){System.out.println("num1 is less than num2");} // True if num1 is less than num2
    if(num1 > num2){System.out.println("num1 is grater than num2");} // True if num1 is greater num2
    if(num1 <= num2){System.out.println("num1 is less than or equal to num2");} // True if num1 is less than or equal to num2
    if(num1 >= num2){System.out.println("num1 is greater than or equal to num2");} // True if num1 is grater than or equal to num2

    boolean a = true;  boolean b = false;
    if(a || b){System.out.println("num1 is true or num2 is true or both are true");} // True if 'a' OR 'b' are true
    if(a && b){System.out.println("num1 and num2 are true");} // True if 'a' AND 'b' are true
}