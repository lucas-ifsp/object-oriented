package class06.generics;

public class ConsoleExporter implements Exporter {
    @Override
    public void export(String content, String destination) {
        System.out.println(content);
    }
}
