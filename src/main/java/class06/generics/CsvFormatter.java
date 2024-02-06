package class06.generics;

import java.util.StringJoiner;

public class CsvFormatter <T extends Reportable> implements Formatter<T> {
    @Override
    public String format(T[] elements) {
        StringJoiner joiner = new StringJoiner("\n");
        for (T t : elements) {
            // it is not necessary to cast => Reportable reportable = (Reportable) t;
            final String[] content = t.reportContent();
            joiner.add(String.join(",", content));
        }
        return joiner.toString();
    }
}
