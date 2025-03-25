package practical02;

import java.util.List;
import java.util.Optional;

public interface DeclaracaoRepository {
    void save(Declaracao declaracao);

    void update(Declaracao declaracao);

    void delete(Long id);

    Optional<Declaracao> findById(Long id);

    List<Declaracao> findAll();
}
