package practical02;

import java.util.*;

public class FakeDeclaracaoRepository implements DeclaracaoRepository {
    private final static Map<Long, Declaracao> db = new LinkedHashMap<>();

    @Override
    public void save(Declaracao declaracao) {
        if(db.containsKey(declaracao.getId()))
            throw new EntityAlreadyExistsException("Entity already exists");
        db.put(declaracao.getId(), declaracao);
    }

    @Override
    public void update(Declaracao declaracao) {
        var replaced = db.replace(declaracao.getId(), declaracao);
        if(null == replaced)
            throw new NoSuchElementException("Entity not found");
    }

    @Override
    public void delete(Long id) {
        var removed = db.remove(id);
        if(null == removed)
            throw new NoSuchElementException("Entity not found");
    }

    @Override
    public Optional<Declaracao> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public List<Declaracao> findAll(){
        return new ArrayList<>(db.values());
    }
}
