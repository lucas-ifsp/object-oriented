package class08.optional;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

public class FindUserService {
    private final UserRepository repository;

    private FindUserService(UserRepository repository){ // dependency injection
        this.repository = repository;
    }

//    public String findEmailBy(UUID id){
//        final UUID uuid = Objects.requireNonNull(id, "Id must not be null.");
//        User user = repository.findOne(uuid);
//        if(user == null) throw new NoSuchElementException("User not found.");
//        return user.getEmail();
//    }

    public String findEmailBy(UUID id){
        return repository.findOne(Objects.requireNonNull(id, "Id must not be null.")) // It returns Optional<User>
                .map(User::getEmail) // It only executes if the return of findOne is non-null
                .orElseThrow(NoSuchElementException::new); // throw an exception or get a default value (orElse())
    }

}
