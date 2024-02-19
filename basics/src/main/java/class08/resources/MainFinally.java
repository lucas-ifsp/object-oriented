import class08.resources.MyResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

void main() {
    //System.out.println(readFile("legends.csv")); // main should handle or throw (and exit with error in case of an exception)
    try(final MyResource resource = new MyResource()){
        resource.doSomething();
    }
}

public static String readFile(String fileName) {
    Objects.requireNonNull(fileName, "File name must not be null!");
    File file = new File(fileName);
    Stream<String> lines = null;
    try {
        lines = Files.lines(file.toPath());
        return lines.collect(Collectors.joining("\n"));
    } catch (IOException e) {
        System.err.println("File not found!");
    } finally {
        if (lines != null) lines.close();
    }
    return "";
}

public static String readFileThatThrows(String fileName) throws IOException {
    Objects.requireNonNull(fileName, "File name must not be null!");
    File file = new File(fileName);
    Stream<String> lines = null;
    try {
        lines = Files.lines(file.toPath());
        return lines.collect(Collectors.joining("\n"));
    } finally {
        if (lines != null) lines.close();
    }
}

public static String readFileHandlingResources(String fileName) throws IOException {
    Objects.requireNonNull(fileName, "File name must not be null!");
    File file = new File(fileName);
    try (Stream<String> lines = Files.lines(file.toPath())) { // the Stream will be closed when the program leaves the try block
        return lines.collect(Collectors.joining("\n"));
    }
}