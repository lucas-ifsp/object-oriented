package class06.generics;

@FunctionalInterface
public interface Exporter {
    void export(String content, String destination);
}
