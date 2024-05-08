package practical02;

import java.util.Optional;

public interface DeclaracaoRepository {
    void salvar(Declaracao declaracao) ;
    Optional<Declaracao> buscar(long id) ;
}
