import java.util.StringJoiner;

void main() {
    String text = "Hello";
    text += " World!"; // creates the String " world!" and a new String "Hello World!"
    for (char c : text.toCharArray())
        System.out.print(c); // prints Hello World! char by char

    System.out.println("Char at index 4: " + text.charAt(4)); // prints 'o'
    System.out.println("Index of 'o': " + text.indexOf('o')); // prints 4
    System.out.println("Length of char array: " + text.length()); // prints 12

    String literalA = "Object-oriented";
    String literalB = "Object-oriented";
    String objectA = new String("Object-oriented");
    String objectB = new String("Object-oriented");

    System.out.println(literalA == literalB); // true because they point to the same object in the string pool
    System.out.println(objectA == objectB);  // false because they point to different objects in the heap
    System.out.println(literalA == objectA); // false because one object is in the string pool end the other is not
    System.out.println(literalA.equals(objectA)); // true because equals compare by content, not reference

    String phrase = "Talk is cheap. Show me the code.";
    System.out.println(phrase.toUpperCase()); // TALK IS CHEAP. SHOW ME THE CODE.
    System.out.println(phrase.toLowerCase()); // talk is cheap. show me the code.
    System.out.println(phrase.equalsIgnoreCase(phrase.toLowerCase())); // true
    System.out.println(phrase.substring(0, 4)); // Talk - substring from indexes 0 to 3
    System.out.println(phrase.replace("code", "money")); // Talk is cheap. Show me the money.

    final String[] sentences = phrase.split("\\."); // ["Talk is cheap", " Show me the code"]
    for (String sentence : sentences)
        System.out.println(sentence.trim()); // trim removes trailing and leading blank spaces


    String val1 = "object-orientation";
    String val2 = val1 + " with Java";
    System.out.println(val2); // object-orientation with Java
    System.out.println(val1 + " is " + null + " times better."); // object-orientation is null times better.

    String val3 = String.format("I've been studying %s for %.2f weeks.", val2, Math.PI);
    System.out.println(val3); // I've been studying object-orientation with Java for 3.14 weeks.

    // The same as +, but concat only accepts Strings, does not handle nulls, and only deals with two Strings at a time.
    System.out.println(val3.concat(" That is cool!")); // I've been studying object-orientation with Java for 3.14 weeks. That is cool!


    String result = "";
    for (int i = 0; i < 100_000; i++) {
        result += " " + i; // a new String is created in each iteration. Extremely inefficient!
    }
    System.out.println(result);

    StringBuilder builder = new StringBuilder(); // creates an array
    for (int i = 0; i < 100; i++) {
        builder.append(" ").append(i); // builds the String content
    }
    System.out.println(builder); // and only then creates a result String
    System.out.println(builder.reverse()); // there are also supporting methods to manipulate the char array


    StringJoiner joiner = new StringJoiner(", ", "[", "]"); // delimiter, prefix, suffix
    for (int i = 0; i < 10; i++) {
        joiner.add(String.valueOf(i)); // It only accepts Strings - and there is factory method for each primitive ;)
    }
    System.out.println(joiner); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

    String[] content = {"Java", "is", "cool!"};
    System.out.println(String.join(" ", content)); // The first parameter is the delimiter. Java is cool!

    String language = "Java";
    int version = 25;
    String adjective = "awesome";

    final String json = String.format(
            """
            {
                "language":"%s",
                "version":%d,
                "adjective":"%s"
            }
            """, language, version, adjective);
    System.out.println(json);
}