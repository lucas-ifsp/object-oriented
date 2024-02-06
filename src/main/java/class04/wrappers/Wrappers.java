void main() {
    //Integer value = new Integer(10); // Error! The conventional constructor is deprecated
    Integer integerFromString = Integer.valueOf("10"); // Static factory method using String
    Integer withoutAutoboxing = Integer.valueOf(10); // Static factory method using int
    Integer withAutoboxing = 10; // the same, but simpler

    int withoutUnboxing = withoutAutoboxing.intValue();
    int withUnboxing = withoutAutoboxing; // the same, but simpler
    int fromStringToPrimitive = Integer.parseInt("10"); // all similar primitives have the same type of method

    final double doubleValue = integerFromString.doubleValue();
    System.out.println("doubleValue = " + doubleValue); // 10.0

    Integer sum = 0;
    for (int i = 0; i < 100_000; i++) {
        sum += Integer.valueOf(i); // unnecessary use of wrapper
    }
    System.out.println("Sum: " + sum);
}