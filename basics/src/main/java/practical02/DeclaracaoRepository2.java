package practical02;

import java.util.LinkedHashMap;
import java.util.Map;

public class DeclaracaoRepository2 extends GenericRepository<Long, Declaracao> {
    private static final Map<Long, Declaracao> db = new LinkedHashMap<>();

    @Override
    protected Map<Long, Declaracao> getDatabase() {
        return db;
    }
}
