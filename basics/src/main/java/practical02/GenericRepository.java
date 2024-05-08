package practical02;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class GenericRepository <K, T extends Entity<K>>{

    protected abstract Map<K, T> getDatabase();

    void save(T type){
        getDatabase().put(type.key(), type);
    }

    void update(T type){
        getDatabase().replace(type.key(), type);
    }

    void delete(T type){
        getDatabase().remove(type);
    }

    void deleteByKey(K key){
        getDatabase().remove(key);
    }

    Optional<T> findById(K key){
        return Optional.ofNullable(getDatabase().get(key));
    }

    List<T> findAll(){
        return getDatabase().values().stream().toList();
    }

}
