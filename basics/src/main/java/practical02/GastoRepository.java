package practical02;

import java.util.*;

public class GastoRepository {
    private static final Map<Long, Gasto> db = new LinkedHashMap<>();
    private static long nextId = 1;

    public void salvar(Gasto gasto) {
        if(db.containsKey(gasto.getId()))
            throw new EntityAlreadyExistsException(STR."Gasto com id já cadastrado: \{gasto.getId()}");
        db.put(gasto.getId(), gasto);
    }

    public Optional<Gasto> buscar(Long id) {
        return Optional.ofNullable(db.get(id));
    }


    public static long nextId(){
        return nextId++;
    }

    public void remover(long id) {
        db.remove(id);
    }
}
