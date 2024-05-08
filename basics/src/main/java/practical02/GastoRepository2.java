package practical02;

import java.util.LinkedHashMap;
import java.util.Map;

public class GastoRepository2 extends GenericRepository<Long, Gasto> {
    private static final Map<Long, Gasto> db = new LinkedHashMap<>();

    @Override
    protected Map<Long, Gasto> getDatabase() {
        return db;
    }
}
