import class08.optional.User;

import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

void main() {
    final Scanner scanner = new Scanner(System.in);
    final String email = scanner.nextLine();

    Optional<String> empty = Optional.empty();  // Represents the concept of emptiness
    Optional<String> mayBeNull = Optional.ofNullable(email); // If the email is null, creates Optional.empty
    Optional<String> notNull = Optional.of("Something"); // If the input is null, throws NullPointerException

    if(mayBeNull.isPresent()) // check if the object is not empty (same as !mayBeNull.isEmpty()
        System.out.println(mayBeNull.get()); // only use if you are sure the object is not empty. Otherwise, it may throw NoSuchElementException

    mayBeNull.ifPresent(System.out::println); // the same, but in functional style
    System.out.println(empty); // It prints Optional.empty

    System.out.println(notNull.orElse("No content"));
}