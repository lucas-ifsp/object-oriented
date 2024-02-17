package class08.optional;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    boolean existsByEmail(String email);
    void save(User user);
    Optional<User> findOne(UUID id);
}
