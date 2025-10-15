package days;

import advent_of_code.AdventOfCode2017;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DayOne {

    public int solveTask(String input, int taskPart) throws IOException {
        int shift;

        if (input == null) {
            throw new NullPointerException("Input string is null");
        }

        if (taskPart == 1) {
            shift = 1;
        } else if (taskPart == 2) {
            shift = (getFilesString().length() / 2);
        } else {
            throw new IllegalArgumentException("Invalid task part");
        }
        return resolve(shift);

    }

    public static String getFilesString() throws IOException {
        try (InputStream inputStream = AdventOfCode2017.class.getResourceAsStream("/input.txt")) {
            if (inputStream == null) {
                throw new FileNotFoundException("Resource not found: input.txt");
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8).trim();
        }

    }

    private int resolve(int shift) throws IOException {
        int result = 0;
        String input = getFilesString();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt((i + shift) % input.length())) {
                result += Character.getNumericValue(input.charAt(i));
            }
        }
        return result;
    }
}
