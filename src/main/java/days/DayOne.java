package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DayOne {

    public int solveTask(int tasksPart) throws FileNotFoundException {
        String content = getFilesString();

        int result = 0;

        if (tasksPart == 1) {
            int i = solveFirst(content);
            result = i;
        } else if (tasksPart == 2) {
            int i1 = solveSecond(content);
            result = i1;
        } else {
            throw new IllegalArgumentException();
        }

        return result;
    }

    private int solveFirst(String content) {
        int addition = 0;

        for (int i = 0; i < content.length() - 1; i++) {
            char charFirst = content.charAt(i);
            char nextChar = content.charAt(i + 1);

            if (charFirst == nextChar) {
                addition += Character.getNumericValue(charFirst);
            }
        }
        if (content.charAt(content.length() - 1) == content.charAt(0)) {
            addition += Character.getNumericValue(content.charAt(0));
        }

        return addition;
    }

    private int solveSecond(String content) {
        int addition = 0;
        int half = content.length() / 2;

        for (int i = 0; i < content.length(); i++) {
            char charFirst = content.charAt(i);
            char nextChar = content.charAt((i + half) % content.length());

            if (charFirst == nextChar) {
                addition += Character.getNumericValue(charFirst);
            }

        }

        return addition;
    }

    private static String getFilesString() throws FileNotFoundException {
        File file = new File("src/main/resources/input.txt");
        String content = "";

        try {
            content = new String(Files.readAllBytes(file.toPath())).trim();
        } catch (IOException e) {
            throw new FileNotFoundException();
        }

        return content;
    }

}
