package doo.factory;

import java.util.List;

public interface ReportFormatter {
    <T extends Reportable> String format(List<T> content);
}
