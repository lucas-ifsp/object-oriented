import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;
import java.util.stream.Collectors;

void main(){
    try {
        System.out.println(readFile("legends.csv")); // main should handle or throw (and exit with error in case of an exception)
    } catch (IOException e) {
        System.err.println("File not found!");
    }
}

public static String readFile(String fileName) throws IOException {
    Objects.requireNonNull(fileName, "File name must not be null!"); // same as if(fileName == null) throw new NullPointerException(...);
    File file = new File(fileName);
    return Files.lines(file.toPath()).collect(Collectors.joining("\n"));
}