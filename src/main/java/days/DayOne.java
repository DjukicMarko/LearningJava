package days;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DayOne {

    public int solveTask(String input, int taskPart) {
        int shift;

        if (input == null) {
            throw new NullPointerException("Input string is null");
        }

        if (taskPart == 1) {
            shift = 1;
        } else if (taskPart == 2) {
            shift = (input.length() / 2);
        } else {
            throw new IllegalArgumentException("Invalid task part");
        }
        return resolve(input, shift);

    }

    private int resolve(String input, int shift) {
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt((i + shift) % input.length())) {
                result += Character.getNumericValue(input.charAt(i));
            }
        }
        return result;
    }
}
