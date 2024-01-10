void main() {

    int i;
    i = 10;

    String name = "Alan Turing"; // Strings are declared using double quotes

    System.out.println("i = " + i);
    System.out.println("name = " + name);

    double d = i; //Implicit conversion – No information loss
    d = 3.5;
    /* Explicit conversion (“cast”) - Decimal portion of the number is lost due to truncation
       This is a multi-line comment */
    i = (int) d;

    System.out.println("i = " + i);

    byte varByte = -128;
    varByte = 127;
    short varShort = -32768;
    varShort = 32767;
    int varInt = -2147483648;
    varInt = 2147483647;

    // long numbers end with L or l
    long varLong = -9223372036854775808L;
    varLong = 9223372036854775807L;

    // float numbers and with F or f
    float varFloat = -100.4345F;
    varFloat = 123243.4345f;

    double varDouble = -3123.434354;
    varDouble = 321321.3123435;
    boolean varBoolean = false;
    varBoolean = true;

    // Chars are declared using single quotes
    char varChar = 'a';
    varChar = 90; // Z unicode value

    System.out.println("varInt = " + varInt);
    System.out.println("varShort = " + varShort);
    System.out.println("varLong = " + varLong);
    System.out.println("varChar = " + varChar);
    System.out.println("varByte = " + varByte);
    System.out.println("varFloat = " + varFloat);
    System.out.println("varDouble = " + varDouble);
    System.out.println("varBoolean = " + varBoolean);

    final boolean CONST_1;
    final boolean CONST_2 = true;
    CONST_1 = false;

    //CONST_2 = false;
    // Compile-time error -> "Cannot assign a value to final variable 'CONST_2'"

    System.out.println("CONST_1 = " + CONST_1);
    System.out.println("CONST_2 = " + CONST_2);
}