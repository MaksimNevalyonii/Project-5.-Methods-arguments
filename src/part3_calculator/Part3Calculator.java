package part3_calculator;

import java.util.Scanner;

/**
 * Part 3. Optional Basic Calculator
 */
public class Part3Calculator {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Part 3.1. Get first operand.
        double firstOperand = getDouble("Enter first operand: ");

        boolean running = true;

        while (running) {

            // Part 3.2. Get operation.
            String operation = getOperation();

            // Part 3.3. Get second operand.
            double secondOperand =
                    getDouble("Enter second operand: ");

            double result;

            // Part 3.4. Select operation.
            switch (operation) {

                case "+":
                    result = add(firstOperand, secondOperand);
                    break;

                case "-":
                    result = subtract(firstOperand, secondOperand);
                    break;

                case "*":
                    result = multiply(firstOperand, secondOperand);
                    break;

                case "/":

                    if (secondOperand == 0) {

                        System.out.println(
                                "Error: division by zero is not allowed."
                        );

                        continue;
                    }

                    result = divide(firstOperand, secondOperand);
                    break;

                default:

                    System.out.println("Unknown operation.");
                    continue;
            }

            // Part 3.5. Print formatted result.
            System.out.printf(
                    "Result: %.2f %s %.2f = %.2f%n",
                    firstOperand,
                    operation,
                    secondOperand,
                    result
            );

            // Part 3.6. Ask whether to continue.
            String answer = getString(
                    "Continue with this result? (Y/N): "
            );

            if (answer.equalsIgnoreCase("y")) {

                // Part 3.7. Use previous result.
                firstOperand = result;

            } else {

                running = false;
            }
        }

        System.out.println("Calculator finished.");

        scanner.close();
    }

    // Part 3.8. String input method.
    public static String getString(String prompt) {

        System.out.print(prompt);

        return scanner.nextLine();
    }

    // Part 3.9. Double input method.
    public static double getDouble(String prompt) {

        while (true) {

            String input = getString(prompt);

            try {

                return Double.parseDouble(input);

            } catch (NumberFormatException exception) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    // Part 3.10. Operation input method.
    public static String getOperation() {

        while (true) {

            String operation = getString(
                    "Enter operation (+, -, *, /): "
            );

            if (operation.equals("+")
                    || operation.equals("-")
                    || operation.equals("*")
                    || operation.equals("/")) {

                return operation;
            }

            System.out.println(
                    "Please choose +, -, * or /."
            );
        }
    }

    // Part 3.11. Addition.
    public static double add(
            double first,
            double second) {

        return first + second;
    }

    // Part 3.12. Subtraction.
    public static double subtract(
            double first,
            double second) {

        return first - second;
    }

    // Part 3.13. Multiplication.
    public static double multiply(
            double first,
            double second) {

        return first * second;
    }

    // Part 3.14. Division.
    public static double divide(
            double first,
            double second) {

        return first / second;
    }
}