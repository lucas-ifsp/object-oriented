package class06.injection;

public class ExporterFactory {
    private ExporterFactory(){}

    public static Exporter forProductionEnvironment(){
        return new FileExporter();
    }

    public static Exporter forTestingEnvironment(){
        return new ConsoleExporter();
    }
}
