package part1_syntax;

/**
 * Part 1. Syntax
 * Demonstrates methods, arguments, return values,
 * and decomposition into methods and sub-methods.
 */
public class Part1Syntax {

    public static void main(String[] args) {

        // Part 1.1. Methods with different arguments and argument counts.
        printMessage();
        printMessage("Hello from a method with one String argument.");
        printNumbers(10, 20);

        // Part 1.2. Method without a return value.
        printSeparator();

        // Part 1.3. Methods with different return types.
        int sum = addNumbers(7, 5);
        double average = calculateAverage(8.0, 10.0);
        String greeting = createGreeting("Student");

        System.out.println("Returned int value: " + sum);
        System.out.println("Returned double value: " + average);
        System.out.println("Returned String value: " + greeting);

        // Part 1.4. Decomposition into methods.
        demonstrateDecomposition();
    }

    // Part 1.1. Method with 0 arguments.
    public static void printMessage() {
        System.out.println("Method with 0 arguments.");
    }

    // Part 1.1. Method with 1 String argument.
    public static void printMessage(String message) {
        System.out.println(message);
    }

    // Part 1.1. Method with 2 int arguments.
    public static void printNumbers(int first, int second) {
        System.out.println("Two numbers: " + first + " and " + second);
    }

    // Part 1.2. Method without a return value.
    public static void printSeparator() {
        System.out.println("------------------------------------------");
    }

    // Part 1.3. Method returning int.
    public static int addNumbers(int first, int second) {
        return first + second;
    }

    // Part 1.3. Method returning double.
    public static double calculateAverage(double first, double second) {
        return (first + second) / 2;
    }

    // Part 1.3. Method returning String.
    public static String createGreeting(String name) {
        return "Hello, " + name + "!";
    }

    // Part 1.4. Main decomposition method.
    public static void demonstrateDecomposition() {

        System.out.println("\nPart 1.4. Decomposition into methods:");

        printSeparator();

        int result = calculateAndDisplaySum(12, 8);

        displayResult(result);

        printSeparator();
    }

    // Part 1.4. Method calling other custom methods.
    public static int calculateAndDisplaySum(int first, int second) {

        printCalculation(first, second);

        return addNumbers(first, second);
    }

    // Part 1.4. Sub-method.
    public static void printCalculation(int first, int second) {

        System.out.println("Calculating: " + first + " + " + second);
    }

    // Part 1.4. Sub-method.
    public static void displayResult(int result) {

        System.out.println("Calculation result: " + result);
    }
}