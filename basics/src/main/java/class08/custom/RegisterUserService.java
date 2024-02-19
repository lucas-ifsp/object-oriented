package class08.custom;

import java.util.Objects;
import java.util.UUID;

public class RegisterUserService {
    private final UserRepository repository;

    private RegisterUserService(UserRepository repository){ // dependency injection
        this.repository = repository;
    }

    public void register(String email){
        Objects.requireNonNull(email, "Email must not be null."); // may throw a NullPointerException
        if(isValidEmail(email)) throw new IllegalArgumentException("Invalid email format.");
        if(repository.existsByEmail(email)) throw new EntityAlreadyExistsException("Email is already registered.");

        final UUID id = UUID.randomUUID(); // generates an universally unique identifier
        repository.save(new User(id, email));
    }

    private boolean isValidEmail(String email) {
        return !email.isBlank(); // a better implementation with regex goes here ...
    }
}
