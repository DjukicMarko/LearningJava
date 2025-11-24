package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    private FileUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String readResourceFile(String fileName) throws IOException {
        try (InputStream inputStream = FileUtils.class.getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new FileNotFoundException("Resource not found: " + fileName);
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8).trim();
        }
    }
}
