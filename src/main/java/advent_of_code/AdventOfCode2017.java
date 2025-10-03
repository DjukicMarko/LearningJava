package advent_of_code;

import static days.DayOne.getFilesString;

import days.DayOne;
import java.io.IOException;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdventOfCode2017 {

    public static void main(String[] args) throws IOException {
        String string = getFilesString();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter task's part to run (1 or 2): ");
        int input = scanner.nextInt();
        scanner.nextLine();

        DayOne dayOne = new DayOne();
        int i = dayOne.solveTask(string, input);
        log.info("Task's part {} solution is: {}", input, i);

        System.out.print("Do you wish to solve other part of the task? Y/N: ");
        String s = scanner.nextLine();

        if (s.equalsIgnoreCase("Y")) {
            int secondInput = (input == 1) ? 2 : input;
            int result2 = dayOne.solveTask(string, secondInput);
            log.info("Task's part {} solution is: {}", secondInput, result2);
        } else {
            log.info("You solved only task part {}", input);
        }
    }
}
