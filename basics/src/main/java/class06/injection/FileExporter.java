package class06.injection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class FileExporter implements Exporter{
    @Override
    public void export(String content, String destination) {
        File file = new File(destination);
        try (FileWriter writer = new FileWriter(file)){
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
