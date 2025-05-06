package practical02.persistence;

import class03.Employee;

import java.util.Optional;

public interface Repository <E, K>{
    //save, update e findById

    void save(E type);
    void update(E type);
    Optional<E> findById(K id);
}
