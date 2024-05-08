package practical02;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryDeclaracaoRepository implements DeclaracaoRepository {

    private static final Map<Long, Declaracao> db = new LinkedHashMap<>();

    public void salvar(Declaracao declaracao) {
        if(db.containsKey(declaracao.getId()))
            throw new EntityAlreadyExistsException(STR."Declaração com id já cadastrado: \{declaracao.getId()}");
        db.put(declaracao.getId(), declaracao);
    }

    public Optional<Declaracao> buscar(long id) {
        return Optional.ofNullable(db.get(id));
    }
}
