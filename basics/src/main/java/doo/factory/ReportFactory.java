package doo.factory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class ReportFactory {
    public <T extends Reportable> void export(List<T> data, String destination) throws IOException {
        ReportFormatter formatter = createFormatter();
        String output = formatter.format(data);
        File file = new File(destination);
        try (FileWriter writer = new FileWriter(file)){
            writer.write(output);
        }
    }
    // Factory method
    protected abstract ReportFormatter createFormatter();
}
