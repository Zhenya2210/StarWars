package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestHelper {

    public static String readJson(String fileName) throws IOException {
        String path = String.join(File.separator, "src", "main", "resources", "expected_result", "planets", fileName);
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
