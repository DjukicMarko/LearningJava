package days;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class AdventOfCodeTest {

    DayOne dayOne = new DayOne();
    String input = "dummy_input";

    @Test
    @DisplayName("Test solving first part of the task")
    void testSolveTask() throws IOException {
        int result = dayOne.solveTask(input, 1);
        assertEquals(1144, result);
    }

    @Test
    @DisplayName("Test solving second part of the task")
    void testSolveTaskSecondPart() throws IOException {
        int result = dayOne.solveTask(input, 2);
        assertEquals(1194, result);
    }

    @Test
    @DisplayName("Test solving task using invalid int")
    void testSolveTaskThirdPart() {
        assertThrows(IllegalArgumentException.class, () -> dayOne.solveTask(input, 3));
    }

    @Test
    @DisplayName("Test solving task where input has null value")
    void testSolveTaskNullValue() {
        assertThrows(NullPointerException.class, () -> dayOne.solveTask(null, 1));
    }

    @Test
    @DisplayName("Test solving task where task part is 0")
    void testSolveTaskNullTaskPart() {
        assertThrows(IllegalArgumentException.class, () -> dayOne.solveTask(input, 0));
    }
}
