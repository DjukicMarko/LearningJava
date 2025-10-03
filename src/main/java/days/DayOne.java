package days;

import advent_of_code.AdventOfCode2017;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DayOne {

    public int solveTask(String input, int taskPart) {
        int result = 0;
        int half = input.length() / 2;

        if (taskPart == 1) {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == input.charAt((i + 1) % input.length())) {
                    result += Character.getNumericValue(input.charAt(i));
                }
            }
        } else if (taskPart == 2) {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == input.charAt((i + half) % input.length())) {
                    result += Character.getNumericValue(input.charAt(i));
                }
            }
        }

        return result;
    }


    public static String getFilesString() throws IOException {
        try (InputStream inputStream = AdventOfCode2017.class.getResourceAsStream("/input.txt")) {
            if (inputStream == null) {
                throw new FileNotFoundException("Resource not found: input.txt");
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8).trim();
        }

    }

}
