package class08.custom;

import java.util.UUID;

public interface UserRepository {
    boolean existsByEmail(String email);
    void save(User user);
}
