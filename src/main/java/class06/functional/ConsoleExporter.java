package class06.functional;

public class ConsoleExporter implements Exporter {
    @Override
    public void export(String content, String destination) {
        System.out.println(content);
    }
}
